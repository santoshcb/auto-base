package com.auto.base.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * TestRetryListener is a TestNG Listener to enable Retry at runtime
 * 
 *
 */
public class TestRetryListener implements IAnnotationTransformer {
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
		if (retryAnalyzer == null) {
			annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
		}
	}
}
