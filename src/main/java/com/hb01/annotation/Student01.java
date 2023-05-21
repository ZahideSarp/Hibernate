package com.hb01.annotation;

import javax.persistence.*;

@Entity
//@Entity ile bu sinifin db'de bir tabloya karsilik gelmesini sagliyoruz,eger dokunmazsam default olarak "student01"(bas harf kucuk)
// olarak tablo olusturuyor eger dersem @Table(name="t_student01") dersem bu isimle olsturur.
@Table(name = "t_student01")
public class Student01 {
    //java kodu icinde bu classa ulasirken Student01 ile SQL ile ulasirken t_student01 ile yazmam lazim
    @Id//anatotian dan sonra gelen ilk field primary-keydir.@Entity'i id ollarak yaziyorsam @id yi kullanmak zorundayim
    //@Column(name="std_id")
    private int id;//primary-key olusmasini sagliyoruz.==unique'dir

    @Column(name = "student_name", length = 100, nullable = false, unique = false)//hazirlanan tablolarin ismini degistirmek icin kullanilir
    private String name;

    //@Transient//!!! DB deki tabloda "grade" adinda bir kolan olusmasini engeller.
    private int grade;
//    @Lob//>>> large object ile buyuk boyutlu datalar  tutulabiliyor.
    //   private byte[] image;//image gibi jpeg mp3 gibi seyler db ye gittigi zaman jpeg, jpeg olarak gitmez zafiyet olur ve agi yavaslatir.
    //bu tarz image'leri parca parca tutariz ama bunlar yer olarakta baktigimiz da diger field'lara gore Large yer kaplar.
    //@Lob yazarak db'e bu Large bi data yeri genis tut demis oluyorum.
/*
@GeneratedValue Tablolarda bulunan otomatik artan veya belirli kurallara göre veritabanı
tarafından otomatik olarak verilen değerlere karşılık gelen dipnottur.Otomatik artan bir id değerimiz varsa bunu id
değişkeninden önce bu dipnot ile belirtiriz.Kullanımı ise oldukça kolaydır,farklı parametreler alabilmektedir.



 */

    //!!! getter-setter


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


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
/*
package com.hb01.annotation;
​
import javax.persistence.*;
​
@Entity //!!! @Entity ile bu sinifin DB de bir tabbloya karsilik gelmesini sagliyoruz, student01
@Table(name="t_student01") //!!! DB de tablo isminin "t_student01" olarak degismesini sagladim
// java kodu icinde bu classa ulasirken Student01 ile, SQL ile ulasirken t_student01 ile yazmam lazim
public class Student01 { //student01
​
    @Id // !!! primary-key olusmasini sagliyoruz
    //@Column(name="std_id")
    private int id;
​
    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;
​
    //@Transient // !!! DB deki tabloda "grade" adinda bir kolon olusmasini engeller
    private int grade;
​
//    @Lob  // !!! large object ile buyuk boyutlu datalar tutulabiliyor
//    private byte[] image;
​
    // !!! GETTER - SETTER
​
    public int getId() {
        return id;
    }
​
    public void setId(int id) {
        this.id = id;
    }
​
    public String getName() {
        return name;
    }
​
    public void setName(String name) {
        this.name = name;
    }
​
    public int getGrade() {
        return grade;
    }
​
    public void setGrade(int grade) {
        this.grade = grade;
    }
​
    // !!! toString()
​
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
 */