package com.cts.genericUtils.TestListeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.cts.testrunner.TestRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
public class AnnotationTransformer extends TestRunner implements IAnnotationTransformer {
 
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }
}