package com.example.demo2

import org.junit.Rule
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.testcontainers.containers.BrowserWebDriverContainer
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class TestSpec extends Specification {

    final static WEB_PAGE = "http://automationpractice.com/index.php"

    RemoteWebDriver driver
    MainPage mainPage
    SearchResultPage searchResultPage
    ItemPage itemPage

    @Rule
    BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(BrowserWebDriverContainer
                    .VncRecordingMode.RECORD_ALL, new File("src/test/recordings"))

    def setup() {
        driver = chrome.getWebDriver()
        mainPage = new MainPage(driver)
        searchResultPage = new SearchResultPage(driver)
        itemPage = new ItemPage(driver)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    def cleanup() {
        driver.quit()
    }

    def "This is description of this test so that you can understand purpose of it. "() {
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)

        and: "I wait for page to load the search box"
        mainPage.typeShirtIntoTextBox()

        and: "I click the search result"
        searchResultPage.clickFadedShirtSearchResult()

        and: "I search for the price of item"
        then: "I check if the price matches 16.51"
        itemPage.priceOfShirt().contains("16.51")

        and: "I wait for 1 seconds to see the result"
        sleep(1000)
    }
}
