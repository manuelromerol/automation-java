package org.sample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        // 1. Check if the property was passed via Command Line (-Dheadless=true)
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }

        // 2. If not, fall back to the config.properties file
        return properties.getProperty(key);
    }
}
