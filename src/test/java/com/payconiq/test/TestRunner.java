package com.payconiq.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty:target/cucumber/cucumber.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"html:target/cucumber/report",
				"json:target/cucumber/cucumber.json",
				"com.payconiq.utils.MyTestListener"
		}
		,features= {"src/test/resources/features"}
		,glue = {"com.payconiq.stepdefinition"}
		//,dryRun = true
		,monochrome = true
		,snippets = SnippetType.CAMELCASE
		,tags = "@bookerAPI"
		//,publish = true
		)
public class TestRunner {

}