package com.zaurtregulov.spring.chapter03_hibernate05_many_to_many;

import com.zaurtregulov.spring.chapter03_hibernate05_many_to_many.entity.Child;
import com.zaurtregulov.spring.chapter03_hibernate05_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session=null;
        try {
            // создаём 1 секцию и трёх детей и добавляем детей в секцию
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Ola", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavlik", 9);
//
//            section1.addChildToSection(child1).addChildToSection(child2).addChildToSection(child3);
//            session.beginTransaction();
//
////          if you use CascadeType.ALL, it's OK, but if you remove section, so hibernate removes all the children
////          who comes to this section
////            session.save(section1);
//
////          In order to avoid automatic removing of children while deleting of section don't use CascadeType.ALL
////          if you don't use CascadeType.ALL, but only these:
////          {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH}
////          you must save section in this way
//            session.persist(section1);
//
//
//            session.getTransaction().commit();  // здесь транзакция закрывается
//            System.out.println("Done!");
            //***********************************

            // создаём три секции и одного ребёнка и добавляем секции к ребёнку
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//
//            child1.addSectionToChild(section1).addSectionToChild(section2).addSectionToChild(section3);
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();  // здесь транзакция закрывается
//            System.out.println("Done!");
            //***********************************

            // получаем первую секцию и всех детей в неё входящих
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();  // здесь транзакция закрывается
//            System.out.println("Done!");
            //***********************************

            // получаем ребёнка и все секции, в которые он ходит
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Child child = session.get(Child.class, 4);
//
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();  // здесь транзакция закрывается
//            System.out.println("Done!");
            //***********************************

            // удаляем секцию (если есть каскадное удаление, то удалена будет секция И дети)
            // если не используем, то будут удалены только секция и связи секция-дети
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Section section = session.get(Section.class, 7);
//
//            session.delete(section);
//
//            session.getTransaction().commit();  // здесь транзакция закрывается
//            System.out.println("Done!");
            //***********************************
            // удалим ребёнка
            // при этом удаляется сама запись ребёнка и связь дети-секции. Сама секция, в которую ходил ребёнок (футбол)
            // осталась, т.к. в неё записаны другие дети
            session = factory.getCurrentSession();
            session.beginTransaction();
            Child child = session.get(Child.class, 5);

            session.delete(child);

            session.getTransaction().commit();  // здесь транзакция закрывается
            System.out.println("Done!");
        }
        finally {
            if (session!=null) {
                session.close();
            }
            factory.close();
        }
    }
}
