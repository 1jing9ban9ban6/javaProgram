package ConnectionUtil;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author jing
 * @create 2020-04-22-10:47
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException, TimeoutException {
//        定义一个链接工厂
        ConnectionFactory factory = new ConnectionFactory();
//        设置服务地址
        factory.setHost("127.0.0.1");
//        AMQP
        factory.setPort(5672);
//        vhost
        factory.setVirtualHost("/");
//        用户名
        factory.setUsername("guest");
//        密码
        factory.setPassword("123");
//        获取链接
        Connection connection = factory.newConnection();
        return connection;
    }
}
