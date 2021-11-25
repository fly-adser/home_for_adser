package springAOP.aspect;

public class Student {

    public String print(String name){
        System.out.println(name);

        return "Hello World";
    }
}
