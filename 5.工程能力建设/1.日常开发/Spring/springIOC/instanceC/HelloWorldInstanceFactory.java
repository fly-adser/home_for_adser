package springIOC.instanceC;

import springIOC.instanceA.HelloWorld;
import springIOC.instanceA.HelloWorldImpl;

public class HelloWorldInstanceFactory {

    public HelloWorld newInstance(String message) {
        return new HelloWorldImpl(message);
    }
}
