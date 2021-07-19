package com.assignment1.pages;

import static com.codeborne.selenide.Selenide.*;
import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class WebChat {
	@FindBy(xpath = "//div[@class='avaamo__icon']")
	private SelenideElement webChatIcon;

	@FindBy(xpath = "//div[contains(@class,'avm-bot-welcome')]")
	private SelenideElement webChatWelcomeNotifDiv;

	@FindBy(xpath = "//div[contains(@class,'avm-bot-welcome')]/h3")
	private SelenideElement webChatWelcomeNotifHeading;

	@FindBy(xpath = "//div[contains(@class,'avm-bot-welcome')]/h3/small")
	private SelenideElement webChatWelcomeNotifMsg;

	@FindBy(xpath = "//div[@class='avm-bot-get-started']")
	private SelenideElement webChatBotGetStarted;

	@FindBy(xpath = "//div[@class='avm-bot-get-started']//a")
	private SelenideElement webChatBotGetStartedButton;

	@FindBy(xpath = "//div[@class='welcome-message']/p")
	private SelenideElement webChatBotWelcomeMsg;

	@FindBy(xpath = "//div[@class='conversation avm-messenger ']")
	private SelenideElement webChatConversationWindow;

	@FindBy(xpath = "//div[@class='messages_nav-bar_title']/h2")
	private SelenideElement webChatConversationWindowHeading;

	@FindBy(xpath = "//div[@id='avaamo__popup']/a")
	private SelenideElement webChatConversationWindowXIcon;

	@FindBy(xpath = "//div[@class='messages-view']")
	private SelenideElement webChatConversationWindowMsgSection;

	@FindBy(xpath = "//div[@class='compose-message-fields']")
	private SelenideElement webChatConversationWindowMsgFields;

	@FindBy(xpath = "//div[@class='compose-message-fields']//div[contains(@class,'botMenu__toggleEditor')]")
	private SelenideElement webChatConversationWindowBotMenuIcon;

	@FindBy(xpath = "//div[@class='compose-message-fields']//textarea")
	private SelenideElement webChatConversationWindowBotInputField;

	@FindBy(xpath = "//div[@class='compose-message-fields']//div[contains(@class,'send')]")
	private SelenideElement webChatConversationWindowBotSendBtn;

	@FindBy(xpath = "//div[text()='Hi! Welcome to IFFCO-Tokio General Insurance. ']")
	private SelenideElement webChatBotDefaultWelcomeMsgText;

	@FindBy(xpath = "//div[@class='default_card_link']")
	private ElementsCollection webChatBotDefaultWelcomeMsgLinks;

	@FindBy(xpath = "//div[contains(@class,'icon-down')]")
	private SelenideElement webChatBotDefaultMenuToggleIcon;

	@FindBy(xpath = "//div[@class='default_card_link']/a[text()='Download']")
	private SelenideElement downloadButton;

	@FindBy(xpath = "//div[@class='default_card attachments']/div[text()='Fill the below form']")
	private SelenideElement form;

	@FindBy(xpath = "//input[@class='textbox']")
	private SelenideElement formFullNameInput;

	@FindBy(xpath = "//textarea[@class='textbox']")
	private SelenideElement formAddressInput;

	@FindBy(xpath = "//input[@class='textbox picklist-textbox']")
	private SelenideElement formSelectDropdown;

	@FindBy(xpath = "//button[@class='btn default_card_submit']")
	private SelenideElement formSubmitButton;

	@FindBy(xpath = "//div[@id='webview_body']//button[@class='close']")
	private SelenideElement webViewXIcon;

	public void validateWebChatIcon() {
		Assert.assertTrue(webChatIcon.shouldBe(Condition.visible).isDisplayed(), "IRA webchat not displayed");
	}

	public void clickWebChatIcon() {
		webChatIcon.shouldBe(Condition.visible).click();
	}

	public void validateWelcomeNotification() {
		Assert.assertTrue(webChatWelcomeNotifDiv.shouldBe(Condition.visible).isDisplayed(),
				"Notification Div not displayed on Welcome Screen");
	}

	public void validateWelcomeMsg(String msg) {
		Assert.assertTrue(webChatBotWelcomeMsg.shouldBe(Condition.exist).getText().contains(msg),
				"Welcome message does not match... Expected Welcome Msg:: Hello and welcome to IRA agent ************ Actual Welcome Message displayed :: "
						+ webChatBotWelcomeMsg.getText());
	}

	public void validateGetStarted() {
		Assert.assertTrue(webChatBotGetStarted.shouldBe(Condition.visible).isDisplayed(),
				"Get Started PopUp not displayed");
	}

	public void clickGetStartedButton() {
		webChatBotGetStartedButton.shouldBe(Condition.visible).click();
	}

	public void validateWelcomeNotifHeading(String heading) {
		Assert.assertTrue(webChatWelcomeNotifHeading.shouldBe(Condition.visible).getText().contains(heading),
				"Heading is incorrect");
	}

	public void sendInput(String text) {
		webChatConversationWindowBotInputField.sendKeys(text);
	}

	public void clickSendButton() {
		webChatConversationWindowBotSendBtn.shouldBe(Condition.visible).click();
	}

	public void clickBotMenuIcon() {
		webChatConversationWindowBotMenuIcon.shouldBe(Condition.visible).click();
	}

	// Start Over
	public void clickBotMenuOption(String option) {
		$(By.xpath("//a[@class='botMenu__menu__item' and text()='" + option + "']")).click();
	}

	// Download Motor Policy
	public void clickBotMenuItem(String item) {
		$(By.xpath("(//div[@class='default_card_link']/a[text()='" + item + "'])[1]")).click();
	}

	public void clickDownloadButton() {
		downloadButton.shouldBe(Condition.visible).click();
	}

	public void validateForm() {
		Assert.assertTrue(form.shouldBe(Condition.visible).isDisplayed(), "Form not displayed");
	}

	public void sendFullNameInput(String fullName) {
		formFullNameInput.shouldBe(Condition.visible).sendKeys(fullName);
	}

	public void sendAddressInput(String address) {
		formAddressInput.shouldBe(Condition.visible).sendKeys(address);
	}

	public void clickGender(String gender) {
		$(By.xpath("//span[text()='" + gender + "']")).click();
	}

	public void clickPolicySearch() {
		formSelectDropdown.click();
	}

	// Rarely
	public void selectPolicySearch(String option) {
		$(By.xpath("//li[text()='" + option + "']")).click();
	}

	public void clickRating(String rating) {
		$(By.xpath("//label[text()='" + rating + "']")).click();
	}

	public void clickSubmitButton() {
		formSubmitButton.shouldBe(Condition.visible).click();
	}

	public void clickTest(String btn) {
		$(By.xpath("//div[@class='default_card_link']/a[text()='" + btn + "']")).click();
	}

	public void clickWebViewXIcon() {
		webViewXIcon.shouldBe(Condition.visible).click();
	}

	public void switchToChildWindowClose() {

		try {
			Set<String> windows = WebDriverRunner.getWebDriver().getWindowHandles();
			Iterator<String> it = windows.iterator();
			while (it.hasNext()) {
				String Parent = it.next();
				String Child = it.next();
				WebDriverRunner.getWebDriver().switchTo().window(Child).close();
			}
			Thread.sleep(2000);
			Reporter.log("Child Window Switched to Child Window");
		} catch (Exception e) {
			Reporter.log("Child WindowCouldn't switch to Child Window");
		}
	}

	public void validateConversationWindow() {
		Assert.assertTrue(webChatConversationWindow.isDisplayed(), "Conversation window not displayed");
		Assert.assertTrue(webChatConversationWindowHeading.exists(), "Heading on Conversation window not displayed");
		Assert.assertTrue(webChatConversationWindowMsgSection.shouldBe(Condition.visible).isDisplayed(),
				"Message section in Conversation window not displayed");

	}

	public void validateBotDefaultWelcomeMsgText(String text) {
		Assert.assertTrue(webChatBotDefaultWelcomeMsgText.shouldBe(Condition.visible).getText().contains(text),
				"Default Welcome message incorrect");
	}

	public void clickToggleIcon() {
		webChatBotDefaultMenuToggleIcon.click();
	}

	public void validateDefaultWelcomeLinks() {
		webChatBotDefaultWelcomeMsgLinks.shouldBe(CollectionCondition.sizeGreaterThan(0));
		for (SelenideElement ele : webChatBotDefaultWelcomeMsgLinks) {
			Assert.assertTrue(ele.isDisplayed(), "default link not displayed");
			Reporter.log("Default Link Displayed : " + ele.getText(), true);
		}
	}

	public void validateBotResponse(String response) {
		SelenideElement ele = $(By.xpath("//p[contains(text(),'" + response + "') and @class='desc text-content ']"));
		Assert.assertTrue(ele.isDisplayed(), "Bot response not as expected");
		Reporter.log("Bot Response : " + ele.getText(), true);
	}
	
	
}
