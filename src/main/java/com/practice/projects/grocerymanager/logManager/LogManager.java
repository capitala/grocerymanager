package com.practice.projects.grocerymanager.logManager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
	
private Logger logger=LoggerFactory.getLogger(this.getClass());

@Before("com.practice.projects.grocerymanager.logManager.pointCut()")
public void before(JoinPoint joinPoint) {
	logger.info("Just Entered " + joinPoint);
}

@AfterReturning(value="com.practice.projects.grocerymanager.logManager.pointCut()",returning="result")
public void afterReturning(JoinPoint joinPoint,Object result) {
	logger.info("Just Fininshed " + joinPoint + result);
}
@AfterThrowing(value="com.practice.projects.grocerymanager.logManager.pointCut()",throwing="e")
public void afterThrowwing(JoinPoint joinPoint,Throwable e) {
	logger.error("Got Exception in "+ joinPoint +e.getMessage());
	logger.error("Exception is ",e);
	
}
}
