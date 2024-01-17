package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookRepository mockBookRepository;
    List<Book> books;
    Book book1;
    Book book2;
    BookService bookService;
    String id1;
    String id2;

    @BeforeEach
    void setUp() {
        id1="1";
        id2="2";
        mockBookRepository=mock(BookRepository.class);
        book1=new Book(id1,"Война и мир","Толстой");
        book2=new Book(id2,"Мастер и Маргарита","Булгаков");
        books=List.of(book1,book2);
        bookService=new BookService(mockBookRepository);
        when(mockBookRepository.findById(id1)).thenReturn(book1);
        when(mockBookRepository.findAll()).thenReturn(books);

    }
//Проверка что единожды вызываем поиск по id;
    @Test
    void findBookByIdTestInvoceOnce(){
        bookService.findBookById(id1);
        verify(mockBookRepository,times(1)).findById(id1);
    }
//Проверка на возвращаемое значение
    @Test
    void findBookByIdTestMainReturn() {
        Book testBoook1=bookService.findBookById(id1);
        assertEquals(testBoook1,book1);
    }
    //Проверка что единожды вызываем
    @Test
    void findAllBooksTestInvoceOnce(){
        bookService.findAllBooks();
        verify(mockBookRepository,times(1)).findAll();
    }
//Проверка на возвращаемое значение
    @Test
    void findAllBooksTestMainReturn(){
        List<Book> testBooks=bookService.findAllBooks();
        assertEquals(testBooks,books);
    }




}