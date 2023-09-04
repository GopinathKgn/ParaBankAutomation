package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","json:target\\Parabankresults.json","rerun:target\\ParabankFailtest.txt"}, monochrome=true,stepNotifications=true,dryRun=false, features="src\\test\\resources\\Features", glue="com.stepdefinition")
public class TestRunner {

}
