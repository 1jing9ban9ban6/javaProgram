package socket;

import file.highFile;
import file.person;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class talk2 implements Runnable {

    private Socket sc;
    private highFile hf;
    public talk2() {
    }

    public talk2(Socket sc, highFile hf) {
        this.sc = sc;
        this.hf = hf;
    }

    public Socket getIs() {
        return sc;
    }

    public void setIs(Socket is) {
        this.sc = is;
    }

    @Override
    public void run(){
        try {
            InputStream is = sc.getInputStream();
            OutputStream os = sc.getOutputStream();
            ObjectOutputStream oops = new ObjectOutputStream(os);
            byte[] bytes = new byte[1024];
            int num = is.read(bytes);
            String s = new String(bytes,0,num);
            if (s.contains("id")){
                String substring = s.substring(s.indexOf("=")+1);
                int i = Integer.parseInt(substring);
                person personById = hf.getPersonById(i);
                oops.writeObject(personById);
                os.close();
                is.close();
                oops.close();
            } else{
                String[] s1 = s.split(" ");
                String s2 = s1[s1.length - 1];
                ArrayList<person> personByName = hf.getPersonByName(s2);
                oops.writeObject(personByName);
                os.close();
                is.close();
                oops.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
