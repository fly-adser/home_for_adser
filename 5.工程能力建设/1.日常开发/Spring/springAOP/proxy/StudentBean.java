package springAOP.proxy;

import com.sun.jdi.request.InvalidRequestStateException;

public class StudentBean implements StudentInterface{

    private String name;

    public StudentBean(){}

    public StudentBean(String name){
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Hello World!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
