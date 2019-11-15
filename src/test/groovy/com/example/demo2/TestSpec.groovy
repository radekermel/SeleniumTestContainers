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

    @Rule
    BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(BrowserWebDriverContainer
                    .VncRecordingMode.RECORD_ALL, new File("src/test/recordings"))

    def "This is description of this test so that you can understand purpose of it. "() {
        given: "get WebDriver and start testing :)"
        RemoteWebDriver driver = chrome.getWebDriver()
        WebDriverWait wait = new WebDriverWait(driver, 15)
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)
        then: "I wait for page to load the search box"
        WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")))
        and: "I type shirt word and hit Enter key"
        foo.sendKeys("shirt", Keys.ENTER)
        and: "I wait for 10 seconds to see the result"
        sleep(10000)
    }

    def "This test will fail to see the error message"() {
        given: "get WebDriver and start testing :)"
        RemoteWebDriver driver = chrome.getWebDriver()
        WebDriverWait wait = new WebDriverWait(driver, 15)
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)
        then: "I wait for page to load the search box but id is incorrect"
        WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(By.id("foo")))
        and: "I type shirt word and hit Enter key"
        foo.sendKeys("shirt", Keys.ENTER)
        and: "I wait for 10 seconds to see the result"
        sleep(10000)
    }
}
