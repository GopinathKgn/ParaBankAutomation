package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target\\ParabankFailtest.txt",glue="com.stepdefinition")
public class FailTestRunner {

}
