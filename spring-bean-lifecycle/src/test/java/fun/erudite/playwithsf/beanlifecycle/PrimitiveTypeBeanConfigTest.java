package fun.erudite.playwithsf.beanlifecycle;

import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.MessageFormat;
import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrimitiveTypeBeanConfigTest {
    private AnnotationConfigApplicationContext ctx;

    @BeforeAll
     void beforeAll() {
        System.out.println("Start AnnotationConfigApplicationContext in beforeAll() method.");
        ctx = new AnnotationConfigApplicationContext(PrimitiveTypeBeanConfig.class);
        System.out.println("All the beans defined in PrimitiveTypeBeanConfig.class are loaded.");
        System.out.println(MessageFormat.format("Find {0} Bean Definition from the current context", ctx.getBeanDefinitionCount()));
        Arrays.stream(ctx.getBeanDefinitionNames()).toList().forEach(System.out::println);
    }

    @Test
    void stringTypedBean() {
        String stringTypedBean = ctx.getBean("stringTypedBean", String.class);
        System.out.println(stringTypedBean);
    }

    @Test
    void integerTypedBean() {
        Integer integerTypedBean = ctx.getBean("integerTypedBean", Integer.class);
        System.out.println(integerTypedBean);
    }

    @Test
    void floatTypedBean() {
        Float floatTypedBean = ctx.getBean("floatTypedBean", Float.class);
        System.out.println(floatTypedBean);
    }

    @AfterAll
    void afterAll() {
        System.out.println("Close the current AnnotationConfigApplicationContext in afterAll() method.");
        ctx.close();
    }
}