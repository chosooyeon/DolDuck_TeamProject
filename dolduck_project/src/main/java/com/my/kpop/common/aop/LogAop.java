package com.my.kpop.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {
	
	@Before("execution(public * com.my.test.model.dao.*Dao*.*(..))")
	public void before(JoinPoint join) {
		//getTarget 누구를 호출했나 target에 앞에다 찍어줄 친구
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("---------loger start-----------");
		Object args[] = join.getArgs();
		
		if(args!=null) {
			//join.getSignature().getName() 어떤 method를 호출했니?
			logger.info("Method:\t"+join.getSignature().getName());
			for(int i = 0;i<args.length;i++) {
				logger.info(i+"번째:\t"+args[i]);
			}
		}
		/*
		 * join.getTarget():대상 객체
		 *	   .getArgs():대상 파라미터(아규먼트)
		 * 	   .getSignature():대상 메소드 정보
		 */
	}
	
	@After("execution(public * com.my.test.model.dao.*Dao*.*(..))")
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("--------logger end---------");
	}
	
	@AfterThrowing("execution(public * com.my.test.model.dao.*Dao*.*(..))")
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("ERROR:\t"+join.getArgs());
		logger.info("ERROR:\t"+join.toString());
	}
}
