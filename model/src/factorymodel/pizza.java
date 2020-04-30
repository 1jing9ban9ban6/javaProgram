package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:22
 */
public abstract class pizza {
    protected String name;
//    准备原材料 因为不同pizza原材料不一样所以这个是抽象方法
    public abstract void prepare();

    public void bake(){
        System.out.println(name+" baking;");
    }

    public void cut(){
        System.out.println(name+" cutting;");
    }

    public void box(){
        System.out.println(name+" boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
