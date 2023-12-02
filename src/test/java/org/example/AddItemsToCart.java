package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddItemsToCart extends PreRequisites {
    public void addMultipleItemsToCart() throws InterruptedException {


        Locator computerHover = page.locator("a[href=\"/computers\"]");
        computerHover.nth(0).hover();

        Locator sublist = page.locator("ul[class=\"sublist first-level\"]", new Page.LocatorOptions().setHasText("Notebooks ")).nth(0);
        sublist.click();

        Locator addFirstItem = page.locator("button[class=\"button-2 product-box-add-to-cart-button\"]").nth(4);
        addFirstItem.click();
        page.waitForTimeout(1000);


        Locator electronics = page.locator("a[href=\"/electronics\"]").first();
        electronics.hover();

        //      Locator subListEle = page.locator("ul[class=\"sublist first-level\"]");

        String obj = "Camera & photo ";


        //in here im asking it to choose the element from the drop down list which is the Camera & photo from the drop down of electronics list ,,
        //its a new method instead of using  new Page.LocatorOptions().setHasText()
        page.getByRole(AriaRole.LISTITEM)
                .filter(new Locator.FilterOptions().setHasText("Camera & photo ")).nth(1)
                .click();

        Locator wishList = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to wishlist")).nth(0);
        wishList.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/nikon-d5500-dslr");
        Thread.sleep(1000);
        page.waitForTimeout(1000);


        Locator addToWishList = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to wishlist")).nth(0);
        addToWishList.scrollIntoViewIfNeeded();
        addToWishList.click();

        assertThat(page.locator("p[class=\"content\"]")).isVisible();


    }
}
