package fun.erudite.playwithsf.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComplexTypeBeanConfig {
    @Bean
    Book book1() {
        return new Book("0123456", "Spring Start Here");
    }

    @Bean
    Book book2() {
        return new Book("0000002", "Domain Driven Design");
    }

    @Bean
    BookReader bookReader() {
        return new BookReader("Jack", "Li");
    }
}
