package com.hb02.embeddable;
import javax.persistence.*;

/*
        Hibernate ile, bir sınıfı embeddable bir sınıf  olacak şekilde işaretlemek için @Embeddable annotationu kullanabiliriz.
         Embeddable bir sınıfı gömmek için @Embedded annotationunı kullanabiliriz.
         Embeddable bir sınıfın referansı entity sınıfın içinde kullanıldığı zaman embeddable olarak işaretlenen sınıfın
          değişkenleri entity sınıfın karşılık geldiği tablo içinde bir kolon tanımlanacaktır.
          Embedded objelerin primary key  yoktur dolayısıyla @Id anotasyonu kullanılmaz.


          Embeddable ile işaretlenen sınıf için veritabanında herhangi bir tablo oluşmayacaktır.
          Sınıfın nitelikleri, @AttributeOverrides ve @AttributeOverride ek açıklamaları (annotation )
           kullanılarak geçersiz kılınabilir.
*/
@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id
    private int id ;

    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;

    private int grade;

    @Embedded // Opsiyonel

    private Address address;

        // !!! Getter-Setter


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

        // !!! toString()

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}