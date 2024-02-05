package com.sevolutivo.demo.cucumber.stepDefs;

import com.sevolutivo.demo.cucumber.CucumberSpringConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;

public class DemoSteps extends CucumberSpringConfiguration {

    private String username;

    private ResponseEntity response;

    @Given("client wants to write username")
    public void clientWantsToWriteAGreeting(){
        username = "user001";
    }

    @When("client calls greeting endpoint")
    public void clientCallsToGreetingEndpoint() {
        response = testRestTemplate.getForEntity("/greeting/" + username, String.class);
    }

    @Then("client receives hello text and username")
    public void clientReceivesHelloTextAndGreeting() {
        Assertions.assertEquals("hello " + username, response.getBody());
    }
}