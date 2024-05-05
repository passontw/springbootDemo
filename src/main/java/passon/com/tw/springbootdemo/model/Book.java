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
    private String author;
    @Column(name = "status", length = 1)
    private int status;

    public Book() {}
    public Book(int id, String name, String author, int status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public int getid() {
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name){
        this.name = name;
    }
    public String getauthor() {
        return author;
    }

    public void setauthor(String author){
        this.author = author;
    }
    public int getstatus() {
        return status;
    }

    public void setstatus(int status){
        this.status = status;
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
