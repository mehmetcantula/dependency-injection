package guru.springframework.config;

import guru.springframework.exapmlebean.FakeDataSource;
import guru.springframework.exapmlebean.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources({
//        @PropertySource("classpath:datasource.properties"),
//        @PropertySource("classpath:jms.properties")
//})
public class PropertyConfig {

    @Value("${guru.username}")
    private String user;
    @Value("@{guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String url;
    @Value("${guru.jms.username}")
    private String jmsUsername;
    @Value("${guru.jms.password}")
    private String jmsPassword;
    @Value("${guru.jms.url}")
    private String jmsUrl;


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }

}
