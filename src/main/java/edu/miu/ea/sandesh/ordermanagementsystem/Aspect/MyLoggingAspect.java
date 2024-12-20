package edu.miu.ea.sandesh.ordermanagementsystem.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    @AfterThrowing(value = "execution(* edu.miu.ea.sandesh.ordermanagementsystem.*.*.*.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex) {
        System.out.println("Throwing error in..." + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("Error message -> " + ex.getMessage());
    }
}
