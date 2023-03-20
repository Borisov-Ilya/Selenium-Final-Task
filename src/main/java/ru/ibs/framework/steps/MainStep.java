package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class MainStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Нажимаем кнопку 'Каталог'$")
    public void clickCatalogBtn() {
        pageManager.getMainPage().clickCatalogBtn();
    }

    @И("^Выбираем категорию товаров - \"(.+)\"$")
    public void selectMainCategory(String nameCategory) {
        pageManager.getMainPage().selectCategory(nameCategory);
    }
}
