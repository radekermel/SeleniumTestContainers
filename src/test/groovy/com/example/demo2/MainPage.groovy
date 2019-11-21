package com.example.demo2

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class MainPage {

    RemoteWebDriver driver
    WebDriverWait wait

    MainPage(RemoteWebDriver driver) {
        this.driver = driver
    }

    @FindBy(id = "search_query_top")
    WebElement searchQueryId


    void waitForSearchQueryBox() {
        wait.until(ExpectedConditions.elementToBeClickable(searchQueryId))
    }

    void typeShirtIntoTextBox() {
        driver.findElementById(searchQueryId as String).sendKeys("shirt", Keys.ENTER)
    }

}
