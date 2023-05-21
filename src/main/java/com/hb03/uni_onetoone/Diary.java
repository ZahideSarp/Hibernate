package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private int id;


    private String name;

    @OneToOne
    @JoinColumn(name="std_id")
    private Student03 student03;
    //olusacak kolon normalde student_id olur ama "@JoinColumn(name="std_id")" bu sekilde yazinca degistirmis oluyorum.


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

    public Student03 getStudent03() {
        return student03;
    }

    public void setStudent03(Student03 student03) {
        this.student03 = student03;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student03=" + student03 +
                '}';
    }
}
