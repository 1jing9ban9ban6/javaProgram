package fanshe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class serviceTest {
    public static void main(String args[]) throws Exception{
        // 框架中的反射
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("g:/flie/a.txt")));
        HashMap<String, String> classHM = new HashMap<>();
        String classLine = null;
        while ((classLine=br.readLine())!=null){
            String[] classSplit = classLine.split(":");
            classHM.put(classSplit[0],classSplit[1]);
        }
        Class<?> forName1 = Class.forName(classHM.get("serviceOneTwo"));
        serviceOneTwo newInstance1 = (serviceOneTwo)forName1.newInstance();
        newInstance1.say();

        Class<?> forName2 = Class.forName(classHM.get("OtherServiceOneTwo"));
        OtherServiceOneTwo newInstance2 = (OtherServiceOneTwo)forName2.newInstance();
        newInstance2.eat();

    }
}
