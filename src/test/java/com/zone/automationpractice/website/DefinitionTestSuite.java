package com.zone.automationpractice.website;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/zone-test/HappyPath.feature")
public class DefinitionTestSuite {}
