package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchProducts extends PreRequisites {
    public void searchForProducts() throws InterruptedException {
        Locator searchStore = page.getByPlaceholder("Search store");
        searchStore.fill("if you wait");
        searchStore.press("Enter");

        Thread.sleep(1000);

        /*Locator image = page.locator("img[title=\"Show details for If You Wait (donation)\"]").nth(1);
        image.scrollIntoViewIfNeeded();

        assertThat(page.locator("img[alt=\"Picture of If You Wait (donation)\"]").nth(1)).isVisible();*/
        assertThat(page).hasURL("https://demo.nopcommerce.com/search?q=if+you+wait");

        Locator addtoCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
        addtoCart.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/if-you-wait-donation");

        Locator add = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).nth(0);
        add.click();

        assertThat(page.locator("p[class=\"content\"]")).containsText("The product has been added to your ");

        Locator close = page.locator("span[class=\"close\"]");
        close.click();


        page.waitForTimeout(2000);
    }
}
