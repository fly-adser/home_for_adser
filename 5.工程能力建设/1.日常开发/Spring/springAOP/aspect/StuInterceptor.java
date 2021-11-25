package springAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class StuInterceptor {

    @Pointcut("execution(* springAOP.aspect.Student.print(..))")
    public void printMethod(){
    }

    @Before("printMethod()")
    public void printBeforeAdvice(){
        System.out.println("printBeforeAdvice!");
    }

    @AfterReturning(pointcut="printMethod()", returning="flag")
    public void printAfterAdvice(String flag){
        System.out.println("printAfterAdvice()!" + flag);
    }

    @After("printMethod()")
    public void printFinallyAdvice(){
        System.out.println("printFinally" +
                "Advice!");
    }

    @Around("printMethod() && args(name)")
    public Object printAroundAdvice(ProceedingJoinPoint pjp, String name) throws Throwable{
        Object obeject = null;
        if(name.equals("Jay Chou"))
            pjp.proceed();
        else
            System.out.println("print()方法已经被拦截！！");

        return obeject;
    }
}
