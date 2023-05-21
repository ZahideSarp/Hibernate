package com.hb12.caching;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
        /*
        1)  First Level Cache --->
        * defaultta açık geliyor , kapatma durumu yok
        * Aynı session içinde kayıt alır
        * session kapanınca içindejkiler silinir.

        2) Second Level Cache --->
        * Defaultta kapalıdır
        * Session factory seviyesinde cachleme yapar, yani farklı
        sessionlar arasında data kullanılabiliyor
        * hibernate.cfg.xml den active edilebilir

(daha fazla yer ayiriyor bu yuzde performans bi tik daha dusuktur bu yuzden defaultta kapalidir.)
(yeri dolunca da en cok kullandigimiz cacheleri ilk kullandigimiz cachelerin uzerine yaza yaza maplama yapiyor.)

        3) Query Cache
        * Query ler için kullanılıyor
        * hibernate.cfg.xml den active edilebilir
        */


@Entity
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE,region = "Student12")
public class Student12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int mathGrade;


    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
