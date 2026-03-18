import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile

class BrowserSetupListener {

    @BeforeTestCase
    def setup() {

        FirefoxProfile profile = new FirefoxProfile()

        // Disable password manager
        profile.setPreference("signon.rememberSignons", false)

        // Disable breach warning popup
        profile.setPreference("signon.management.page.breach-alerts.enabled", false)

        // Disable autofill
        profile.setPreference("signon.autofillForms", false)

        // Disable Firefox Monitor
        profile.setPreference("extensions.fxmonitor.enabled", false)

        FirefoxOptions options = new FirefoxOptions()
        options.setProfile(profile)

        DriverFactory.changeWebDriver(new FirefoxDriver(options))
    }
}