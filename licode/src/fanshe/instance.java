package fanshe;

import org.junit.Test;
import paixu.Mouse;

/**
 * @author jing
 * @create 2020-03-01-14:09
 */
public class instance {
    @Test
    public void test1() throws Exception{
        Class<Mouse> aClass = Mouse.class;
        Mouse mouse = aClass.newInstance();
    }
}
