package com.kathuko.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Update {

	public static void main(String[] args) {
		MarvelCharacters m = new MarvelCharacters();

		// Change HBM2DDL to UPDATE
		Configuration con = new Configuration().configure("MarvelCharacters.cfg.xml")
				.addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// Only if the value is changed then the update query will be triggered

		m = ses.get(MarvelCharacters.class, 2);
		m.setName("Captain America");
		m.setPower("Shield");
		ses.update(m);

		m = ses.get(MarvelCharacters.class, 3);
		m.setName("Ironman");
		m.setPower("AI Suit");
		ses.update(m);

		m = ses.get(MarvelCharacters.class, 4);
		m.setName("Hulk");
		m.setPower("Super Human");
		ses.update(m);
		trans.commit();
	}

}
