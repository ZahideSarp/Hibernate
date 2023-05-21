package com.hb06.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private  String name;

    private int grade;

@OneToMany
@JoinColumn
//biz burada iliski sahibini Student'a vermis olsak bile uygun olmadiginda hibernate kontrolu eline alir
// ve bookList sutunu'nu  Book'ta olusturur.iliski sahibi yine de student oluyor
    private List<Book06> bookList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

//    public void setBookList(List<Book06> bookList) {
//        this.bookList = bookList;
//    }-->normalde get() deriz sonra add deriz set etmeyiz listi

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
