package springIOC.scope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("resource/conf-scope.xml");
        Boss boss1 = beanFactory.getBean("boss1", Boss.class);
        Boss boss2 = beanFactory.getBean("boss2", Boss.class);
        Boss boss3 = beanFactory.getBean("boss3", Boss.class);
        System.out.println(boss1.getCar());
        System.out.println(boss2.getCar());
        System.out.println(boss3.getCar());
    }
}
