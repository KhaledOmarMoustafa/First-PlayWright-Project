package org.example;

import com.microsoft.playwright.*;

import java.util.List;

public class PreRequisites {
    static Page page;
    static Playwright playwright;
    static BrowserContext browser;
    String fName = "khaled";
    String mail = "khaled_omar205@hotmail.com";
    String passWord = "password";
    String friendMail = "anyone@gmail.com";

    public void openBrowser() {


        playwright = Playwright.create();

        //to make the browser appear and then maximize the window
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized"))
        ).newContext(new Browser.NewContextOptions().setViewportSize(null));

        //set the browser screen size
        // newContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));

        page = browser.newPage();
        page.navigate("https://demo.nopcommerce.com/");

    }

    public void closeBrowser() {
        page.close();
        browser.close();
        playwright.close();

    }
}
