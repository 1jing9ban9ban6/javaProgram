package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jing
 * @create 2020-03-17-17:53
 */
public class callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new task());
        new Thread(futureTask,"A").start();
//        futureTask.run();
        System.out.println(futureTask.get());
    }
}

class task implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("我进来了");
        return "null";
    }
}
