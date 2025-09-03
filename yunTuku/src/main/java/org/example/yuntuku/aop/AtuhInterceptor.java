package org.example.yuntuku.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.yuntuku.annotation.AuthCheck;

@Aspect
public class AtuhInterceptor {

    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint proceedingJoinPoint, AuthCheck authCheck){
        String role = authCheck.mustRole();

    }

}
