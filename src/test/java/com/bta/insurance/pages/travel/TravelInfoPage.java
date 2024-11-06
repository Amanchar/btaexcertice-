package com.bta.insurance.pages.travel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class TravelInfoPage
{
	private final SelenideElement regionOpen = $ (byId ("regionalSelectorRegion-open"));
	private final SelenideElement countryShowSearchList = $ (byId ("regionalSelectorCountry-showListSearch"));
	private final SelenideElement countryAdd = $ (byId ("regionalSelectorCountry-addCountry"));
	private final SelenideElement countrySearchField = $ (byId ("regionalSelectorCountry-typedValue"));
	private final SelenideElement countryApplyButton = $ (byId ("regionalSelectorCountry-applyButton"));

	private final SelenideElement travelActivities = $ (byId ("travelActivities-open"));
	private final SelenideElement travelActivitiesHighRisk = $ (byId ("travelActivities-popup-select-option-1"));
	private final SelenideElement travelSubmit = $ (byXpath ("//button[@data-type='travelSubmit']"));


	public void clickTravelDestination ()
	{
		regionOpen.shouldBe (Condition.visible).click ();
	}

	public void clickSelectCountries ()
	{
		countryShowSearchList.shouldBe (Condition.visible).click ();
	}

	public void clickAddCountry ()
	{
		countryAdd.shouldBe (Condition.visible).click ();
	}

	public void enterCountryName (String country)
	{
		countrySearchField.shouldBe (Condition.visible).sendKeys (country);
	}

	public void selectCountryByName (String country)
	{
		String countrySelectItem = "//button[@id='regionalSelectorCountry-selectItem' and @data-value='%s']";
		By countryItem = byXpath (String.format (countrySelectItem, country));
		$ (countryItem).shouldHave (Condition.text (country)).click ();
	}

	public void clickApply ()
	{
		countryApplyButton.shouldBe (Condition.visible).click ();
	}

	public String getDestination ()
	{
		return regionOpen.getText ();
	}

	public void clickActivities ()
	{
		travelActivities.scrollIntoView ("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
		travelActivities.click ();
	}

	public void clickHighRiskActivities ()
	{
		travelActivitiesHighRisk.shouldBe (Condition.visible).click ();
	}

	public String getActivity ()
	{
		return travelActivities.getText ();
	}

	public PolicyPlanPage clickSubmit ()
	{
		travelSubmit.scrollIntoView ("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
		travelSubmit.click ();

		$ (byXpath ("//div[@class='content-loader']")).shouldNotBe (Condition.visible);
		$ (byId ("form-travel-policy")).shouldBe (Condition.visible, Duration.ofSeconds (30));

		return new PolicyPlanPage ();
	}

}
