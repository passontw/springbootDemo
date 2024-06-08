package passon.com.tw.springbootdemo.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndStatus(String author, int status);
    List<Book> findByDescriptionEndsWith(String description);

    @Query("select b from Book b where length(b.name) > ?1")
    List<Book> findByJPQL(int len);

    /**
     *
     * @param status
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update Book b set b.status = ?1 where id = ?2")
    int updateByJPQL(int status, long id);
}
