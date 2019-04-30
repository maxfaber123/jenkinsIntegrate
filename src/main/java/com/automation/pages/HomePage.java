package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.TestBase;
import com.automation.util.TestUtil;

public class HomePage extends TestBase {



	@FindBy(xpath = "//a[text()= 'Women']")
	WebElement womenLink;

	@FindBy(xpath ="//a[text() = 'Summer Dresses']")
	WebElement summerdressLink;

	//	Initialize the Page Object
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {

		return driver.getTitle();
	}

	public CategoryPage selectSummerDress() throws Exception {

		try {
//			TestUtil.Hover(driver, womenLink);
			JavascriptExecutor je =( (JavascriptExecutor)driver);
			je.executeScript("arguments[0].focus();",womenLink);
			wait.until(ExpectedConditions.visibilityOf(summerdressLink)).click();
//			summerdressLink.click();
		} catch (Exception e) {
			logger.error("select summer dress action failed:" , e);

			throw(e);
		}



		return new CategoryPage();
	}


}
