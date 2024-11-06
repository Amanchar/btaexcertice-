package com.bta.insurance.pages.travel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PolicyPlanPage
{
	private final SelenideElement policyPlanOptimal = $ (byXpath ("//button[@datatype='selectPolicyPlanOPTIMAL']"));


	public PolicyOptionsPage clickOptimaPlan ()
	{
		policyPlanOptimal.scrollIntoView ("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
		policyPlanOptimal.shouldBe (Condition.visible, Duration.ofSeconds (10))
				.click ();

		return new PolicyOptionsPage ();
	}

}
