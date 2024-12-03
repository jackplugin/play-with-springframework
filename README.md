## Takeaways of Bean Definition Via @Bean

### We can use @Bean to annotate a method to define beans for primitive types like String, Integer and Float etc.
```java
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
```
### We can use @Bean to annotate a method to define beans for custom complex types like Book, Author etc.
```java
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
```
### When there is a single bean of the same type (primitive type or custom complex type) in the current context, we can get bean via the type of bean.
```java
    @Test
    void get_integerTypedBean_via_beanType() {
        Integer integerTypedBean = ctx.getBean(Integer.class);
        System.out.println(integerTypedBean);
    }

    @Test
    void get_integerTypedBean_via_beanName_beanType() {
        Integer integerTypedBean = ctx.getBean("integerTypedBean",Integer.class);
        System.out.println(integerTypedBean);
    }

    @Test
    void get_floatTypedBean_via_beanType() {
        Float floatTypedBean = ctx.getBean(Float.class);
        System.out.println(floatTypedBean);
    }

    @Test
    void get_floatTypedBean_via_beanName_beanType() {
        Float floatTypedBean = ctx.getBean("floatTypedBean",Float.class);
        System.out.println(floatTypedBean);
    }
```
### When there are multiple beans of the same type, we can't get bean only through bean type, we have to specify bean name.
```java
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
```



