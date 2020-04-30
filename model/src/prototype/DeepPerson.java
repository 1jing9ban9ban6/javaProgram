package prototype;

import java.io.*;

/**
 * @author jing
 * @create 2020-04-16-16:22
 */
public class DeepPerson implements Cloneable, Serializable{
    private String name;
    private String password;
    private Sheep sheep;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public DeepPerson() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public DeepPerson(String name, String password, Sheep sheep) {
        this.name = name;
        this.password = password;
        this.sheep = sheep;
    }

    @Override
    public String toString() {
        return "DeepPerson{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sheep=" + sheep +
                '}';
    }

    @Override
    protected DeepPerson clone() {
        DeepPerson deepPerson = null;
        try {
            deepPerson = (DeepPerson)super.clone();
            deepPerson.sheep = sheep.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return deepPerson;
    }
    public DeepPerson deepClone() {
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        DeepPerson copy = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            copy = (DeepPerson) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                oos.close();
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copy;
    }
}
