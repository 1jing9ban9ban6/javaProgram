package interfaceDemo.bin;

public class user {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public void set(String userName, String password){
        this.name = userName;
        this.password = password;
    }
}
