package fun.erudite.playwithsf.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit")
    public BeanDemo myBean() {
        return new BeanDemo();
    }

}
