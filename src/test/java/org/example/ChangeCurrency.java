package org.example;

import com.microsoft.playwright.Locator;

public class ChangeCurrency extends PreRequisites {
    public void changeWebSiteCurrency() {
        Locator changeCurrecnyDropDown = page.locator("select[id=\"customerCurrency\"]");
        changeCurrecnyDropDown.click();
        changeCurrecnyDropDown.selectOption("Euro");
    }
}
