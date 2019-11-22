package pageObjects

import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.PageFactory

class ItemPage {

    RemoteWebDriver driver

    ItemPage(RemoteWebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    String priceOfShirt() {
        driver.findElement(By.id("our_price_display")).getText()
    }
}
