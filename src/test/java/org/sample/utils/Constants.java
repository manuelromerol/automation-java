package org.sample.utils;

public final class Constants {
    private Constants() {}

//    public static final String HOME_PAGE_URL = "https://demoqa.com/books";
    public static final String HOME_PAGE_URL = ConfigReader.getProperty("baseUrl");
    public static final String HOME_PAGE_TITLE = "demosite";
    public static final String MAIN_ISBN = "9781449325862";
}
