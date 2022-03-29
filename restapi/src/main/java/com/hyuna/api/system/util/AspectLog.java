package com.hyuna.api.system.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;

@Aspect
@org.springframework.stereotype.Component
public class AspectLog
{
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AspectLog.class);
	
	
	
	@org.aspectj.lang.annotation.Before("execution(* com.hyuna.api.member.controller.*Controller.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) throws Throwable {
		long t1 = System.currentTimeMillis();
		String className = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		for (int i = 0; i < args.length; i++) {
		  log.info("BEFORE [" + className + "] " + args[i].toString());
		}
	}
	
	@After("execution(* com.hyuna.api.member.controller.*Controller.*(..))")
	public void afterAdvice(JoinPoint joinPoint) throws Throwable {
		long t1 = System.currentTimeMillis();
		String className = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		for (int i = 0; i < args.length; i++) {
		  log.info("AFTER [" + className + "] " + args[i].toString());
		}
	}
}
