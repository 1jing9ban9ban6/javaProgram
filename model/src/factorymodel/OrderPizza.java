package factorymodel;

import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-16-14:30
 */
public class OrderPizza {
    public OrderPizza(AbsFactory factory){
        pizza pizza;
        String orderType;
        do {
            orderType = getType();
            pizza = factory.creatPizza(orderType);
            if (pizza == null){
                System.out.println("没有该类型pizza，请重新订购");
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    protected String getType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想要的口味");
        String s = sc.nextLine();
        return s;
    }
}
