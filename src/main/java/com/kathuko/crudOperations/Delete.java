package com.kathuko.crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Delete {

	public static void main(String[] args) {
		MarvelCharacters m = new MarvelCharacters();

		// Change HBM2DDL to UPDATE
		Configuration con = new Configuration().configure("MarvelCharacters.cfg.xml")
				.addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();
//		ses.save(m);

		for (int i = 12; i < 14; i++) {
			m = ses.get(MarvelCharacters.class, i);
			ses.remove(m);
		}
		trans.commit();
	}

}
