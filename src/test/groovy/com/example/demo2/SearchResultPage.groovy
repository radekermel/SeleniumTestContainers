package com.example.demo2

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SearchResultPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    WebElement RESULT_LOCATOR

    RemoteWebDriver driver
    WebDriverWait wait

    void waitForPageResultToLoad() {
        wait.until(ExpectedConditions
                .elementToBeClickable(RESULT_LOCATOR))
    }

    void clickFadedShirtSearchResult() {
        driver.findElement(RESULT_LOCATOR as By).click()
    }
}


