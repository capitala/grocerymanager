package com.practice.projects.grocerymanager.logManager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutDefinitions {

@Pointcut("execution(* com.practice.projects.grocerymanager.*.*.*(..))")
public void pointCut(JoinPoint joinPoint) {}


}
