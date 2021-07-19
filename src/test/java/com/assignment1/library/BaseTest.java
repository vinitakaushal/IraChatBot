package com.assignment1.library;

import static com.codeborne.selenide.Selenide.close;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.Configuration;
public class BaseTest {
	@BeforeTest
	@Parameters({ "browserType" })
	public void setupBrowser(@Optional String browserType) {
		Configuration.browserCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		Configuration.startMaximized = true;
		Configuration.timeout = 7000;
		Configuration.headless = false;
		if ((browserType != null)) {
			Configuration.browser = browserType;
		} else {
			Configuration.browser = "chrome";
		}
	}

	@AfterClass
	public void quit() {
		close();
	}
}