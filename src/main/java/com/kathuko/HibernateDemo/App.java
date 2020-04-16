package com.kathuko.HibernateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws ParseException {
		Shield character1 = new Shield();
		character1.setName("Thor");
		character1.setPower("Lord of Thunder");
		character1.setScore(90);
		character1.setAlive(true);
		Cast cast1 = new Cast();
		cast1.setName("Chris Hemsworth");
		cast1.setAge(36);
		cast1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1983-08-11"));
		cast1.setCountry("Australia");
		character1.setCastInfo(cast1);

		Shield character2 = new Shield();
		character2.setName("Thanos");
		character2.setPower("Superhuman Strength");
		character2.setScore(97);
		character2.setAlive(false);
		Cast cast2 = new Cast();
		cast2.setName("Josh Brolin");
		cast2.setAge(51);
		cast2.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1968-02-12"));
		cast2.setCountry("US");
		character2.setCastInfo(cast2);

		Shield character3 = new Shield();
		character3.setName("Captain America");
		character3.setPower("Superhuman with Shield");
		character3.setScore(96);
		character3.setAlive(true);
		Cast cast3 = new Cast();
		cast3.setName("Chris Evans");
		cast3.setAge(38);
		cast3.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1981-06-13"));
		cast3.setCountry("US");
		character3.setCastInfo(cast3);

		// 3. Finally it is a class
		// Since we are using default file name, no need to mention inside configure()
		// If we use other name, then configure("newFilename.cfg.xml")
		// .addAnnotatedClass(ClassName.class) defines which entity the configuration
		// refers to
		Configuration con = new Configuration().configure().addAnnotatedClass(Shield.class)
				.addAnnotatedClass(Cast.class);

		// We can use ServiceRegistry instead of buildSessionFactory()
		ServiceRegistry serReg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

		// 2. Again SessionFactory is an interface
		// buildSessionFactory() is deprecated
		// SessionFactory sf = con.buildSessionFactory();

		SessionFactory sf = con.buildSessionFactory(serReg);

		// 1. Session is interface we cannot create object of the class
		Session sess = sf.openSession(); // Returns object of session

		Transaction trans = sess.beginTransaction();

		// Save method stores the value into the database
		sess.save(character1);
		sess.save(cast1);
		sess.save(character2);
		sess.save(cast2);
		sess.save(character3);
		sess.save(cast3);

		// To fetch values from DB, we use get(.class, pk_val)
//		System.out.println(sess.get(Shield.class, 0));

		trans.commit();
	}

}

// Configuration -> It creates a configuration object by reading the configuration related details from .cfg.xml file 
// SessionFactory -> Provides Session object to connect database from the application with the provided configuration details
// Session -> It is used for interaction between the database and the application 
// Query -> Used to query the DB	
// Transaction -> Used to achieve data consistency, and roll back in case something goes wrong
// First-Level / Session Cache (Implicit)-> By default Session object provides this until the session object is live
// Second-Level Cache (Explicit) -> Used to store object across sessions by providing cache provider. EhCache is popular. 