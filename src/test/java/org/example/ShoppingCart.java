package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShoppingCart extends PreRequisites {
    public void cart() throws InterruptedException {
        Locator clickOnShoppingCart = page.locator("span[class=\"cart-label\"]");
        clickOnShoppingCart.click();

        Locator serviceAgreement = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("I agree with the terms of service and I adhere to them unconditionally"));
        serviceAgreement.check();
        Thread.sleep(2000);
        assertThat(page.locator("label[for=\"termsofservice\"]")).isChecked();


    }
}
