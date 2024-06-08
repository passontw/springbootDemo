package passon.com.tw.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import passon.com.tw.springbootdemo.model.Book;
import passon.com.tw.springbootdemo.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookApp {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getAll(
    ) {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book post(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            @RequestParam int status) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.save(book);
    }

    @PutMapping("/books")
    public  Book put(
            @RequestParam long id,
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            @RequestParam int status
    ) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.deleteById(id);
    }
    @GetMapping("/books/by/author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/books/by/description")
    public List<Book> findByDescriptionEndsWith(@RequestParam String description) {
        return bookService.findByDescriptionEndsWith(description);
    }

    @GetMapping("/books/by/length")
    public List<Book> findByLength(@RequestParam int len) {
        return bookService.findByJPQL(len);
    }

    @PutMapping("/books/by/jpql")
    public int updateStatusByJPQL(@RequestParam int status, @RequestParam long id) {
        return bookService.updateByJPQL(status, id);
    }

    @GetMapping("/books/by")
    public List<Book> findByAuthor(@RequestParam(required = false) String author, @RequestParam(required = false) int status) {
        return bookService.findByAuthorAndStatus(author, status);
    }


}
