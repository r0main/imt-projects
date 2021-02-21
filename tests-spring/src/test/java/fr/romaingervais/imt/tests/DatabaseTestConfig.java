package fr.romaingervais.imt.tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseTestConfig {
    /**
     * Create a in memory Database when initializing spring. It's just for the demo, don't use this in production <br />
     * It also creates a bean of type {@link DataSource}
     *
     * @return a {@link DataSource} for this database
     */
    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase createDb() {
        System.out.println("Creating H2 Database for testing !!!");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("create-tables.sql")
                .build();
    }
}
