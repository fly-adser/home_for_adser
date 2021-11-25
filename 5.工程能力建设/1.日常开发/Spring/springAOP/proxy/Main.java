package springAOP.proxy;

public class Main {

    public static void main(String[] args){

        StudentInterface s1  = new StudentBean();
        ProxyFactory factory = new ProxyFactory();
        StudentInterface s2  = (StudentInterface)factory.createStudentProxy(s1);
        s2.print();
    }
}
