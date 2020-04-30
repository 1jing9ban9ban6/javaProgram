package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.itheima")
@Import({jdbcConfig.class,transactionConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement
public class springConfigration {
}
