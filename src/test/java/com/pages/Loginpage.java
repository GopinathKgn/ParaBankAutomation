package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class Loginpage extends BaseClass {

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassWord;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement btnLogin;
	
	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}
	
	
	public void login(String username, String password) {
	
		insertValueText(getTxtUserName(), username);
		insertValueText(getTxtPassWord(), password);
		elementClick(getBtnLogin());
		
	}
}
