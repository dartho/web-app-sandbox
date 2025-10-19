package dbt.sandbox.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"dbt.sandbox.repository", "dbt.sandbox.v2.repository"},
        entityManagerFactoryRef = "databaseEntityManagerFactory",
        transactionManagerRef = "databaseTransactionManager")
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties databaseDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource databaseDataSource() {
        return databaseDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean databaseEntityManagerFactory(
            @Qualifier("databaseDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("dbt.sandbox.model", "dbt.sandbox.v2.model")
                .build();
    }

    @Bean
    public PlatformTransactionManager databaseTransactionManager(
            @Qualifier("databaseEntityManagerFactory") LocalContainerEntityManagerFactoryBean
                    databaseEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(databaseEntityManagerFactory.getObject()));
    }

}
