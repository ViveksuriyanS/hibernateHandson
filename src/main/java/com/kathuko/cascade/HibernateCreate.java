package com.kathuko.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserCascade user1 = new UserCascade();
		user1.setUserId(1);
		user1.setUserName("Vivek");

		Vehicle v1 = new Vehicle();
		v1.setVehicleId(3315);
		v1.setVehicleName("Pulsar");

		Vehicle v2 = new Vehicle();
		v2.setVehicleId(4791);
		v2.setVehicleName("Activa");

		user1.getVehicles().add(v1);
		user1.getVehicles().add(v2);

		// Added UserOnetoOne and Vehicle class in addAnnotatedClass()
		Configuration con = new Configuration().configure("Cascade.cfg.xml").addAnnotatedClass(UserCascade.class)
				.addAnnotatedClass(Vehicle.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.persist(user1); 
		// In cascading we are not saving V1 and V2 vehicles
		// Instead of calling save() we are using persist()
		//		ses.save(v1); 
		//		ses.save(v2);
		trans.commit();
		ses.close();
	}

}
