package com.hb02.embeddable;

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

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String country;
    private String zipCode;


    //getter-setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
