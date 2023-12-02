package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Register extends PreRequisites {
    public void registeration() {
        Locator registerButton = page.locator("a[class=\"ico-register\"]");
        registerButton.click();

        assertThat(page).hasURL("https://demo.nopcommerce.com/register?returnUrl=%2F");

        Locator gender = page.locator("//input[@id=\"gender-male\"]");
        gender.click();


        Locator firstName = page.locator("input[name=\"FirstName\"]");
        firstName.fill(fName);

        Locator secondName = page.locator("input[id=\"LastName\"]");
        secondName.fill("omar");


        Locator bDay = page.locator("select[name=\"DateOfBirthDay\"]");
        bDay.selectOption("1");

        Locator bMonth = page.locator("select[name=\"DateOfBirthMonth\"]");
        bMonth.selectOption("10");

        Locator bYear = page.locator("select[name=\"DateOfBirthYear\"]");
        bYear.selectOption(new SelectOption().setValue("1994"));


        Locator email = page.locator("//input[@data-val-required=\"Email is required.\"]");
        email.fill(mail);

        Locator company = page.locator("input[name=\"Company\"]");
        company.fill("ay 7aga");
        //company.scrollIntoViewIfNeeded();


        Locator pWord = page.locator("input[id=\"Password\"]");
        pWord.fill(passWord);
        //pWord.scrollIntoViewIfNeeded();

        Locator confirmPword = page.locator("input[name=\"ConfirmPassword\"]");
        confirmPword.fill(passWord);
        confirmPword.scrollIntoViewIfNeeded();

        Locator clickRegister = page.locator("button[name=\"register-button\"]");
        clickRegister.click();


        // Locator textMessage = page.locator("div[class=\"result\"]");
        //System.out.println(textMessage);

        String expected = "Your registration completed";

        assertThat(page.locator("div[class=\"result\"]")).containsText(expected);


        Locator clickContinue = page.locator("a[class=\"button-1 register-continue-button\"]");
        clickContinue.click();


        page.waitForTimeout(2000);

    }
}
