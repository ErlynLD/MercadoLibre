package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    public static String getProperty(String prop) throws IOException, FileNotFoundException {
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("src\\app.properties");
        props.load(inputStream);
        return props.getProperty(prop.trim());
    }

    public static String getSystemProperty(String prop){
        return System.getProperty(prop);
    }
}
