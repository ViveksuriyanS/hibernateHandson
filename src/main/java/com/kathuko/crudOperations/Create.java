package com.kathuko.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Create {

	public static void main(String[] args) {
		MarvelCharacters m = new MarvelCharacters();
		m.setName("Thor");
		m.setPower("God of Thunder");

		Configuration con = new Configuration().configure("MarvelCharacters.cfg.xml")
				.addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();
		ses.save(m);

		for (int i = 0; i < 10; i++) {
			MarvelCharacters sideActors = new MarvelCharacters();
			sideActors.setName("Agent " + i);
			sideActors.setPower("Supporting Agent " + i);
			ses.save(sideActors);
		}
		trans.commit();
	}

}
