package file;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class highFile {
    public void addPerson(person p) throws Exception{
        DataOutputStream dops = new DataOutputStream(
                new FileOutputStream("g:/flie/pro.dat",true));
        byte[] bytes = p.getName().getBytes();
        byte[] bytes1 = new byte[20];
        System.arraycopy(bytes,0,bytes1,0,bytes.length);
        // 数组拷贝函数
        dops.write(bytes1);
        dops.writeInt(p.getAge());
        dops.writeFloat(p.getSalary());
        dops.writeBoolean(p.isMarried());
        dops.close();
    }
    public ArrayList<person> getPersonByName(String name) throws Exception{
        RandomAccessFile raf = new RandomAccessFile(
                "g:/flie/pro.dat","r");
        ArrayList<person> pList = new ArrayList<>();
        int i = 0;
        while (i*29<=raf.length()){
            raf.seek(i*29);
            byte[] bytes = new byte[20];
            int read = raf.read(bytes);
            String s = new String(bytes);
            String pName = s.trim();
            if (pName.contains(name)){
                int age = raf.readInt();
                float salary = raf.readFloat();
                boolean isMarried = raf.readBoolean();
                person person = new person(pName, age, salary, isMarried);
                pList.add(person);
            }
            i++;
        }
        return pList;
    }
    public person getPersonById(int i) throws Exception{
        // float salary 4 string name 20 int age 4   boolean 1
        RandomAccessFile raf = new RandomAccessFile("g:/flie/pro.dat", "r");
        long a = i*29;
        raf.seek(a);
        byte[] bytes = new byte[20];
        int read = raf.read(bytes);
        String s = new String(bytes);
        String name = s.trim();// 去掉首尾空格
        int age = raf.readInt();
        float salary = raf.readFloat();
        boolean isMarried = raf.readBoolean();
        person person = new person(name,age,salary,isMarried);
        return person;
    }
}
