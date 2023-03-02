package com.saucelabs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    Properties prop = null;

    public void loadProperties() {
        prop = new Properties();
        InputStream input = PropertyFileReader.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }

}
