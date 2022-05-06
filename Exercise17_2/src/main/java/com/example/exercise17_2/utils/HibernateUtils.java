//package com.example.exercise17_2.utils;
//
//import com.example.exercise17_2.Course;
//import com.example.exercise17_2.Student;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Properties;
//
//public class HibernateUtils {
//    private static SessionFactory sessionFactory;
//
//    private static Configuration configuration = new Configuration();
//
//    private static List<Class> entities= Arrays.asList(Course.class, Student.class);
//
//    static {
//        try {
//            Properties settings = new Properties();
//            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Practice");
//            settings.put(Environment.USER, "root");
//            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//
//            settings.put(Environment.SHOW_SQL, "true");
//
//            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//            settings.put(Environment.HBM2DDL_AUTO, "update");
//
//            configuration.setProperties(settings);
//
//            entities.forEach(entityClass -> configuration.addAnnotatedClass(entityClass));
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//}
//
