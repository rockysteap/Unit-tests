package homework_tasks.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepository);

    }

    @Test
    void testBookServiceFindBookById() {
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));
        when(bookRepository.findById("2")).thenReturn(new Book("2", "Book2", "Author2"));

        Book book1 = bookService.findBookById("1");
        Book book2 = bookService.findBookById("2");

        List<String> book1ref = List.of(new String[]{"1", "Book1", "Author1"});
        List<String> book2ref = List.of(new String[]{"2", "Book2", "Author2"});
        List<String> book1act = List.of(new String[]{book1.getId(), book1.getTitle(), book1.getAuthor()});
        List<String> book2act = List.of(new String[]{book2.getId(), book2.getTitle(), book2.getAuthor()});

        for (int i = 0, len = book1ref.toArray().length; i < len; i++) {
            assertEquals(book1ref.get(i), book1act.get(i));
        }
        for (int i = 0, len = book2ref.toArray().length; i < len; i++) {
            assertEquals(book2ref.get(i), book2act.get(i));
        }
    }

    @Test
    void testBookServiceFindAllBooks() {
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");

        List<Book> books = List.of(new Book[]{book1, book2});

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findAllBooks().size());
        assertEquals("Author2", bookService.findAllBooks().get(1).getAuthor());

    }
}
