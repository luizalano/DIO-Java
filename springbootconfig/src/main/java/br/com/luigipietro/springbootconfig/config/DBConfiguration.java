package br.com.luigipietro.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//Usa tudo que tem spring.datasource nos propertires
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    // Mapeando com Bean o método sobe no início da execução
    public String testDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB connection for production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Test instance";
    }

}
