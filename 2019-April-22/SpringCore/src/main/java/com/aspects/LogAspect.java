package com.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.beans.*.*(..))")
    //public void log(){
    public void log(JoinPoint joinPoint){
        System.out.println("LogAspect.log: "
                                + joinPoint.getSignature().getName()
                                + " on instance: "
                                + joinPoint.getTarget().getClass().getName());
    }


    //@Around("@annotation(com.aspects.annotation.Monitor)")
    @Around("@within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository)")
    public Object calcExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{

        //Before
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(joinPoint.getSignature().getName());

        //Invoke the actual method
        try {
            Object result =  joinPoint.proceed(joinPoint.getArgs());
            //After
            stopWatch.stop();
            System.out.println("Exec Time for: " + joinPoint.getSignature().getName());
            System.out.println(stopWatch.prettyPrint());
            return result;
        }catch (Throwable ex){

            //After exception
            throw ex;

        }



    }
}
