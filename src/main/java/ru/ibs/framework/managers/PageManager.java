package ru.ibs.framework.managers;

import ru.ibs.framework.pages.CategoryPage;
import ru.ibs.framework.pages.MainPage;
import ru.ibs.framework.pages.SearchPage;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Главная страница
     */
    private MainPage mainPage;

    /**
     * Страница поиска
     */
    private SearchPage searchPage;

    /**
     * Страница категорий товаров
     */
    private CategoryPage categoryPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return MainPage
     */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    /**
     * Ленивая инициализация {@link CategoryPage}
     *
     * @return MainPage
     */
    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    /**
     * Ленивая инициализация {@link SearchPage}
     *
     * @return SearchPage
     */
    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }
}
