package com.akashxdev.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JobAppAop {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobAppAop.class);

	@AfterThrowing("execution(* com.akashxdev.JobApp.service.JobService.*(..)) || execution(* com.akashxdev.JobApp.service.MyAdminDetailsService.*(..)) || execution(* com.akashxdev.JobApp.service.JWTService.*(..))")
	public void timeTakenByMethod(ProceedingJoinPoint jp) throws Throwable {
		LOGGER.info("Method crashed in " + jp.getSignature().getName());
		jp.proceed();
	}
}
