package com.kathuko.hqlPagination;

import java.util.List;

import javax.persistence.Query;

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

		Configuration con = new Configuration().configure("HQLIntro.cfg.xml").addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// Select * from MarvelCharacters
		Query query = ses.createQuery("from MarvelCharacters");
		// From Nth row (eg. from 5th row)
		query.setFirstResult(0);
		// N number of rows (eg. 3 rows --> 5,6,7)
		query.setMaxResults(4);
		@SuppressWarnings("unchecked")
		List<MarvelCharacters> chars = query.getResultList();
		System.out.println(chars);

		trans.commit();
	}

}
