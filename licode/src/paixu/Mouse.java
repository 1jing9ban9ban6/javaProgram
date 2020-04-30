package paixu;

/**
 * @author jing
 * @create 2020-02-25-11:10
 */
public class Mouse implements Comparable{
    private String name;
    private double price;

    public Mouse() {
    }

    public Mouse(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Mouse){
            Mouse mouse = (Mouse)o;
            int compare = this.getName().compareTo(((Mouse) o).getName());
            if (compare!=0){
                return compare;
            } else {
                return Double.compare(this.getPrice(), ((Mouse) o).getPrice());
            }
        }
        else {
            throw new RuntimeException("数据不一致");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mouse mouse = (Mouse) o;

        if (Double.compare(mouse.price, price) != 0) return false;
        return name.equals(mouse.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
