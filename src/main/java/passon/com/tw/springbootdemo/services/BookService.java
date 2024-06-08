
package passon.com.tw.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import passon.com.tw.springbootdemo.model.Book;
import passon.com.tw.springbootdemo.model.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 查詢所有的書單列表
     * @return
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public List<Book> findByDescriptionEndsWith(String description) {
        return bookRepository.findByDescriptionEndsWith(description);
    }

    public List<Book> findByJPQL(int len) {
        System.out.println("len: " + len );
        return bookRepository.findByJPQL(len);
    }

    public int updateByJPQL(int status, long id){
        return bookRepository.updateByJPQL(status, id);
    }
}
