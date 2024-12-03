package fun.erudite.playwithsf.beanlifecycle;

import org.springframework.stereotype.Component;

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
