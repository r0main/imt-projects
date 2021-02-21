package fr.romaingervais.imt.tests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    /**
     * Creates a {@link DataSource} for the production Database
     */
    @Bean
    @Profile("!test")
    public DataSource dataSource(@Value("datasource.driverClassName") String driverClassName,
                               @Value("datasource.url") String url,
                               @Value("datasource.username") String username,
                               @Value("datasource.password") String password) {
        System.out.println("Connecting to production Database");
        DriverManagerDataSource datasSource = new DriverManagerDataSource(url, username, password);
        datasSource.setDriverClassName(driverClassName);
        return datasSource;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
