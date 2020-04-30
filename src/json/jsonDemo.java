package json;

import com.google.gson.Gson;

public class jsonDemo {
    public static MoiveRate parseLine(String line){
        Gson gson = new Gson();
        MoiveRate o = gson.fromJson(line, MoiveRate.class);
        return o;
    }
}
