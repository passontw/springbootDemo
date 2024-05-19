package passon.com.tw.springbootdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @Column(name="id", length=50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "author", length = 50)
    private String description;
    @Column(name = "description", length = 256)
    private String author;
    @Column(name = "status", length = 1)
    private int status;

    public Book() {}
    public Book(int id, String name, String author, String description, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;

        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }


    public int getDescription() {
        return status;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                "name=" + name +
                "author=" + author +
                "status=" + status +
                "}";
    }
}
