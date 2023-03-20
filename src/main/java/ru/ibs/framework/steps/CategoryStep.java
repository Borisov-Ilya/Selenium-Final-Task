package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class CategoryStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Выбираем подкатегорию товаров - \"(.+)\"$")
    public void selectSubCategory(String nameSubCategory) {
        pageManager.getCategoryPage().selectSubCategory(nameSubCategory);
    }
}
