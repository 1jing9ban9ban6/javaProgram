package fanshe;

import java.lang.reflect.Method;
import java.util.Properties;

public class fanSheDemo {
  public static void main(String[] args) throws Exception{
//      String type = "fanshe.fs";
//      String func = "say";
//      String paramType = "java.lang.String";
      Properties prop = new Properties();
    // 搞配置文件的封装类
    //      prop.put("type", "fanshe.fs");
    //      prop.put("func", "say");
    //      prop.put("paramType", "java.lang.String");
      prop.load(fanSheDemo.class.getClassLoader().
              getResourceAsStream("fanshe/xx.properties"));
      String type = prop.getProperty("type");
      String func = prop.getProperty("func");
      String paramType = prop.getProperty("paramType");

      Class<?> forName = Class.forName(type);
      Object o = forName.newInstance();
      Method method = forName.getMethod(func, Class.forName(paramType));

      method.invoke(o,"hhhh");
  }




}
