package hdfs24;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.jboss.netty.handler.codec.replay.VoidEnum;

import java.util.HashMap;

public class context {
    private HashMap<Object, Object> contextMap = new HashMap<>();

    public void write(Object key, Object value){
        contextMap.put(key, value);
    }
    public Object get(Object key){
        return contextMap.get(key);
    }
    public HashMap<Object,Object> getContextMap(){
        return contextMap;
    }
}
