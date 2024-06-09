package org.example.appline.framework.pages.task1;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'remaining')]")
    private WebElement remainingCountElement;

    @FindBy(xpath = "//span[contains(text(),'5 of 5 remaining')]")
    private WebElement remainingText;

    @FindBy(xpath = "//ul[@class='list-unstyled']/li[1]/span")
    private WebElement firstItem;

    @FindBy(xpath = "//ul[@class='list-unstyled']/li[last()]/span")
    private WebElement lastItem;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(id = "sampletodotext")
    private WebElement inputField;



    public String getRemainingText() {
        return remainingText.getText();
    }

    public String getFirstItemClass() {
        return firstItem.getAttribute("class");
    }

    public boolean isFirstCheckboxSelected() {
        return checkboxes.get(0).isSelected();
    }

    public void clickFirstCheckbox() {
        checkboxes.get(0).click();
    }

    public void addItem(String text) {
        inputField.sendKeys(text);
        inputField.sendKeys(Keys.ENTER);
    }

    public void clickLastCheckbox() {
        WebElement newCheckbox = checkboxes.get(checkboxes.size() - 1);
        newCheckbox.click();
    }

    public String getLastItemClass() {
        return lastItem.getAttribute("class");
    }
    public int getRemainingCount() {
        String remainingCountText = remainingCountElement.getText().split(" ")[0];
        return Integer.parseInt(remainingCountText);
    }
    public void clickAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void uncheckAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }
}

