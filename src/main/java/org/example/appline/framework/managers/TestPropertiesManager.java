package org.example.appline.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {

    private final Properties properties = new Properties();
    private static TestPropertiesManager INSTANCE = null;

    private TestPropertiesManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }
    public static TestPropertiesManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropertiesManager();
        }
        return INSTANCE;
    }
    private void loadApplicationProperties() {
        String nameFile = System.getProperty("propFile", "application");
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" +
                             nameFile + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                            !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
