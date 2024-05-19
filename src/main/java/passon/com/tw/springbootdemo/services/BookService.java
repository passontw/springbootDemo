
package passon.com.tw.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import passon.com.tw.springbootdemo.model.Book;
import passon.com.tw.springbootdemo.model.BookRepository;

import java.util.List;

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
}
