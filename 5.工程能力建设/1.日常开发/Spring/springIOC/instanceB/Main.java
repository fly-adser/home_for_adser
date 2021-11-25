package springIOC.instanceB;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springIOC.instanceA.HelloWorld;

public class Main {
    public static void main(String[] args){
        helloWorldStaticFactory();
    }

    //使用静态工厂方法来实例化Bean
    public static void helloWorldStaticFactory(){
        //1.读取配置文件实例化一个IOC容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("resource/conf-instanceB.xml");

        //2.从容器中获取Bean
        HelloWorld helloWorld   = beanFactory.getBean("helloWorldStaticFactory", HelloWorld.class);

        //3.执行业务逻辑
        helloWorld.sayHello();
    }
}
