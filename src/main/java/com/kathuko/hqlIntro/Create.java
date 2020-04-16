package com.kathuko.hqlIntro;

import java.util.List;

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
		@SuppressWarnings("unchecked")
		// Select * from MarvelCharacters
		List<MarvelCharacters> chars = ses.createQuery("from MarvelCharacters").getResultList();
		System.out.println(chars);

		@SuppressWarnings("unchecked")
		// Select * from MarvelCharacters where id < 5
		List<MarvelCharacters> superHeros = ses.createQuery("from MarvelCharacters where id < 5").getResultList();
		System.out.println(superHeros);
		trans.commit();
	}

}
