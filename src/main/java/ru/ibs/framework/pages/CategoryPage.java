package ru.ibs.framework.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> subCategoryList;

    public SearchPage selectSubCategory(String nameSubCategory) {
        int i = 0;
        while (i < 1000) {
            for (WebElement subCategoryItem : subCategoryList) {
                try {
                    waitUtilElementToBeVisible(subCategoryItem);
                    if (subCategoryItem.getText().contains(nameSubCategory)) {
                        waitUtilElementToBeClickable(subCategoryItem).click();
                        return pageManager.getSearchPage();
                    }
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        fail("Подкатегория товаров '" + nameSubCategory + "' не была найдена!");
        return pageManager.getSearchPage();
    }
}
