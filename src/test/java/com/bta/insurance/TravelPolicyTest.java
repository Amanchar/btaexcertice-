package com.bta.insurance;

import com.bta.insurance.pages.MainPage;
import com.bta.insurance.pages.travel.PolicyOptionsPage;
import com.bta.insurance.pages.travel.PolicyPlanPage;
import com.bta.insurance.pages.travel.TravelInfoPage;
import com.bta.insurance.pages.travel.TravelersDataPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TravelPolicyTest
{
	private final SelenideElement cookiesPopup = $ (By.xpath ("//section[@id='module-284']"));
	private final SelenideElement cookiesPopupAcceptAll = $ (By.xpath ("//*[@id='module-284']//button[3]"));


	@BeforeEach
	public void setUp ()
	{
		open ("https://www.bta.lv/");

		cookiesPopup.should (Condition.exist);
		cookiesPopup.shouldBe (Condition.visible);
		cookiesPopupAcceptAll.click ();
	}

	@Test
	public void testTravelPolicyFieldEmpty ()
	{
		MainPage mainPage = new MainPage ();
		mainPage.clickTravelPolicy ();

		TravelInfoPage travelInfoPage = new TravelInfoPage ();
		travelInfoPage.clickTravelDestination ();
		travelInfoPage.clickSelectCountries ();
		travelInfoPage.clickAddCountry ();
		travelInfoPage.enterCountryName ("Indija");
		travelInfoPage.selectCountryByName ("Indija");
		travelInfoPage.clickApply ();

		Assertions.assertEquals ("Visa pasaule", travelInfoPage.getDestination ());

		travelInfoPage.clickActivities ();
		travelInfoPage.clickHighRiskActivities ();

		Assertions.assertEquals ("Ar paaugstināta riska aktivitātēm", travelInfoPage.getActivity ());

		PolicyPlanPage policyPlanPage = travelInfoPage.clickSubmit ();

		PolicyOptionsPage policyOptionsPage = policyPlanPage.clickOptimaPlan ();

		Assertions.assertTrue (policyOptionsPage.areAdditionalOptionsVisible ());
		Assertions.assertTrue (policyOptionsPage.isInsuranceWidgetVisible ());

		String priceBefore = policyOptionsPage.getAdditionalOptionPrice ();
		policyOptionsPage.clickEditDetails ();
		policyOptionsPage.clickSumEnsured ();
		policyOptionsPage.selectSumEnsured ("3000");
		policyOptionsPage.clickConfirm ();

		Assertions.assertNotEquals (priceBefore, policyOptionsPage.getAdditionalOptionPrice ());

		TravelersDataPage travelersDataPage = policyOptionsPage.clickContinue ();

		Assertions.assertTrue (travelersDataPage.isTravelersDataFormVisible ());
		Assertions.assertEquals ("", travelersDataPage.getFirstName ());
		Assertions.assertEquals ("", travelersDataPage.getLastName ());
		Assertions.assertEquals ("", travelersDataPage.getPersonalCode ());
	}
}
