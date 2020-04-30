package sortUtil;

public class pricebijiao implements bijiaoqi<shangPin> {
    @Override
    public boolean bijiao(shangPin o1, shangPin o2) {
        if (o1.getPrice()>o2.getPrice()){
            return true;
        }
        return false;
    }
}
