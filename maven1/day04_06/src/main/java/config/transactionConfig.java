package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class transactionConfig {
    @Bean("transactionManager")
    public PlatformTransactionManager create(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
