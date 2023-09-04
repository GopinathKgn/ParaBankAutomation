package com.manager;

import com.pages.Loginpage;

public class PageObjectManager  {

	private Loginpage loginPage;

	public Loginpage getLoginPage() {
		return (loginPage==null)? loginPage= new Loginpage() : loginPage;
	}
	
}
