package passon.com.tw.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndStatus(String author, int status);
    List<Book> findByDescriptionEndWith(String description);
}
