package com.oracle.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class OracleDataSourceConfig {

    @Value("${spring.datasource.oracle.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.oracle.username}")
    private String username;

    @Value("${spring.datasource.oracle.password}")
    private String password;

    @Value("${spring.datasource.oracle.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.oracle.hikari.pool-name}")
    private String poolName;

    @Value("${spring.datasource.oracle.hikari.minimum-idle}")
    private int minimumIdle;

    @Value("${spring.datasource.oracle.hikari.maximum-pool-size}")
    private int maximumPoolSize;

    @Value("${spring.datasource.oracle.hikari.auto-commit}")
    private boolean autoCommit;

    @Value("${spring.datasource.oracle.hikari.transaction-isolation}")
    private String transactionIsolation;

    @Value("${spring.datasource.oracle.hikari.idle-timeout}")
    private long idleTimeout;

    @Value("${spring.datasource.oracle.hikari.max-lifetime}")
    private long maxLifetime;

    @Value("${spring.datasource.oracle.hikari.connection-timeout}")
    private long connectionTimeout;

    @Value("${spring.datasource.oracle.hikari.connection-test-query}")
    private String connectionTestQuery;

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        config.setPoolName(poolName);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setAutoCommit(autoCommit);
        config.setTransactionIsolation(transactionIsolation);
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);
        config.setConnectionTimeout(connectionTimeout);
        config.setConnectionTestQuery(connectionTestQuery);

        return new HikariDataSource(config);
    }

}