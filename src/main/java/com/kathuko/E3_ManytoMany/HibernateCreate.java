package com.kathuko.E3_ManytoMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {
		UserManytoMany user1 = new UserManytoMany();
		user1.setUserName("Vivek");

		UserManytoMany user2 = new UserManytoMany();
		user2.setUserName("Kumar");

		Vehicle v1 = new Vehicle();
		v1.setVehicleId(3315);
		v1.setVehicleName("Pulsar");
		// Vehicle1 is used by User1 and User2
		v1.getUser().add(user1);
		v1.getUser().add(user2);

		Vehicle v2 = new Vehicle();
		v2.setVehicleId(4791);
		v2.setVehicleName("Activa");
		// Vehicle2 is used by User1 and User2
		v2.getUser().add(user1);
		v2.getUser().add(user2);

		// User1 use vehicle1 and vehicle2
		user1.getVehicles().add(v1);
		user1.getVehicles().add(v2);
		// User2 use vehicle1 and vehicle2
		user2.getVehicles().add(v1);
		user2.getVehicles().add(v2);

		// Added UserOnetoOne and Vehicle class in addAnnotatedClass()
		Configuration con = new Configuration().configure("E3_ManytoMany.cfg.xml")
				.addAnnotatedClass(UserManytoMany.class).addAnnotatedClass(Vehicle.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(user1);
		ses.save(user2); // Have to save both object separately
		ses.save(v1); // As both the values are stored in different table
		ses.save(v2);
		trans.commit();
		ses.close();
	}

}
