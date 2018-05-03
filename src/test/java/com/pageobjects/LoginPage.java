package com.pageobjects;
import java.util.HashMap;

import org.junit.Test;
import org.openqa.selenium.WebElement;



import com.digi.LoggerManager;
import com.digi.Manager;
import com.digi.SeleniumManager;

	public class LoginPage extends Manager {
	 	WebElement continueButton;
		WebElement txtboxUserName;
		WebElement txtboxPassword; 
		LoggerManager logger=LoggerManager.getLogger();
		SeleniumManager seleniumManager=SeleniumManager.getSeleniumManager();
		String localClass=this.getClass().getName();


	public void Login() {
			try{
					enterLoginUserName("");
					enterLoginPassword("");
					clickSignInButton();
	
			} catch (Exception e) {
				logger.error(localClass,"Login is Failed",e);
}
		}
		
	
		private void enterLoginPassword(String passWord) {
			seleniumManager.type("txtboxPassword", passWord,"userName");
		}

		private void enterLoginUserName(String userName) {
			seleniumManager.type("txtboxUserName", userName, "passWord");
		}
				
		private void clickSignInButton() {
			seleniumManager.click("continueButton", "Continue button");
		}
}
	
