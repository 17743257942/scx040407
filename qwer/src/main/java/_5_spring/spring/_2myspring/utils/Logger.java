package _5_spring.spring._2myspring.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public void printLog1() {
        System.out.println("Logger类中的printLog方法开始记录日志了1");
    }

    public void printLog2() {
        System.out.println("Logger类中的printLog方法开始记录日志了2");
    }

    public void printLog3() {
        System.out.println("Logger类中的printLog方法开始记录日志了3");
    }

    public void printLog4() {
        System.out.println("Logger类中的printLog方法开始记录日志了4");
    }

    /**
     * 环绕通知 需要明确的切入点方法调用，spring为我们提供了接口ProceedingJoinPoint
     * 中的proceed()方法，相当于调用切入点方法
     * 切入点方法写在proceed的上面就是前置通知，下面后置通知，catch块异常通知，finally块最终通知
     */
    public void around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("Logger类中的printLog方法开始记录日志了around1");
            pjp.proceed(pjp.getArgs());
            System.out.println("Logger类中的printLog方法开始记录日志了around2");
        } catch (Throwable e) {
            System.out.println("Logger类中的printLog方法开始记录日志了around3");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Logger类中的printLog方法开始记录日志了around4");
        }
    }
}
