package fr.romaingervais.imt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    // execution(* fr.romaingervais..*.*(..))
    // within(fr.romaingervais..*)
    @Around("execution(* fr.romaingervais..*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("DEBUT " + joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        System.out.println("FIN " + joinPoint.getSignature().getName());
        return proceed;
    }
}
