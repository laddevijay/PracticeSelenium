package com.maven.selenium.practice;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Day28_EnableDisableTestCases {
    @Test(
            groups = "smoke",
            description = "This test case1 is enabled and will be executed",
            dependsOnMethods = {"testCase2"}
        )
        public void testCase1() {
            System.out.println("Test Case 1 - Executed");
        }

        @Test(
            description = "This test case2 is enabled and will be executed",
            timeOut = 1000
        )
        public void testCase2() {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Test Case 2 - Executed");
        }

        @Test(
            groups = "regression",
            enabled = true,
            description = "This test case3 is disabled and will not be executed",
            priority = 1
        )
        public void testCase3() {
            System.out.println("Test Case 3 - Executed");
        }

        @Test(groups = "smoke")
        public void testCase4() {
            System.out.println("Test Case 4 - Executed");
        }

        @Test(groups = "regression")
        public void testCase5() {
            System.out.println("Test Case 5 - Executed");
        } 
}
