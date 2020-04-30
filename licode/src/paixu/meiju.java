package paixu;

/**
 * @author jing
 * @create 2020-02-25-15:32
 */
public class meiju {
    public static void main(String[] args) {
        /**
         * 枚举类的创建
         */
        System.out.println(season.SPRING.getSeasonName());
        System.out.println(season1.WINTER);
    }
}

class season{
    private final String seasonName;
    private final String seasonDesc;

    private season(String seasonName, String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    public static final season SPRING = new season("春天","春暖花开");
    public static final season SUMMER = new season("夏天","夏天很热");
    public static final season AUTUMN = new season("秋天","秋高气爽");
    public static final season WINTER = new season("冬天","寒冬凛冽");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
enum season1 implements info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {

        }
    },
    SUMMER("夏天","夏天很热"){
        @Override
        public void show() {

        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {

        }
    },
    WINTER("冬天","寒冬凛冽"){
        @Override
        public void show() {

        }
    };

    private season1(String seasonName, String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }
    private final String seasonName;
    private final String seasonDesc;
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
interface info{
    void show();
}