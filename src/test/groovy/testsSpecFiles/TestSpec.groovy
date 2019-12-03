package testsSpecFiles

import org.junit.Rule
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.testcontainers.containers.BrowserWebDriverContainer
import pageObjects.ItemPage
import pageObjects.MainPage
import pageObjects.SearchResultPage
import pageObjects.TestCafeTestPage
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class TestSpec extends Specification {

    final static WEB_PAGE = "http://automationpractice.com/index.php"
    final static TEST_CAFE_COMPARISON = "https://devexpress.github.io/testcafe/example/"

    RemoteWebDriver driver
    MainPage mainPage
    SearchResultPage searchResultPage
    ItemPage itemPage
    TestCafeTestPage testCafeTestPage

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
        testCafeTestPage = new TestCafeTestPage(driver)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        //driver.manage().window().maximize()
        //driver.manage().window().setSize(new Dimension(1920, 1080))
    }

    def cleanup() {
        driver.quit()
    }

    def "Comparision with Testcafe and Cypress"() {
        given:
        driver.get(TEST_CAFE_COMPARISON)
        when:
        testCafeTestPage.developerNameTextField()
        and:
        testCafeTestPage.remoteTestingCheckbox()
        testCafeTestPage.reusingCodeCheckbox()
        testCafeTestPage.backgroundParallelTestingCheckbox()
        testCafeTestPage.continuousIntegrationEmbeddingCheckbox()
        testCafeTestPage.trafficMarkupAnalysisCheckbox()
        testCafeTestPage.triedTestcafe()
        testCafeTestPage.macOsOperatingRadio()
        testCafeTestPage.testcafeInterfaceDropdown()
        testCafeTestPage.sliderMove()
        testCafeTestPage.commentsTextbox()
        testCafeTestPage.submitButton()
        then:
        testCafeTestPage.thankYouHeader().contains(testCafeTestPage.devName)
    }

    def "This is description of this test so that you can understand purpose of it. "() {
        when: "I go to http://automationpractice.com/index.php web page"
        driver.get(WEB_PAGE)

        and: "I wait for page to load the search box"
        mainPage.typeShirtIntoTextBox()

        and: "I click the search result"
        searchResultPage.clickFadedShirtSearchResult()

        then: "I search for the price of item and check if the price matches 16.51"
        itemPage.priceOfShirt().contains("16.51")

        and: "I wait for 1 seconds to see the result"
        sleep(1000)
    }
}
