package com.ssafy.house.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.ssafy.house.basket..*.*(..))")
	public void allmethod() {}
	
	@Before("allmethod()")
	public void logging(JoinPoint jp) {
		Signature s = jp.getSignature();
		String temp = jp.getSignature().toString();
		int lastSubstringLocation = temp.lastIndexOf('.') + 1;
		
		logger.debug("[System][" + temp.substring(lastSubstringLocation) + "] 호출 : {}, 파라미터:{}", 
				s.getDeclaringType().getSimpleName()+"."+
						s.getName(),
				Arrays.toString( jp.getArgs() )
		);
	}
	
	@AfterReturning(pointcut = "allmethod()", returning = "result")
	public void afterCall(JoinPoint jp, Object result) {
		Signature s = jp.getSignature();
		String temp = jp.getSignature().toString();
		int lastSubstringLocation = temp.lastIndexOf('.') + 1;
		
		logger.debug("[System][" + temp.substring(lastSubstringLocation) + "] 리턴 : {}, 반환값: {}", 
				s.getDeclaringType().getSimpleName()+"."+
				s.getName(), 
				result);
	}
}
