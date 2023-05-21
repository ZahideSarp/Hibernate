package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class runnerSave01 {
    public static void main(String[] args) {


        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Akın Toprak");
        student01.setGrade(90);

        Student01 student2=new Student01();
        student2.setId(1002);
        student2.setName("Cemil");
        student2.setGrade(90);


        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Fatih Deniz");
        student3.setGrade(90);


        //hibernate'e configurasyon dosyami ve entity class'ini bildirdim
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //birden cok entity class varsa addAnnotatedClass()'a butun class'lari eklemeliyiz.


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();

    }
}
