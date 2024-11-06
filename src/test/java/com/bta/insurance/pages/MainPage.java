package com.bta.insurance.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage
{
	private final SelenideElement travelPolicyBtn = $ (By.xpath ("//a[@class='item quick-menu-btn' and @href='/privatpersonam/celojuma-apdrosinasana']"));


	public void clickTravelPolicy ()
	{
		travelPolicyBtn.shouldBe (visible).click ();
	}

}
