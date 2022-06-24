package com.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    static Properties prop = new Properties();


    static{
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            prop.load(file);
            file.close();

        } catch (IOException e) {
        }

    }

    public static String getProperty(String keyword){
        return prop.getProperty(keyword);
    }
}
