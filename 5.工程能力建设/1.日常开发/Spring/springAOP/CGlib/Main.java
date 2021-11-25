package springAOP.CGlib;

public class Main {

    public static void main(String[] args){
        StudentBean s1 = (StudentBean)(new CGLibProxyFactory()).createStudent(new StudentBean());
        StudentBean s2 = (StudentBean)(new CGLibProxyFactory()).createStudent(new StudentBean("Leon"));

        s1.print();
        s2.print();
    }
}
