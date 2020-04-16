package com.kathuko.hqlCriteriaAPI;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

/**
 * @author viveksuriyan.s
 *
 */
public class CreateProjections {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("HQLIntro.cfg.xml").addAnnotatedClass(MarvelCharacters.class);
		ServiceRegistry ser = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(ser);
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();

		// Deprecated Criteria
		Criteria criteria = ses.createCriteria(MarvelCharacters.class);
		criteria.add(Restrictions.eq("id", 1));
		List<MarvelCharacters> cList = criteria.list();
		System.out.println(cList);

		trans.commit();
	}

}
