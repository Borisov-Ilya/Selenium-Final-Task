package ru.ibs.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PageManager;

public class SearchStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем заголовок на странице поиска - \"(.+)\"$")
    public void checkSearchPageTitle(String searchPageTitle) {
        pageManager.getSearchPage().checkSearchPageTitle(searchPageTitle);
    }

    @И("^Заполняем поля формы:$")
    public void fillFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getSearchPage().fillField((String) key, (String) value));
    }

    @И("^Проверить завершение поиска по категории \"(.+)\"$")
    public void checkFilterTitle (String filterTitle) {
        pageManager.getSearchPage().checkFilterTitle(filterTitle);
    }

    @И("^Нажимаем на найденного производителя$")
    public void clickManufacturerCheckbox() {
        pageManager.getSearchPage().clickManufacturerCheckbox();
    }

    @И("^Ожидание результатов поиска$")
    public void waitingSearchResults() {
        pageManager.getSearchPage().waitingSearchResults();
    }

    @И("^Проверить, что в поисковой выдаче не более (24|36|48|100) товаров$")
    public void checkCountSetter(String count) {
        pageManager.getSearchPage().checkCountSetter(count);
    }

    @И("^Сохранить наименование (\\d+) товара в списке$")
    public void selectProductTitle(int number) {
        pageManager.getSearchPage().saveProductTitle(number);
    }

    @И("^В поисковую строку ввести запомненное значение, выполнить поиск$")
    public void fillSearchInput() {
        pageManager.getSearchPage().fillSearchInput();
    }

    @И("^Проверить, что в поисковой выдаче товаров не более - (\\d+)$")
    public void checkPageTitleCount(int number) {
        pageManager.getSearchPage().checkPageTitleCount(number);
    }

    @И("^Проверить, что наименование товара соответствует сохраненному значению$")
    public void checkTitles() {
        pageManager.getSearchPage().checkTitles();
    }
}
