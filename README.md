# play-with-springframework
A repository to record everything I have learned during my self-study journey with the Spring Framework.

## Takeaways of defining beans via @Component

### We can use @Component to annotate a class to make it as spring managed bean
```java
@Component
public class Book {
    private String title;
    private String isbn;

    public Book() {
        System.out.println("Empty constructor of Book is called");
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
```
