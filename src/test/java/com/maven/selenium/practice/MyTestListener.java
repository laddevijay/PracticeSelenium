package com.maven.selenium.practice;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class MyTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getName() +
                " | Thread: " + Thread.currentThread().getId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName() +
                " | Thread: " + Thread.currentThread().getId());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName() +
                " | Thread: " + Thread.currentThread().getId());

        // Capture screenshot (thread-safe)
      
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        System.out.println("=== TEST EXECUTION STARTED ===");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        System.out.println("=== TEST EXECUTION FINISHED ===");
    }
}