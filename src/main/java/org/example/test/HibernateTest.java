package org.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Error al conectar con la base de datos.");
        } finally {
            // Cerrar la sesión
            if (session != null) {
                session.close();
            }
        }
        sessionFactory.close();
    }
}
