package springIOC.realize;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {

    private Map<String, Object> beanMap = new HashMap<String, Object>();

    /**
     * bean工厂的初始化，通过xml文件给对象注入相关属性
     * @param xml xml配置文件
     */
    public void init(String xml){
        try{
            //1.创建读取配置文件的reader对象
            SAXReader reader = new SAXReader();

            //2.获取当前线程中的类装载器对象
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            //3.从class目录下获取指定的xml文件
            InputStream ins = classLoader.getResourceAsStream(xml);
            Document doc    = reader.read(ins);
            Element root    = doc.getRootElement();
            Element foo;

            //4.遍历xml文件中的bean实例
            for(Iterator i=root.elementIterator("bean"); i.hasNext();){
                foo = (Element) i.next();

                //5.针对每个bean实例，获取bean的属性id和class
                Attribute id  = foo.attribute("id");
                Attribute cls = foo.attribute("class");

                //6.利用java反射机制，通过class名称获取class对象
                Class bean = Class.forName(cls.getText());

                //7.获取对应class信息
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);

                //8.获取其属性信息
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();

                //9.创建一个对象，并在接下来的代码中为对象的属性赋值
                Object obj = bean.getDeclaredConstructor().newInstance();

                //10.遍历该bean的property属性
                for(Iterator ite=foo.elementIterator("property"); ite.hasNext();){
                    Element foo2 = (Element)ite.next();

                    //11.获取该property的name属性
                    Attribute name = foo2.attribute("name");
                    String   value = null;

                    //12.获取该property的子元素value的值
                    for(Iterator ite1=foo2.elementIterator("value"); ite1.hasNext();){
                        Element node = (Element)ite.next();
                        value = node.getText();
                        break;
                    }

                    //13.利用java的反射机制调用对象的某个set方法，并将值设置进去
                    for(int k=0; k<pd.length; k++){
                        if(pd[k].getName().equalsIgnoreCase(name.getText())){
                            Method mSet = null;
                            mSet = pd[k].getWriteMethod();
                            mSet.invoke(obj, value);
                        }
                    }
                }

                //14.将对象放入beanMap中，其中key为id值，value为对象
                beanMap.put(id.getText(), obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Object getBean(String beanName){
        Object obj = beanMap.get(beanName);

        return obj;
    }

    public static void main(String[] args){
        BeanFactory factory = new BeanFactory();
        factory.init("resource/config-realize.xml");
        JavaBean javaBean = (JavaBean)factory.getBean("javaBean");
        System.out.println("userName=" + javaBean.getUserName());
        System.out.println("password=" + javaBean.getPassword());
    }
}
