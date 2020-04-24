import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<PurchaseList> list = session.createQuery("FROM PurchaseList", PurchaseList.class)
                .getResultList();

        List<Student> studentList = session.createQuery("FROM Student", Student.class)
                .getResultList();

        List<Course> courseList = session.createQuery("FROM Course", Course.class)
                .getResultList();

        for (PurchaseList pl : list) {
            for (Student st : studentList) {
                for (Course course : courseList) {
                    if (pl.getStudentName().equals(st.getName()) && pl.getCourseName().equals(course.getName())) {
                        session.save(new LinkedPurchaseList(st.getId(), st.getName(), course.getId(), course.getName(), pl.getPrice(), pl.getSubscriptionDate()));
                    }
                }
            }
        }


        transaction.commit();
        sessionFactory.close();
    }
}


