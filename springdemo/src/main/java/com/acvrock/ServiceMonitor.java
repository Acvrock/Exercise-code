package com.acvrock;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by moon on 28/10/2016.
 *
 * @Description:
 */
@Aspect
@Component
public class ServiceMonitor {

    @AfterReturning("execution(* com..*Client.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed12121: " + joinPoint);
    }

}