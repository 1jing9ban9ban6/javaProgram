package dataCollect;

import java.util.Properties;

/**
 * 饿汉式单例
 */
public class propertiesHoldHungery {
    private static Properties prop = new Properties();
    static {
        try {
            prop.load(propertiesHoldHungery.class.getClassLoader().getResourceAsStream(
                    "collect.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Properties getProp(){
        return prop;
    }
}
