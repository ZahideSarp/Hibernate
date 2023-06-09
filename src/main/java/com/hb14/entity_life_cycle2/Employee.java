package com.hb14.entity_life_cycle2;

import javax.persistence.*;

@Entity
@Table(name = "employee")
//zaten boyle olacakti neden table annotation kullandik --okunabilirligi artirmak icin bu ozelligi koyuyoruz.
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;

    //!!!Entity LifeCycle Metodlari

    /*
    @PrePersist
    bir Çalışan sınıfı oluşturulduğunda, onPrePersist() metodu otomatik olarak
    çağrılır ve "onPrePersist method called" çıktısı verilir. Bu, Hibernate
    tarafından sağlanan bir öğedir ve bir varlık kaydedilmeden önce yapılması
    gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
     */
    @PrePersist
    public void onPersist() {
        System.out.println("******************onPrePersist method called*************************");
    }



    /*
    @PostPersist
    Bir varlık veritabanına kaydedildiğinde, onPostPersist() metodu çağrılır
    ve "onPostPersist method called" çıktısı verilir. Bu, bir varlık kaydedildikten
    sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
     */
    @PostPersist
    public void onPostPersist() {
        System.out.println("*****************onPostPersist method called*********************");
    }



    /*
    @PostLoad
    Bir varlık veritabanından yüklendiğinde, onPostLoad() metodu çağrılır ve
    "onPostLoad method called" çıktısı verilir. Bu, bir varlık yüklendikten
    sonra yapılması gereken herhangi bir işlemi gerçekleştirmek için kullanılabilir.
     */
    @PostLoad
    public void onPostLoad() {
        System.out.println("*****************onPostLoad method called*********************");
    }



    /*
    @PreRemove anotasyonu, bir varlık silinmeden önce çalıştırılacak bir yöntemi
    belirtmek için kullanılır. Bu yöntem, bir varlık silinmeden önce yapılması
    gereken işlemleri gerçekleştirmek için kullanılabilir. Örneğin, bir varlığın
    silinmeden önce bağımlı varlıkları ile olan ilişkileri çözmek veya bir kaydı
    arşivlemek gibi işlemler yapılabilir.
     */
    @PreRemove
    public void onPreRemove(){
        System.out.println("*****************onPreRemove method called*********************");
    }



    /*
    @PostRemove yöntemi ise, bir Çalışan nesnesi silindikten sonra çağrılır ve
    "Employee record removed from the database" çıktısı verilir. Bu örnekte,
    loglama veya istatistik toplama gibi işlemler yapmak gerekiyorsa, @PostRemove
    yöntemi içine kodlar eklenebilir.
     */
    @PostRemove
    public void onPostRemove(){
        System.out.println("*****************onPostRemove method called*********************");
    }

    public Long getId() {
        return id;
    }

/*    public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
