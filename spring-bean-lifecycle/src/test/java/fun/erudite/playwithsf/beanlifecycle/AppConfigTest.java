package fun.erudite.playwithsf.beanlifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

class AppConfigTest {
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames()).toList().forEach(System.out::println);
        System.out.println("It's called before all the test methods are executed");
    }

    @Test
    void get_book_bean_via_type() {
        Book book = ctx.getBean(Book.class);
        book.setIsbn("000001");
        book.setTitle("Spring Start Here");
        System.out.println(book);
    }

    @Test
    void get_book_bean_via_beanName() {
        Book book = (Book)ctx.getBean("book");
        book.setIsbn("000002");
        book.setTitle("Domain Driven Design");
        System.out.println(book);
    }

    @Test
    //Preferred method to get bean
    void get_book_bean_via_beanName_beanType() {
        Book book = ctx.getBean("book",Book.class);
        book.setIsbn("000003");
        book.setTitle("Spring in Action");
        System.out.println(book);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("It's called after all test methods are executed");
        ctx.close();
    }
}