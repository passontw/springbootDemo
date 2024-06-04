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
    public List<Book> getAll() {
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
}
