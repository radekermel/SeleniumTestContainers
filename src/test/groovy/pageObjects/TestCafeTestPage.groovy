package pageObjects

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select

class TestCafeTestPage {

    RemoteWebDriver driver

    String devName = 'Bruce'

    TestCafeTestPage(RemoteWebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    void developerNameTextField() {
        driver.findElement(By.id('developer-name')).sendKeys(devName)
    }

    void remoteTestingCheckbox() {
        driver.findElement(By.id('remote-testing')).click()
    }

    void reusingCodeCheckbox() {
        driver.findElement(By.id('reusing-js-code')).click()
    }

    void backgroundParallelTestingCheckbox() {
        driver.findElement(By.id('background-parallel-testing')).click()
    }

    void continuousIntegrationEmbeddingCheckbox() {
        driver.findElement(By.id('continuous-integration-embedding')).click()
    }

    void trafficMarkupAnalysisCheckbox() {
        driver.findElement(By.id('traffic-markup-analysis')).click()
    }

    void triedTestcafe() {
        driver.findElement(By.id('tried-test-cafe')).click()
    }

    void macOsOperatingRadio() {
        driver.findElement(By.id('macos')).click()
    }

    void testcafeInterfaceDropdown() {
        new Select(driver.findElement(By.id('preferred-interface'))).selectByVisibleText('Both')
    }

    void sliderMove() {
        WebElement slider = driver.findElement(By.xpath('//*[@id="slider"]/span'))

        for (int j = 0; j < 4; j++) {
            slider.sendKeys(Keys.ARROW_RIGHT)
        }
    }

    void commentsTextbox() {
        driver.findElement(By.id('comments')).sendKeys('orem ipsum dolor sit amet, consectetur adipiscing elit, sed do ' +
                'eiusmod tempor incididunt ut labore et dolore magna aliqua. Lectus mauris ultrices eros in cursus ' +
                'turpis massa tincidunt. Vitae turpis massa sed elementum. Enim praesent elementum facilisis leo ' +
                'vel fringilla. Magna eget est lorem ipsum. Eget mi proin sed libero enim. Leo integer malesuada nunc ' +
                'vel risus commodo viverra maecenas accumsan. Nibh nisl condimentum id venenatis. Quam pellentesque ' +
                'nec nam aliquam sem et tortor. Mauris augue neque gravida in. Pellentesque elit ullamcorper dignissim ' +
                'cras tincidunt lobortis feugiat vivamus at. Vitae aliquet nec ullamcorper sit. Urna porttitor rhoncus ' +
                'dolor purus non. Etiam erat velit scelerisque in dictum. At augue eget arcu dictum.')
    }

    void submitButton(){
        driver.findElement(By.id('submit-button')).click()
    }

    String thankYouHeader(){
        driver.findElement(By.id('article-header')).getText()
    }
}
