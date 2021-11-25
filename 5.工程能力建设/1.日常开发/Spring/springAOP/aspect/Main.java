package springAOP.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resource/conf-aspect.xml");
        Student stu = (Student)ctx.getBean("stu");
        stu.print("Jay Chou");
    }
}
