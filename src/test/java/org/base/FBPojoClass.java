package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FBPojoClass extends BaseCLass{
	
	public FBPojoClass() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	// both conditions must be satisfied
	@FindBys({
	
		@FindBy(id="email"),
		@FindBy(xpath="//input[@type='text']")
		
	})
	
	 private WebElement txtUser;
	
	//any one condition is enough to be satisfied out of two
	@FindAll({
		
		@FindBy(id="pass"),
		@FindBy(xpath="//input[@type='password']")
		
	})
	
	  private WebElement txtPass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}
	
	
	
	
		
	

}
