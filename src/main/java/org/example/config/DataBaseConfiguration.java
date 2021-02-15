package org.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@PropertySource(value = { "classpath:application.properties" })
public class DataBaseConfiguration {

//    @Autowired
//    private Environment env;

    //Init SessionFactory
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("org.example.model");
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    //Init Datasource
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource sessionFactory = new DriverManagerDataSource();
        sessionFactory.setUrl("jdbc:postgresql://localhost:5432/sweetdb");
        sessionFactory.setPassword("root");
        sessionFactory.setUsername("postgres");
        sessionFactory.setDriverClassName("org.postgresql.Driver");
        Properties properties = new Properties();

        return sessionFactory;
    }

    //Init hibernate props
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(AvailableSettings.SHOW_SQL, true);
        return properties;
    }

    /**
     * Initialize Transaction Manager
     *
     * @param sessionFactory
     * @return HibernateTransactionManager
     */
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
