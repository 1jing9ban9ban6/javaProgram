package SetMap;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author jing
 * @create 2020-03-01-12:27
 */
public class properties {
    @Test
    public void test1() throws Exception{
        Properties prop = new Properties();
        ClassLoader loader = properties.class.getClassLoader();
        InputStream ras = loader.getResourceAsStream("jdbc.properties");
//        FileInputStream fis = new FileInputStream("jdbc.properties");
        prop.load(ras);
        String name = prop.getProperty("name");
        System.out.println(name);
    }
}
