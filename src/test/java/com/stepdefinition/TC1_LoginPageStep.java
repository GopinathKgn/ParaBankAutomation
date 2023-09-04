package com.stepdefinition;

import com.baseclass.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginPageStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the para bank  page")
	public void user_is_on_the_para_bank_page() {
		browserLanch("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		maximizeWindow();
	   
	}
	@When("User should enter the {string} and {string}")
	public void user_should_enter_the_and(String username, String password) {
		pom.getLoginPage().login(username, password);
	    
	}
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String string) {
	    
	}




}
