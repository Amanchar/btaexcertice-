package com.bta.insurance.pages.travel;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PolicyOptionsPage extends TravelPolicyBasePage
{
	private final SelenideElement widgetAdditionalOptions = $ ("#additional-options");
	private final SelenideElement widgetInsurancePlan = $ ("#insurance-plan-widget");
	private final SelenideElement insurancePlanContinueBtn = $ (byXpath ("//div[@id='insurance-plan-widget']/button"));
	private final SelenideElement additionsEditDetailsBtn = $ (byXpath ("//button[contains(@class,'edit-details')]"));
	private final SelenideElement additionsSumEnsuredDropDown = $ ("#deductible-open");
	private final SelenideElement additionsConfirmDetailsBtn = $ (byXpath ("//button[contains(@class,'confirm-details')]"));
	private final SelenideElement additionsPrice = $ (".green");


	public boolean isAdditionsWidgetVisible ()
	{
		return widgetAdditionalOptions.shouldBe (visible, Duration.ofSeconds (30)).isDisplayed ();
	}

	public boolean isInsuranceWidgetVisible ()
	{
		return widgetInsurancePlan.shouldBe (visible, Duration.ofSeconds (30)).isDisplayed ();
	}

	public String getAdditionalOptionPrice ()
	{
		return additionsPrice.shouldBe (visible).getText ();
	}

	public void clickEditDetails ()
	{
		additionsEditDetailsBtn.shouldBe (visible).click ();
	}

	public void clickSumEnsured ()
	{
		additionsSumEnsuredDropDown.shouldBe (visible).click ();
	}

	public void selectSumEnsured (String priceEnsured)
	{
		ElementsCollection options = $$ (By.xpath ("//button[starts-with(@id,'deductible-dropdown-select-option')]"));

		for (SelenideElement option : options)
		{
			if (option.getText ().startsWith (priceEnsured))
			{
				option.click ();
				return;
			}
		}

		throw new NoSuchElementException ("There is no option with a price equal to " + priceEnsured);
	}

	public void clickConfirm ()
	{
		additionsConfirmDetailsBtn.shouldBe (visible).click ();

		hasLoaded ();
	}

	public void clickContinue ()
	{
		insurancePlanContinueBtn.shouldBe (visible).click ();
	}

}
