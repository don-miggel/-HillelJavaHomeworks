package hw30.db.conn.conn;

import hw30.entity.model.entity.Student;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateSession {

    private static Configuration configuration;

    static {
        configuration = new Configuration();
    }


    public static SessionFactory getSessionFactory() {
        configuration = getConfigSettings();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        try (var entityManagerFactory
                     = Persistence.createEntityManagerFactory("studentapp");
          ) {
            return configuration.buildSessionFactory();

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    private static Properties createDbConn(){
        var properties= new Properties();
        properties.put("hibernate.connection.driver_class", System.getenv("DB_DRIVER"));
        properties.put("hibernate.connection.url", System.getenv("DB_CONN_URL"));
        properties.put("hibernate.connection.username", System.getenv("DB_USERNAME"));
        properties.put("hibernate.connection.password", System.getenv("DB_PASSWORD"));
        return properties;
    }

    private static Configuration getConfigSettings(){

        configuration.setProperties(createDbConn());
        configuration.configure("hibernate-annotation.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        return configuration;
    }
}
