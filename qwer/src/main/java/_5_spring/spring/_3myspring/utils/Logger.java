package _5_spring.spring._3myspring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect //表示当前类是一个切面类
/**
 * 注解方式的后置和最终顺序是错的 和xml方式的相反
 */
public class Logger {

    @Pointcut("execution(* _5_spring.spring._3myspring.service.AccountServiceImpl.*(..))")
    private void p1() {
    }

//    @Before("p1()")
    public void printLog1() {
        System.out.println("Logger类中的printLog方法开始记录日志了1 Before");
    }

//    @After("p1()")
    public void printLog4() {
        System.out.println("Logger类中的printLog方法开始记录日志了2 After");
    }

//    @AfterReturning("p1()")
    public void printLog2() {
        System.out.println("Logger类中的printLog方法开始记录日志了3 AfterReturning");
    }

//    @AfterThrowing("p1()")
    public void printLog3() {
        System.out.println("Logger类中的printLog方法开始记录日志了4 AfterThrowing");
    }



    /**
     * 环绕通知 需要明确的切入点方法调用，spring为我们提供了接口ProceedingJoinPoint
     * 中的proceed()方法，相当于调用切入点方法
     * 切入点方法写在proceed的上面就是前置通知，下面后置通知，catch块异常通知，finally块最终通知
     */
    @Around("p1()")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Logger类中的printLog方法开始记录日志了around1前置通知");
            joinPoint.proceed();
            System.out.println("Logger类中的printLog方法开始记录日志了around2后置通知");
        } catch (Throwable e) {
            System.out.println("Logger类中的printLog方法开始记录日志了around3异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Logger类中的printLog方法开始记录日志了around4最终通知");
        }
    }
}
