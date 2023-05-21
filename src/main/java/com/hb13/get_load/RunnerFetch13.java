package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
 /*   get() ---> gerçek nesneyi döndürür ,
    nesne yoksa "null" döner
    nesnenin olduğundan emin değilseniz get() kullanın
    dönen nesneyi hemen kullanacaksam get() kullanılmalı
    load() --> proxy(golge) nesne döndürür, gerçek nesnenin gölgesi ,
    nesne yoksa "exception" fırlatır.yeni query olusturmaz.
    dönen nesne üzerinde delete yapılacaksa kullanılabilir*/

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("************** get() methodunun basladigi yer *************");
      Student13 student1=  session.get(Student13.class,1L);

        System.out.println("*********get() methodunu  bittigi yer ************");
        System.out.println("Studen id "+ student1.getId());
        System.out.println("Student name " +student1.getName());
//get methodu-->eager gibi calisir , load methodu ise -->Lazy gibi calisir
        System.out.println("================================================");
        //load yaptigimda farkli id de cagirsak 2. queryi atmiyor get ile load methodunun farki budur
        //procsi obje getiriyor objenin kendi gelmiyor golgesi geliyor.

        System.out.println("************* load methodunun basladigi yer *************");
       Student13 student2= session.load(Student13.class,2L);
       //Student13 student2= session.load(Student13.class,200L);
       //olmayan id yi istedigimiz de exception atmaz ama o id ile ilgili islem yaparsam exception atar.
        //procsy obje bir nevi dummy obje ici bos name 'i isteyince mecburen DB'ye gider.

        System.out.println("***********Load methodunun bittigi yer*********");

        System.out.println("************** --->  get idId() cagirildi");
        System.out.println("Student id "+ student2.getId());
        System.out.println("************** --->  get idName() cagirildi");
        System.out.println("Student name"+ student2.getName());
//        procsy obje bir nevi dummy obje ici bos name 'i isteyince mecburen DB'ye gider.

//        !!!DB de olmayan id ler ile get ve load methodlari karsilastiralim.

        Student13 student3=session.get(Student13.class,5L);
        if(student3!=null){
            System.out.println("Student id"+ student3.getId());
            System.out.println("Student name"+ student3.getName());
        }


        System.out.println("*************************************************");
       Student13 student4= session.load(Student13.class,100L);//ObjectNotFoundException verdi
        if(student4 != null){
            //boyle bir obje var ama dummy objeprocsy obje yani ici bos null da yok bu yuzden exception firlatiyor.
            System.out.println("Student id"+ student4.getId());
            System.out.println("Student name"+ student4.getName());
        }

        //peki load methodunu neden kullanalim ?
       Student13 student5= session.get(Student13.class,1L);
        session.delete(student5);

//get ile yapinca ilk sorguyu selectte yapiyor ikinci query'i delete de atiyor ama load da 2 query'i de delete komutunda atiyor.
     Student13 student6=session.load(Student13.class,2L);
session.delete(student6);
        tx.commit();
        session.close();
        sf.close();





    }
}
