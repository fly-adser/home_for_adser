package springAOP.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class StuInterceptor {

    public void printMethod(){
    }

    public void printBeforeAdvice(){
        System.out.println("printBeforeAdvice!");
    }

    public void printAfterAdvice(String flag){
        System.out.println("printAfterAdvice()!" + flag);
    }

    public void printFinallyAdvice(){
        System.out.println("printFinally" + "Advice!");
    }

    public Object printAroundAdvice(ProceedingJoinPoint pjp, String name) throws Throwable{
        Object obeject = null;
        if(name.equals("Jay Chou"))
            pjp.proceed();
        else
            System.out.println("print()方法已经被拦截！！");

        return obeject;
    }
}