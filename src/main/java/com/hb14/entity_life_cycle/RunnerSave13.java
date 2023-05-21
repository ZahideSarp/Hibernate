package com.hb14.entity_life_cycle;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {
        Student14 student1=new Student14();//!!!transient state
        student1.setName("Kasim");
        student1.setMathGrade(55);

        Student14 student2=new Student14();
        student1.setName("Gulsen");
        student1.setMathGrade(65);


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student14.class);

       SessionFactory sf= con.buildSessionFactory();
       Session session= sf.openSession();
       Transaction tx= session.beginTransaction();

       session.save(student1);//!!!persistence state
       student1.setName("hakki");

       session.evict(student1);//detached state
        // Bir obje new'lendiği zaman Hibernate o objeyi hemen takip etmez, DB ile bağlantısının kurulmasını bekler.
// save gibi methodlar ile DB ile direkt fiziksel bağlantıya geçtiği an Hibernate bu objeyi takip etmeye başlar

       student1.setName("hakki");//bu asamada obje lifa-cycle olarak hala detach asamasinda oldugu icin isim degismez
        session.update(student1);//persistence scope
        session.merge(student1);//persistence scope

       tx.commit();
       session.close();
       sf.close();

    }

}
