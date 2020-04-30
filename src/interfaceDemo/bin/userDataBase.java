package interfaceDemo.bin;

import java.util.HashMap;

public class userDataBase {
    public static HashMap<String, user> userMap = new HashMap<>();
    static {
        // 随着类的加载而优先加载，预制数据
        // 首先执行静态代码块，如果有多份静态的代码，则从上往下执行
        // 然后执行普通代码块，
        // 然后执行构造方法
        user testUser = new user();
        testUser.set("admin","asasas");
        userMap.put(testUser.getName(), testUser);
    }
}
