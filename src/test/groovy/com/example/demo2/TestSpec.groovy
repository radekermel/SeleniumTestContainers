package com.example.demo2

import org.junit.Rule
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testcontainers.containers.BrowserWebDriverContainer
import spock.lang.Specification

class TestSpec extends Specification {

    final static WEB_PAGE = "http://automationpractice.com/index.php"

    RemoteWebDriver driver
    WebDriverWait wait
    MainPage mainPage


    @Rule
    BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(BrowserWebDriverContainer
                    .VncRecordingMode.RECORD_ALL, new File("src/test/recordings"))

    def setup() {
        driver = chrome.getWebDriver()
        wait = new WebDriverWait(driver, 15)

    }

    def "This is description of this test so that you can understand purpose of it. "() {
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)
        and: "I wait for page to load the search box"
        mainPage.waitForSearchQueryBox()
        mainPage.typeShirtIntoTextBox()
        and: "I click the search result"
        WebElement searchResultFadedShirt = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                .xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")))
        searchResultFadedShirt.click()

        and: "I search for the price of item"
        wait.until(ExpectedConditions.elementToBeClickable(By.id("our_price_display")))
        String priceToDisplay = driver.findElement(By.id("our_price_display")).getText()

        then: "I check if the price matches 16.51"
        priceToDisplay.contains("16.51")

        and: "I wait for 10 seconds to see the result"
        sleep(10000)
        driver.quit()
    }

    def "This test will fail to see the error message"() {
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)
        then: "I wait for page to load the search box but ID IS INCORRECT"
        WebElement searchQueryBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("foo")))
        and: "I type shirt word and hit Enter key"
        searchQueryBox.sendKeys("shirt", Keys.ENTER)
        and: "I wait for 10 seconds to see the result"
        sleep(10000)
    }
}
