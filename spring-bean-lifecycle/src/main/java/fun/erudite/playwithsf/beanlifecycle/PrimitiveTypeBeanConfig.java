package fun.erudite.playwithsf.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrimitiveTypeBeanConfig {

    @Bean
    public String stringTypedBean() {
        System.out.println("A String-typed bean named stringTypedBean is created by Spring Framework.");
        return "This is a String-typed bean";
    }

    @Bean
    public Integer integerTypedBean() {
        System.out.println("An Integer-typed bean named integerTypedBean is created by Spring Framework");
        return 1;
    }

    @Bean
    public Float floatTypedBean() {
        System.out.println("A Float-typed bean named floatTypedBean is created by Spring Framework");
        return 1.111f;
    }
}
