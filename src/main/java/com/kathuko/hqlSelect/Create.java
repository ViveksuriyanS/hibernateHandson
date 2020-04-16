package com.kathuko.hqlSelect;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Create {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("HQLIntro.cfg.xml").addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// Select classVariable from MarvelCharacters
		Query query = ses.createQuery("select name from MarvelCharacters");
		@SuppressWarnings("unchecked")
		List<String> chars = query.getResultList();
		System.out.println(chars);

		Query query1 = ses.createQuery("select new map(id,name) from MarvelCharacters");
		@SuppressWarnings("unchecked")
		List<Map<Integer, String>> chars1 = query1.getResultList();
		System.out.println(chars1);

		Query query2 = ses.createQuery("select max(id) from MarvelCharacters");
		@SuppressWarnings("unchecked")
		List<Integer> chars2 = query2.getResultList();
		System.out.println(chars2.get(0));

		trans.commit();
	}

}
