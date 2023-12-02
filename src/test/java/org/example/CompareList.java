package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CompareList extends PreRequisites {
    public void comparison() throws InterruptedException {
        Locator computerHover = page.locator("a[href=\"/computers\"]");
        computerHover.nth(0).hover();

        Locator sublist = page.locator("ul[class=\"sublist first-level\"]", new Page.LocatorOptions().setHasText("Notebooks ")).nth(0);
        sublist.click();


        Thread.sleep(1000);

        page.locator("button[class=\"button-2 add-to-compare-list-button\"]").first().click();

       /* firstLab.scrollIntoViewIfNeeded();

        firstLab.nth(0).click();*/


        Thread.sleep(1000);

        //firstLab.hover();\
        Locator successMessage = page.locator("div[class=\"bar-notification success\"]");
        String successMessageText = successMessage.textContent();
        System.out.println(successMessageText);

        //*[@id=\"bar-notification\"]/div/p/text()");
        //  page.waitForTimeout(1000);
        //String successMessage =


        assertThat(successMessage).containsText("The product has been added to your product comparison");
        //      Assert.assertEquals(successMessageText,"The product has been added to your product comparison");
        // System.out.println(successMessage);
        page.waitForTimeout(1000);


        //assertThat();
        //System.out.println(successMessage);
        // successMessage.scrollIntoViewIfNeeded();
        //Assert.assertEquals(successMessage,"The product has been added to your product comparison");
        // assertThat(page.locator(String.valueOf(successMessage)).isVisible());

        Locator secondLab = page.locator("button[class=\"button-2 add-to-compare-list-button\"]").nth(1);
        secondLab.click();
        assertThat(page.locator("p[class=\"content\"]")).isVisible();


        page.waitForTimeout(1000);

        Locator compareProductList = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Compare products list"));
        compareProductList.scrollIntoViewIfNeeded();
        compareProductList.click();

        String compareURL = page.url();
        Assert.assertEquals(compareURL, "https://demo.nopcommerce.com/compareproducts");


        page.waitForTimeout(1000);

    }
}
