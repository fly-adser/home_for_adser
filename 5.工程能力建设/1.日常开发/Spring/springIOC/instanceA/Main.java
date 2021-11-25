package springIOC.instanceA;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        sayHelloWithArgs();
        sayHelloWithNoArgs();
    }

    //使用无参数构造器来实例化Bean
    public static void sayHelloWithNoArgs(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("resource/conf-instanceA.xml");
        HelloWorld helloWorld   = beanFactory.getBean("helloWorldWithNoArgs", HelloWorld.class);
        helloWorld.sayHello();
    }

    //使用有参数构造器来实例化Bean
    public static void sayHelloWithArgs(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("resource/conf-instanceA.xml");
        HelloWorld helloWorld   = beanFactory.getBean("helloWorldWithArgs", HelloWorld.class);
        helloWorld.sayHello();
    }
}
