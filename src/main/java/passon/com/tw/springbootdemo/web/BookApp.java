package passon.com.tw.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import passon.com.tw.springbootdemo.model.Book;
import passon.com.tw.springbootdemo.services.BookService;

import java.util.List;

class CreateBookRequest {
    private String name;
    private String author;
    private String description;
    private int status;

}
@RestController
@RequestMapping("/api/v1")
public class BookApp {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(
    ) {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<CreateBookRequest> post(@RequestBody CreateBookRequest book) {
//        bookService.save(book);
        return new ResponseEntity<CreateBookRequest>(book, HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public  ResponseEntity<Book> put(
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

        bookService.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable long id) {
        bookService.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping("/books/by/author")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam String author) {
        List<Book> books = bookService.findByAuthor(author);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/by/description")
    public ResponseEntity<List<Book>> findByDescriptionEndsWith(@RequestParam String description) {
        List<Book> books = bookService.findByDescriptionEndsWith(description);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/books/by/length")
    public ResponseEntity<List<Book>> findByLength(@RequestParam int len) {
        List<Book> books = bookService.findByJPQL(len);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @PutMapping("/books/by/jpql")
    public ResponseEntity<?> updateStatusByJPQL(@RequestParam int status, @RequestParam long id) {
        int result = bookService.updateByJPQL(status, id);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @DeleteMapping("/books/by/jpql")
    public int deleteStatusByJPQL(@RequestParam long id) {
        return bookService.deleteByJPQL(id);
    }

    @GetMapping("/books/by")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam(required = false) String author, @RequestParam(required = false) int status) {
        List<Book> books = bookService.findByAuthorAndStatus(author, status);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @PostMapping("/books/delete/and/update")
    public int deleteAndUpdate(@RequestParam long id, @RequestParam int status, @RequestParam long uid) {
        return bookService.deleteAndUpdate(id, status, uid);
    }
}
