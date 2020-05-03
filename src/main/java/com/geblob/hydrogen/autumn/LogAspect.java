package com.geblob.hydrogen.autumn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {
    @Pointcut("execution(public int MathCalculator.*(..))")
    public void pointCut() {
    }


    @Before("pointCut()")
    private void logStart(JoinPoint joinPoint) {
        System.out.println("logStart ");
    }

    @After("pointCut()")
    private void logEnd(JoinPoint joinPoint) {
        System.out.println("logEnd ");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("logReturn " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("exception " + exception);
    }
}
