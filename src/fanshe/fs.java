package fanshe;

public class fs implements LoginService{

    @Override
    public void say(String name) {
        System.out.println("hello"+name);
    }

    @Override
    public void eat(String food){
        System.out.println(food+"eat");
    }

    @Override
    public String say1(String name){
        return "helloooooooooo"+name;
    }
}
