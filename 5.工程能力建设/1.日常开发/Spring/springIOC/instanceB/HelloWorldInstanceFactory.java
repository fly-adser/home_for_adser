package springIOC.instanceB;

import springIOC.instanceA.HelloWorld;
import springIOC.instanceA.HelloWorldImpl;

public class HelloWorldInstanceFactory {
    /**
     * 工厂方法
     */

    public static HelloWorld newInstance(String message){

        return new HelloWorldImpl(message);
    }
}
