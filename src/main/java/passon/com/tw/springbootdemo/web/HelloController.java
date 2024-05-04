package passon.com.tw.springbootdemo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value="/say")
    public String hello() {
        return "Hello Spring boot";
    }

    @GetMapping("/books")
    @ResponseBody
    public  Object getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Map<String, Object> book1 = new HashMap<>();
        book1.put("name", "hello world1");
        book1.put("isbn", "12345679");
        book1.put("author", "test001");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "hello world2");
        book2.put("isbn", "12345678");
        book2.put("author", "test002");
        List<Map> contents = new ArrayList<>();
        contents.add(book1);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("books", contents);
        return pagemap;
    }

    /**
     * 正規表達式: {參數名: 正規表達式}
     * @param id
     * @param username
     * @return
     * */
    @GetMapping("/{id}/books/{username:[a-z_]+}")
    public Object getOne(@PathVariable long id, @PathVariable String username) {
        Map<String, Object> book = new HashMap<>();
        book.put("id", id);
        book.put("name", "好書");
        book.put("isbn", "897456465465");
        book.put("author", username);
        return book;
    }

    @PostMapping(path="/books", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Object post(@RequestPart String name, @RequestPart String author, @RequestPart String isbn) {
        Map<String, Object> book = new HashMap<String, Object>();
        book.put("isbn", isbn);
        book.put("name", name);
        book.put("author", author);
        return book;
    }
}
