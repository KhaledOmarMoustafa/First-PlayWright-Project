package org.example;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendAGift extends PreRequisites {
    public void sendGifts() {


        Locator giftPage = page.locator("a[href=\"/gift-cards\"]").nth(0);
        giftPage.click();

        Locator addGiftToCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).nth(0);
        addGiftToCart.click();

        Locator name = page.locator("input[name=\"giftcard_43.RecipientName\"]");
        name.fill("anyone");

        Locator email = page.locator("input[type=\"email\"]").nth(0);
        email.fill(friendMail);

        Locator myName = page.locator("input[id=\"giftcard_43_SenderName\"]");
        myName.fill(fName);

        Locator myEmail = page.locator("input[name=\"giftcard_43.SenderEmail\"]");
        myEmail.fill(mail);

        Locator message = page.locator("textarea[class=\"message\"]");
        message.fill("Happy BirthDay");

        Locator sendViaEmail = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Email a friend"));
        sendViaEmail.click();

        Locator enterFriendsMail = page.getByPlaceholder("Enter friend's email.");
        enterFriendsMail.fill(friendMail);

        Locator enterMyEmail = page.getByPlaceholder("Enter your email address.");
        enterMyEmail.fill(mail);

        Locator personalMessage = page.getByPlaceholder("Enter personal message (optional).");
        personalMessage.fill("ENJOYYYYY");

        Locator sendTheMail = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send email"));
        sendTheMail.click();

        assertThat(page.locator("div[class=\"result\"]")).containsText("\n" +
                "Your message has been sent.");


        page.waitForTimeout(2000);


    }

}
