package com.kathuko.hqlNamedQueries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author viveksuriyan.s
 *
 */
public class Create {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("HQLIntro.cfg.xml").addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// NamedQuery1
		Query query = ses.getNamedQuery("MarvelDetails.byId");
		query.setParameter(1, 1);
		@SuppressWarnings("unchecked")
		List<MarvelCharacters> chars = query.getResultList();
		System.out.println(chars);

		// NamedQuery2
		Query query1 = ses.getNamedQuery("MarvelDetails.byName");
		query1.setParameter(1, "Thor");
		@SuppressWarnings("unchecked")
		List<MarvelCharacters> chars1 = query1.getResultList();
		System.out.println(chars1);

		// NamedNativeQuery
		Query nativequery1 = ses.getNamedQuery("SuperHeroes");
		@SuppressWarnings("unchecked")
		List<MarvelCharacters> superHeroes = nativequery1.getResultList();
		System.out.println(superHeroes);

		trans.commit();
	}

}
