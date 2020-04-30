package dataCollect;

import java.util.Properties;

public class propertiesHoldLazy {
    private static Properties prop = null;

    /**
     *  懒汉式单例 考虑了线程安全
     * @return 如果创建了就返回没有就创建在返回
     * @throws Exception
     */
    public static Properties getProp() throws Exception{
        if (prop==null){
            synchronized (propertiesHoldLazy.class) {
                if (prop==null) {
                    prop = new Properties();
                    prop.load(propertiesHoldLazy.class.getClassLoader().getResourceAsStream(
                            "collect.properties"));
                }
            }
        }
        return prop;
    }
}
