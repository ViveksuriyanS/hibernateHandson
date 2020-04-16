package com.kathuko.NotFoundAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserNotFound user1 = new UserNotFound();
		user1.setUserName("Vivek");

		Vehicle v1 = new Vehicle();
		v1.setVehicleId(3315);
		v1.setVehicleName("Pulsar");
		v1.setUser(user1);

		Vehicle v2 = new Vehicle();
		v2.setVehicleId(4791);
		v2.setVehicleName("Activa");

		user1.getVehicles().add(v1);

		// Added UserOnetoOne and Vehicle class in addAnnotatedClass()
		Configuration con = new Configuration().configure("NotFoundAnnotation.cfg.xml")
				.addAnnotatedClass(UserNotFound.class).addAnnotatedClass(Vehicle.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1); // Have to save both object separately
		ses.save(v1); // As both the values are stored in different table
		ses.save(v2);
		trans.commit();
		ses.close();
	}

}
