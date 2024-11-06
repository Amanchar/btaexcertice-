package com.bta.insurance.pages.travel;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class TravelInfoPage extends TravelPolicyBasePage
{
	private final SelenideElement regionOpen = $ ("#regionalSelectorRegion-open");
	private final SelenideElement countryShowSearchList = $ ("#regionalSelectorCountry-showListSearch");
	private final SelenideElement countryAdd = $ ("#regionalSelectorCountry-addCountry");
	private final SelenideElement countrySearchField = $ ("#regionalSelectorCountry-typedValue");
	private final SelenideElement countryApplyButton = $ ("#regionalSelectorCountry-applyButton");

	private final SelenideElement travelActivities = $ ("#travelActivities-open");
	private final SelenideElement travelActivitiesHighRisk = $ ("#travelActivities-popup-select-option-1");
	private final SelenideElement travelSubmit = $ (byXpath ("//button[@data-type='travelSubmit']"));


	public void clickTravelDestination ()
	{
		regionOpen.shouldBe (visible).click ();
	}

	public void clickSelectCountries ()
	{
		countryShowSearchList.shouldBe (visible).click ();
	}

	public void clickAddCountry ()
	{
		countryAdd.shouldBe (visible).click ();
	}

	public void enterCountryName (String country)
	{
		countrySearchField.shouldBe (visible).sendKeys (country);
	}

	public void selectCountryByName (String country)
	{
		String countrySelectItem = "//button[@id='regionalSelectorCountry-selectItem' and @data-value='%s']";
		SelenideElement countryItem = $ (byXpath (String.format (countrySelectItem, country)));
		countryItem.shouldHave (text (country)).click ();
	}

	public void clickApply ()
	{
		countryApplyButton.shouldBe (visible).click ();
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
		travelActivitiesHighRisk.shouldBe (visible).click ();
	}

	public String getActivity ()
	{
		return travelActivities.getText ();
	}

	public void clickSubmit ()
	{
		travelSubmit.scrollIntoView ("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
		travelSubmit.shouldBe (visible).click ();
	}

}
