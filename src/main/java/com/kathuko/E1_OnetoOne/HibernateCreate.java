package com.kathuko.E1_OnetoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserOnetoOne user1 = new UserOnetoOne();
		user1.setUserName("Vivek");

		VehicleX v1 = new VehicleX();
		v1.setVehicleName("Pulsar");
		user1.setVehicle(v1);
		// Added UserOnetoOne and Vehicle class in addAnnotatedClass()
		Configuration con = new Configuration().configure("E1_OnetoOne.cfg.xml").addAnnotatedClass(VehicleX.class)
				.addAnnotatedClass(UserOnetoOne.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1); // Have to save both object separately
		ses.save(v1); // As both the values are stored in different table

		trans.commit();
		ses.close();
	}

}
