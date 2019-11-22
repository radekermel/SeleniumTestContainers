package pageObjects

import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.PageFactory

class SearchResultPage {

    RemoteWebDriver driver

    SearchResultPage(RemoteWebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    void clickFadedShirtSearchResult() {
        driver.findElementByXPath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img").click()
    }
}
