package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckOut extends PreRequisites {
    public void checkOutAndPay() throws InterruptedException {

        Locator checkOutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Checkout "));
        checkOutButton.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/onepagecheckout#opc-billing");

        Thread.sleep(2000);

        if (page.locator("label[for=\"billing-address-select\"]").isVisible()) {
            Locator firstContinueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).nth(0);
            firstContinueButton.click();
        } else if (page.url().equals("https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart")) {

            Locator checkOutAsGuest = page.locator("button[class=\"button-1 checkout-as-guest-button\"]");
            checkOutAsGuest.click();

            Locator selectCountry = page.locator("select[data-trigger=\"country-select\"]");
            selectCountry.selectOption("Egypt");


            Locator city = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City:"));
            city.fill("Haram");

            Locator billingAddress = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address 1:"));
            billingAddress.fill("Haram");

            Locator zipCode = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip / postal code:"));
            zipCode.fill("1223345");


            Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone number:"));
            phoneNumber.fill("012345678");

            Locator continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
            continueButton.click();

            assertThat(page).hasURL("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method");


        } else if (page.url().equals("https://demo.nopcommerce.com/onepagecheckout#opc-billing")) {

            Locator selectCountry = page.locator("select[data-trigger=\"country-select\"]");
            selectCountry.selectOption("Egypt");


            Locator city = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City:"));
            city.fill("Haram");

            Locator billingAddress = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address 1:"));
            billingAddress.fill("Haram");

            Locator zipCode = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip / postal code:"));
            zipCode.fill("1223345");


            Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone number:"));
            phoneNumber.fill("012345678");

            Locator continueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
            continueButton.click();

            assertThat(page).hasURL("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method");

        }
        page.waitForTimeout(2000);

        Locator shippingMethod = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Next Day Air (€0.00)"));
        shippingMethod.check();
        assertThat(page.locator("label[for=\"shippingoption_1\"]")).isChecked();

        Locator shippingMethodContinue = page.locator("button[class=\"button-1 shipping-method-next-step-button\"]");
        shippingMethodContinue.click();

        Locator paymentMethodContinue = page.locator("button[onclick=\"PaymentMethod.save()\"]");
        paymentMethodContinue.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info");

        Locator paymentInformationContinue = page.locator("button[class=\"button-1 payment-info-next-step-button\"]");
        paymentInformationContinue.click();

        Locator confirmButton = page.locator("button[class=\"button-1 confirm-order-next-step-button\"]");
        confirmButton.click();

        Locator successfulOrder = page.locator("div[class=\"title\"]").first();
        //     String successfulOrderMessage = successfulOrder.textContent();

        assertThat(successfulOrder).containsText("Your order has been successfully processed!");


        Locator lastContinueButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
        lastContinueButton.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/");


    }
}
