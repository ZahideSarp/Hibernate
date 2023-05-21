package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
      /*  2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :
        OneToMany       --> LAZY
        ManyToMany      --> LAZY
        OneToOne        --> EAGER
        ManyToOne       --> EAGER*/

        Student09 student=session.get(Student09.class,1002);
//        System.out.println(student.getBookList());
//        session.get(Book09.class ,101);

        //Book09 book=session.get(Book09.class,101);
//        for(Book09 book: student.getBookList()){//studenttan geldigi icin LAZY calisiyor.
//            System.out.println(book);
//        }
        tx.commit();

        session.close();
//        for(Book09 book: student.getBookList()){//studenttan geldigi icin LAZY calisiyor.
//            System.out.println(book);//.LazyInitializationException verir.
//        }
        for(Book09 book: student.getBookList()){//EAGER yapisi calisatigi icin ilk sorguda datalar geldi.
           System.out.println(book);
      }

        sf.close();


    }
}
