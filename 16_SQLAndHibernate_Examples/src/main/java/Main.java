import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        String hqlSelectId = "FROM " + Purchase.class.getSimpleName();
        List<Purchase> purchaseList = session.createQuery(hqlSelectId).getResultList();
        ArrayList<Integer> idConnect = new ArrayList<>();

        for (Purchase p : purchaseList) {
            Query criteria = session.createQuery("FROM " + Student.class.getSimpleName() + " WHERE name = :nameStudent ");
            List<Student> student = criteria.setParameter("nameStudent", p.getNameCourseKey().getStudentName()).list();
            idConnect.add(student.get(0).getId());

            criteria = session.createQuery("FROM " + Course.class.getSimpleName() + " WHERE name = :nameCourse ");
            List<Course> course = criteria.setParameter("nameCourse", p.getNameCourseKey().getCourseName()).list();
            idConnect.add(course.get(0).getId());

            int studentIdInfo = 0;
            int courseIdInfo = 1;
            if (idConnect.size() == 2) {
                Transaction transaction = session.beginTransaction();
                LinkedPurchase linkedPurchase = new LinkedPurchase();
                linkedPurchase.setLinkedPurchaseId(idConnect.get(studentIdInfo), idConnect.get(courseIdInfo));
                session.saveOrUpdate(linkedPurchase);
                session.flush();
                transaction.commit();
                idConnect.clear();
            }
        }
        sessionFactory.close();
        registry.close();

    }
}
