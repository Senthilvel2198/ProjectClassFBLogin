package org.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.base.BaseCLass;
import org.base.FBPojoClass;
import org.junit.Assert;

import cucumber.api.java.en.*;

public class FacebookClass extends BaseCLass {
	
	@Given("Launch Chrome and Load Facebook login URL")
	public void launch_Chrome_and_Load_Facebook_login_URL() {
		launchUrl("https://www.facebook.com/");
	    
	}

	@When("Enter invalid Username")
	public void enter_invalid_Username() throws IOException {
		FBPojoClass f = new FBPojoClass();
		passValue(f.getTxtUser(), "Senthil");
	}

	@When("Enter invalid Password")
	public void enter_invalid_Password() throws IOException {
		FBPojoClass f = new FBPojoClass();
		passValue(f.getTxtPass(), getData(1, 2));
	}

	@When("Click Login button")
	public void click_Login_button() throws InterruptedException {
		FBPojoClass f = new FBPojoClass();
		Clicking(f.getBtnLogin());
		Thread.sleep(3000);
	}

	@Then("Popup incorrect credential page")
	public void popup_incorrect_credential_page() {
		String a = "privacy";
		String b = driver.getCurrentUrl();
		if (b.contains(a)) {
			
			   System.out.println("Success");
		}
		   else {
			System.out.println("Failed");
		}

	}
	@When("Enter Valid User and Invalid Password")
	public void enter_Valid_User_and_Invalid_Password() throws IOException {
	    FBPojoClass f = new FBPojoClass();
	    passValue(f.getTxtUser(), "8754964011");
	    passValue(f.getTxtPass(), getData(1, 2));
	}

	@When("Click login button")
	public void click_login_button() throws InterruptedException {
	    FBPojoClass f = new FBPojoClass();
	    Clicking(f.getBtnLogin());
	    Thread.sleep(3000);
	}
	
	@When("Enter invalid UsernamE")
	public void enterInvalidUsernamE(io.cucumber.datatable.DataTable d) {
		FBPojoClass f = new FBPojoClass();
		List<String> li = d.asList();
		passValue(f.getTxtUser(), li.get(2));
	}
	
	@When("Enter invalid PassworD")
	public void enterInvalidPassworD(io.cucumber.datatable.DataTable d) {
		FBPojoClass f = new FBPojoClass();
		List<List<String>> li = d.asLists();
		passValue(f.getTxtPass(), li.get(1).get(0));
	}
	
	@When("Enter Valid User")
	public void enterValidUser(io.cucumber.datatable.DataTable d) {
		FBPojoClass f = new FBPojoClass();
		Map<String, String> mp = d.asMap(String.class, String.class);
		passValue(f.getTxtUser(), mp.get("UserName2"));
	}

	@When("Enter Invalid Pass")
	public void enterInvalidPass(io.cucumber.datatable.DataTable d) {
		FBPojoClass f = new FBPojoClass();
		List<Map<String, String>> mp = d.asMaps();
		passValue(f.getTxtPass(), mp.get(0).get("Pass3"));
	}




	@Then("Popup incorrect password page")
	public void popup_incorrect_password_page() {
	    String  a = "privacy";
	    String b = driver.getCurrentUrl();
	   if (b.contains(a)) {
		
		   System.out.println("Success");
	}
	   else {
		System.out.println("Failed");
	}
	}

	




}
