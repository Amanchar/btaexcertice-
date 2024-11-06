package com.bta.insurance.pages.travel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TravelersDataPage
{
	private final SelenideElement travelersDataForm = $ ("#form-travel-travellers");
	private final SelenideElement travelersFirstName = $ ("#travelerFirstName0-text");
	private final SelenideElement travelersLastName = $ ("#travelerLastName0-text");
	private final SelenideElement travelersPersonalCode = $ ("#travelerIdentityNumber0-text");


	public boolean isTravelersDataFormVisible ()
	{
		return travelersDataForm.shouldBe (visible, Duration.ofSeconds (30)).exists ();
	}

	public String getFirstName ()
	{
		return travelersFirstName.getText ();
	}

	public String getLastName ()
	{
		return travelersLastName.getText ();
	}

	public String getPersonalCode ()
	{
		return travelersPersonalCode.getText ();
	}

}
