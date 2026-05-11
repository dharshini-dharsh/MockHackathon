package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties prop;

    static {
        try {
            prop = new Properties();

            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties file not found");
            }

            prop.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}