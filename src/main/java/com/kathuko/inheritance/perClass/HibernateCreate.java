package com.kathuko.inheritance.perClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateCreate {

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle();
		v1.setVehicleId(3315);
		v1.setVehicleName("Pulsar");

		TwoWheeler v2 = new TwoWheeler();
		v2.setVehicleId(4791);
		v2.setVehicleName("Activa");
		v2.setSteetingGear("Activa Steering handle");

		FourWheeler v3 = new FourWheeler();
		v3.setVehicleId(8055);
		v3.setVehicleName("Honda City");
		v3.setSteeringWheel("Honda city steering wheel");

		// Added TwoWheeler, FourWheeler and Vehicle class in addAnnotatedClass()
		Configuration con = new Configuration().configure("Inheritance_perClass.cfg.xml")
				.addAnnotatedClass(TwoWheeler.class).addAnnotatedClass(FourWheeler.class)
				.addAnnotatedClass(Vehicle.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		ses.save(v1);
		ses.save(v2);
		ses.save(v3);

		trans.commit();
		ses.close();
	}

}
