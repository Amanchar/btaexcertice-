package com.bta.insurance.pages.travel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PolicyOptionsPage
{
	private final SelenideElement additionalOption = $ ("#additional-options");
	private final SelenideElement insurancePlanWidget = $ ("#insurance-plan-widget");
	private final SelenideElement insurancePlanContinueBtn = $ (byXpath ("//div[@id='insurance-plan-widget']/button"));


	public boolean areAdditionalOptionsVisible ()
	{
		return additionalOption.shouldBe (Condition.visible, Duration.ofSeconds (30)).exists ();
	}

	public boolean isInsuranceWidgetVisible ()
	{
		return insurancePlanWidget.shouldBe (Condition.visible, Duration.ofSeconds (30)).exists ();
	}

	public String getAdditionalOptionPrice ()
	{
		return $ (".green").shouldBe (Condition.visible).getText ();
	}

	public void clickEditDetails ()
	{
		$ (By.xpath ("//button[contains(@class,'edit-details')]")).click ();
	}

	public void clickSumEnsured ()
	{
		$ ("#deductible-open").click ();
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

		throw new NoSuchElementException ("There is no option with price equal to " + priceEnsured);
	}

	public void clickConfirm ()
	{
		$ (byXpath ("//button[contains(@class,'confirm-details')]")).click ();
		$ (".content-loader").shouldNotBe (Condition.visible, Duration.ofSeconds (15));
	}

	public TravelersDataPage clickContinue ()
	{
		insurancePlanContinueBtn.click ();

		return new TravelersDataPage ();
	}

}
