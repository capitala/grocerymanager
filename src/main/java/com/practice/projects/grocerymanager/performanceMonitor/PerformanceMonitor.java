package com.practice.projects.grocerymanager.performanceMonitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceMonitor {
@Around("@annotation(TimeeTracker)")
public void around(ProceedingJoinPoint joinPoint) {
	long startTime=System.currentTimeMillis();
	Object obj=joinPoint.proceed();
}
	public PerformanceMonitor() {
		// TODO Auto-generated constructor stub
	}

}
