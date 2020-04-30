package RPC;

import file.person;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.ArrayList;

public class readDataUtil {
    public highFile getInstance(){
        highFile hf = (highFile) Proxy.newProxyInstance(highFile.class.getClassLoader(),
            new Class<?>[] {highFile.class}, new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            if (method.getName().equals("getPersonById")) {
                Socket sc = new Socket("127.0.0.1", 9997);
                OutputStream os = sc.getOutputStream();
                InputStream is = sc.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                /*
                * 发送请求
                *
                * */
                os.write(("select * from pro.dat where id="+args[0]).getBytes());
                /*
                * 接收请求
                * */
                person p = (person) ois.readObject();
                os.close();
                is.close();
                ois.close();
                return p;
            } else {
                Socket sc = new Socket("127.0.0.1", 9997);
                OutputStream os = sc.getOutputStream();
                InputStream is = sc.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                /*
                 * 发送请求
                 *
                 * */
                os.write(("select * from pro.dat where name like "+args[0]).getBytes());
                /*
                 * 接收请求
                 * */
                ArrayList<file.person> pList =(ArrayList<file.person>) ois.readObject();
                os.close();
                is.close();
                ois.close();
                return pList;
        }
      }
    });
        return hf;
    }
}
