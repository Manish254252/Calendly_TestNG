package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigWriter {

    public static void writeToPropertiesFile( String key, String value) {
        Properties properties = new Properties();
        String filePath = "src/test/resources/Config/Config.properties";
        try (FileInputStream in = new FileInputStream(filePath)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream out = new FileOutputStream(filePath)) {

            properties.setProperty(key, value);


            properties.store(out, "Updated properties file");
            System.out.println("Property " + key + " has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

