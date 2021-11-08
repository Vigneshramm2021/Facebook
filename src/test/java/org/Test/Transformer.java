package org.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


public class Transformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotations, Class arg1, Constructor arg2, Method arg3) {
		IRetryAnalyzer retryAnalyzer = annotations.getRetryAnalyzer();
		if(retryAnalyzer==null) {
		annotations.setRetryAnalyzer(RetryAnalyzeer.class);
	}
	}

}
