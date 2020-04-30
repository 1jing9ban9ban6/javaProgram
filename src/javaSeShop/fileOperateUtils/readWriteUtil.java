package javaSeShop.fileOperateUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class readWriteUtil<T> {
    public HashMap<String, T> read(String path) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(path));
        HashMap<String, T> HashMap = (HashMap<String, T>) ois.readObject();
        ois.close();
        return HashMap;
    }

    public void write(HashMap<String, T> hashMap, String path) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path));
        oos.writeObject(hashMap);
        oos.close();
    }
}
