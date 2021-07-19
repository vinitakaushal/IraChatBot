package com.assignment1.ChatBotAutomation;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.assignment1.pages.WebChat;
import com.assignment1.utility.UtilityMethods;

public class ChatBotAutomation {
	Properties prop;
	UtilityMethods util = new UtilityMethods();
	WebChat webChatPage;
	@Test
	public void launchURL() throws InterruptedException {
		prop = new Properties();
		prop = UtilityMethods.OpenProperties("src/test/java/resources/env.properties");
		open(prop.get("URL").toString());
	}

	@Test(dependsOnMethods = "launchURL") 
	public void validateWebChatIcon() {
		webChatPage = page(WebChat.class);
		webChatPage.validateWebChatIcon();
		webChatPage.validateWelcomeNotification();
		webChatPage.validateWelcomeNotifHeading("Test agent - IRA");
		webChatPage.clickWebChatIcon();
	}
	
	@Test(dependsOnMethods = "validateWebChatIcon")
	public void validateGetStarted() throws InterruptedException {
		webChatPage.validateWelcomeMsg("Hello and welcome to IRA agent");
		webChatPage.validateGetStarted();
		webChatPage.clickGetStartedButton();
		Thread.sleep(2000);
		switchTo().frame("avaamoIframe");
		webChatPage.validateConversationWindow();
		webChatPage.validateBotDefaultWelcomeMsgText("Hi! Welcome to IFFCO-Tokio General Insurance.");
		webChatPage.clickToggleIcon();
		webChatPage.validateDefaultWelcomeLinks();
		webChatPage.sendInput("Hello");
		webChatPage.clickSendButton();
		Thread.sleep(3000);
		webChatPage.validateBotResponse("Hi there, what can I help you with today?");
	}
	
	@Test(dependsOnMethods = "validateGetStarted")
	public void validateMenuOptions() throws InterruptedException {
		webChatPage.clickBotMenuIcon();
		webChatPage.clickBotMenuOption("Start Over");
		webChatPage.clickBotMenuItem("Download Motor Policy");
		webChatPage.clickDownloadButton();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "validateMenuOptions")
	public void validateTestBotUserInput() throws InterruptedException {
		webChatPage.sendInput("Test Bot");
		webChatPage.clickSendButton();
		webChatPage.validateForm();
		webChatPage.sendFullNameInput("Vinita Kaushal");
		webChatPage.sendAddressInput("BTM, Bangalore");
		webChatPage.clickGender("Female");
		webChatPage.clickPolicySearch();
		webChatPage.selectPolicySearch("Rarely");
		webChatPage.clickRating("4");
		webChatPage.clickSubmitButton();
	}
	@Test(dependsOnMethods = "validateTestBotUserInput")
	public void NewTestUserInput() throws InterruptedException {
		webChatPage.sendInput("New Test");
		webChatPage.clickSendButton();
		Thread.sleep(3000);
		webChatPage.clickTest("Google");
		Thread.sleep(3000);
		webChatPage.clickWebViewXIcon();
		Thread.sleep(3000);
		webChatPage.clickTest("Call");
		Thread.sleep(3000);
		webChatPage.switchToChildWindowClose();
		Reporter.log("Validation completed....",true);
	}
}
