package com.bta.insurance.pages.travel;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PolicyPlanPage extends TravelPolicyBasePage
{
	private final SelenideElement policyPlanOptimal = $ (byXpath ("//button[@datatype='selectPolicyPlanOPTIMAL']"));


	public void clickOptimaPlan ()
	{
		policyPlanOptimal.shouldBe (visible, Duration.ofSeconds (15))
				.scrollIntoView ("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}")
				.click ();
	}

}
