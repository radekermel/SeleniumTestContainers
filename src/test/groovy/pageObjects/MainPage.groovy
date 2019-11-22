package com.example.demo2

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.PageFactory

class MainPage {

    RemoteWebDriver driver

    MainPage(RemoteWebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    void typeShirtIntoTextBox() {
        driver.findElement(By.id("search_query_top")).sendKeys("shirt", Keys.ENTER)
    }
}
