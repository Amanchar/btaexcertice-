package com.bta.insurance.pages.travel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NotFoundException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class TravelPolicyBasePage
{
	protected final SelenideElement contentLoader	= $ (".content-loader");


	public TravelPolicyBasePage ()
	{
		if (hasLoaded ())
			throw new NotFoundException ("Failed to load the page");
	}

	protected boolean hasLoaded ()
	{
		return contentLoader.shouldNot (exist, Duration.ofSeconds (30)).exists ();
	}

}
