package fun.erudite.playwithsf.beanlifecycle;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.util.Arrays;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ComplexTypeBeanConfigTest {
    private AnnotationConfigApplicationContext ctx;

    @BeforeAll
    void beforeAll() {
        System.out.println("Start AnnotationConfigApplicationContext in beforeAll() method.");
        ctx = new AnnotationConfigApplicationContext(ComplexTypeBeanConfig.class);
        System.out.println("All the beans defined in ComplexTypeBeanConfig.class are loaded.");
        System.out.println(MessageFormat.format("Find {0} Bean Definition from the current context", ctx.getBeanDefinitionCount()));
        Arrays.stream(ctx.getBeanDefinitionNames()).toList().forEach(System.out::println);
    }


    @Test
    void get_bean_without_beanName_throws_exception() {
        System.out.println("When there are more than one bean of the same type, getting a bean without specifying the bean name will get exception.");
        NoUniqueBeanDefinitionException exception = assertThrows(NoUniqueBeanDefinitionException.class, () -> ctx.getBean(Book.class));
        assertNotNull(exception.getMessage());
    }

    @Test
    void get_bean_book1_via_beanName_beanType() {
        Book book1 = ctx.getBean("book1", Book.class);
        System.out.println(book1.toString());
    }

    @Test
    void get_bean_book2_via_beanName_beanType() {
        Book book2 = ctx.getBean("book2", Book.class);
        System.out.println(book2.toString());
    }

    @Test
    void get_bean_bookReader_via_beanType() {
        BookReader bookReader = ctx.getBean(BookReader.class);
        System.out.println(bookReader.toString());
    }

    @AfterAll
    void afterAll() {
        System.out.println("Close AnnotationConfigApplicationContext in afterAll() method.");
        ctx.close();
    }
}