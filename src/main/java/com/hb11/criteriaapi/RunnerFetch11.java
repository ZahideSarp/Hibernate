package com.hb11.criteriaapi;

import com.hb11.criteriaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {
        /*
        CRUD (Create,Read,Update,Delete)
        C-->session.save
        R-->session.get ,HQL,SQL
        U-->session.update, updateQuery
        D-->session.delete,HQL,SQL
        */
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //!!! UPDATE islemi
        Student11 student = session.get(Student11.class, 1L);
//        student.setName("guncellenmis " + student.getName());
//        session.update(student);
//
//        //!!!Degisken tanimlama
//        //MathGrade puani 30 (dahil) dan kucuk olan ogrencilerin puanlarini 80 yapalim
//        int sMathGrade = 80;
//        int lMathGrade = 30;
//
//        String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath  WHERE s.mathGrade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//        query.setParameter("sMath", sMathGrade);
//        query.setParameter("lMath", lMathGrade);
//        int numberOfRecords = query.executeUpdate();
//        System.out.println("Degistilen kayit sayisi: "+ numberOfRecords);


        //!!! CriteriaAPI**********************************************************
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);
        //root neyi sakliyor?kullanacagim entity classi sakliyor.hibernate'e entity classimda criteria ile
        // calisacagimi bildirmis oluyorum.root==Student11 oluyor.


//        //!!! 1.Örnek: butun Student11 objelerini ekrana basalim:
//        criteriaQuery.select(root); //bu cod bana "select *from Student11" yapisini sagliyor
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(System.out::println);
//
//
//        //!!! 2.Örnek : Student ismi " Student Name 6" olan öğrenci bilgilerini getirelim
//        criteriaQuery.select(root).where(cb.equal(root.get("name"), "Student name 6"));
//        Query<Student11> query2 = session.createQuery(criteriaQuery);
//        List<Student11> resultList2 = query2.getResultList();
//        resultList2.forEach(System.out::println);
//
//
////!!!  3.Örnek, mathGrade değeri 80 den büyük olan dataları getirelim
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"), 80));
//        Query<Student11> query3 = session.createQuery(criteriaQuery);
//        List<Student11> resultList3 = query3.getResultList();
//        resultList3.forEach(System.out::println);
//
//
//        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"), 95));
//        Query<Student11> query4 = session.createQuery(criteriaQuery);
//        List<Student11> resultList4 = query4.getResultList();
//        resultList4.forEach(System.out::println);

        // !!! 5. örnek : id si 1 veya mathGrade i 75 den büyük olan recordu bulalım
        Long id = 1L;
        //predicate de sinirsiz sart gelebilmesi saglaniyor
        Predicate predicateForName = cb.equal(root.get("id"), id);
        Predicate predicateForMathGrade = cb.greaterThan(root.get("mathGrade"), 75);

        Predicate predicateStd = cb.or(predicateForName, predicateForMathGrade);
        //select yapmadik ama predicate onu yapiyor
        criteriaQuery.where(predicateStd);

        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList5 = query5.getResultList();
        resultList5.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();
    }
}
