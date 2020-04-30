package sortUtil;

public class bijiaoqiImpl implements bijiaoqi<user>{
    @Override
    public boolean bijiao(user o1, user o2) {
        if(o1.getUserLevel()>o2.getUserLevel()){
            return true;
        }
        return false;
    }
}
