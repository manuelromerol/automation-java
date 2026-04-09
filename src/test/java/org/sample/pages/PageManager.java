package org.sample.pages;

public class PageManager {
    private static final ThreadLocal<PageObjectsCentral> manager = new ThreadLocal<>();

    public static PageObjectsCentral getPages() {
        return manager.get();
    }

    public static void setPages(PageObjectsCentral pagesInstance) {
        manager.set(pagesInstance);
    }

    public static void clean() {
        manager.remove();
    }
}
