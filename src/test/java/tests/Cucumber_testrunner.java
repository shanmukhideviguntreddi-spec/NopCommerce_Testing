package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
/*
Author: 
Create on: 
Purpose:Runner file for test case 4
*/
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/cucumberTest.feature" }, glue = { "tests" }, tags = "")
public class Cucumber_testrunner extends AbstractTestNGCucumberTests {

}
