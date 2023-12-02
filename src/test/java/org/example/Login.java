package org.example;

import com.microsoft.playwright.Locator;
import org.testng.Assert;

public class Login extends PreRequisites {

    public void loginToTheWebSite() {

        Locator loginButton = page.locator("a[class=\"ico-login\"]");
        loginButton.click();

        Locator userName = page.locator("input[data-val-required=\"Please enter your email\"]");
        userName.fill(mail);

        Locator pass = page.locator("input[id=\"Password\"]");
        pass.fill(passWord);

        Locator pressLogin = page.locator("button[type=\"submit\"]");
        pressLogin.nth(1).click();


        String message = "Login was unsuccessful. Please correct the errors and try again.No customer account found\n";


        String url = page.url();
        System.out.println(url);
        String expectedURL = "https://demo.nopcommerce.com/";

        if (url.equals(expectedURL)) {

            Assert.assertEquals(url, expectedURL);
        } else if (!url.equals(expectedURL)) {
            String errorMessage = page.locator("div[class=\"message-error validation-summary-errors\"]").textContent();
            Assert.assertEquals(errorMessage, message);

        }


        page.waitForTimeout(2000);

    }
}
