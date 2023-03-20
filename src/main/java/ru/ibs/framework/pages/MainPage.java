package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class, 'primaryRed')]")
    private WebElement catalog;

    @FindBy(xpath = "//ul[contains(@class, 'Catalog_mainList')]/a/div")
    private List<WebElement> categoryList;

    public MainPage clickCatalogBtn() {
        waitUtilElementToBeClickable(catalog).click();
        return this;
    }

    public CategoryPage selectCategory(String nameCategory) {
        for (WebElement categoryItem : categoryList) {
            waitUtilElementToBeVisible(categoryItem);
            if (categoryItem.getText().trim().equalsIgnoreCase(nameCategory)) {
                waitUtilElementToBeClickable(categoryItem).click();
                return pageManager.getCategoryPage();
            }
        }
        fail("Категория товаров '" + nameCategory + "' не была найдена!");
        return pageManager.getCategoryPage();
    }
}
