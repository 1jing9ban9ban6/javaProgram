package dongtaidaili;

/**
 * @author jing
 * @create 2020-03-01-22:16
 */
interface show{
    String sing();
    String dance(String s);
}
class wang implements show{
    @Override
    public String sing() {
        return "王宝强唱歌";
    }

    @Override
    public String dance(String s) {
        return "王宝强被绿了"+s;
    }
}
class song implements show{
    private wang wang;
    public void bind(wang wang){
        this.wang=wang;
    }
    @Override
    public String sing() {
        return wang.sing();
    }

    @Override
    public String dance(String s) {
        return wang.dance(s);
    }
}
public class stateProxy {
    public static void main(String[] args) {
        wang wang = new wang();
        song song = new song();
        song.bind(wang);
        System.out.println(song.dance("hh"));
    }
}
