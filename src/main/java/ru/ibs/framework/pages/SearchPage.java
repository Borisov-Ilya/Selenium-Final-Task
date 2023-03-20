package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class SearchPage extends BasePage {
    private String productTitle;

    @FindBy(xpath = "//h1[contains(@class, 'title')]")
    private WebElement title;

    @FindBy(xpath = "//span[text()='Цена']//ancestor::section//input[@name='min']")
    private WebElement minPriceInput;

    @FindBy(xpath = "//span[text()='Производитель']//ancestor::section//input[@placeholder='Поиск']")
    private WebElement manufacturerInput;

    @FindBy(xpath = "//span[text()='Производитель']//ancestor::section//label[contains(@class, 'text')]")
    private WebElement manufacturerCheckbox;

    @FindBy(xpath = "//div[contains(@class, 'ListingRenderer_row')]")
    private WebElement searchResult;

    @FindBy(xpath = "//span[contains(@class, 'countSetter')]")
    private WebElement countSetter;


    @FindBy(xpath = "//h6[contains(@class, 'CardText_title')]")
    private List<WebElement> resultsTitleList;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[contains(@class, 'PageTitle_count')]")
    private WebElement pageTitleCount;


    @FindBy(xpath = "//div[contains(@class, 'ListingRenderer')]//h6[contains(@class, 'CardText_title')]")
    private WebElement productTitleAfterSearch;

    public SearchPage checkSearchPageTitle(String searchPageTitle) {
        waitingSearchResults();
        assertEquals(searchPageTitle, title.getText(),
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    public SearchPage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Цена от":
                fillInputField(minPriceInput, value);
                element = minPriceInput;
                break;
            case "Производитель":
                fillInputField(manufacturerInput, value);
                element = manufacturerInput;
                break;
            default:
                fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Создания командировки'");
        }
        assertEquals(value, element.getAttribute("value"),
                "Поле '" + nameField + "' было заполнено некорректно");
        return this;
    }

    public SearchPage clickManufacturerCheckbox() {
        waitUtilElementToBeClickable(manufacturerCheckbox).click();
        return this;
    }

    public SearchPage waitingSearchResults() {
        assertTrue(searchResult.isDisplayed(), "Результаты поиска не отобразились на странице");
        return this;
    }

    public SearchPage checkCountSetter(String count) {
            assertTrue(countSetter.getText().trim().contains(count),
                    String.format("Количество товаров на странице - \nExpected: %s\nActual: %s\n",
                            count, countSetter.getText().trim()));
        return this;
    }

    public String selectProductTitle(int number) {
        productTitle = resultsTitleList.get(number - 1).getText().trim();
        return productTitle;
    }

    public SearchPage fillSearchInput() {
        fillInputField(searchInput, productTitle);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchPage checkPageTitleCount(int number) {
        wait.until(numberOfElementsToBe(By.xpath("//div[contains(@class,'Card_row')]"), number));
        return this;
    }

    public SearchPage checkTitles() {
        assertEquals(productTitleAfterSearch.getText().trim(), productTitle,
                "Наименования товаров не совпадают");
        return this;
    }
}
