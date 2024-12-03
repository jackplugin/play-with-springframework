package fun.erudite.playwithsf.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Book book1() {
        return new Book("0123456", "Spring Start Here");
    }
}
