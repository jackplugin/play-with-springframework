package fun.erudite.playwithsf.beanlifecycle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BeanDemoTest {

    AnnotationConfigApplicationContext ctx;

    @BeforeEach
    void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @AfterEach
    void tearDown() {
        ctx.close();
    }

    @Test
    void sayHello() {
        BeanDemo beanDemo = ctx.getBean(BeanDemo.class);
        beanDemo.sayHello();
    }
}