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

        when: "this is desc of step 1"
        driver.get(WEB_PAGE)

        then: "do something else"
        WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")))
        foo.sendKeys("shirt", Keys.ENTER)
        sleep(10000)
    }
}
