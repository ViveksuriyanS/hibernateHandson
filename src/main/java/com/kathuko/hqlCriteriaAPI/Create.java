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
public class Create {

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

		// Deprecated Criteria
		Criteria criteria1 = ses.createCriteria(MarvelCharacters.class);
		criteria1.add(Restrictions.lt("id", 5)); // LESS THAN
//		criteria1.add(Restrictions.gt("id", 5)); // GREATER THAN
//		criteria1.add(Restrictions.between("id", 1, 7)); // BETWEEN
		List<MarvelCharacters> cList1 = criteria1.list();
		System.out.println(cList1);

		// Deprecated Criteria
		Criteria criteria2 = ses.createCriteria(MarvelCharacters.class);
		criteria2.add(Restrictions.or(Restrictions.between("id", 1, 3), Restrictions.between("id", 5, 10)));
		List<MarvelCharacters> cList2 = criteria2.list();
		System.out.println(cList2.size());

		// Using criteriaBuilder and CriteriaQuery
		CriteriaBuilder criteriaBuilder = ses.getCriteriaBuilder();
		CriteriaQuery<MarvelCharacters> query = criteriaBuilder.createQuery(MarvelCharacters.class);
		Root<MarvelCharacters> from = query.from(MarvelCharacters.class);
		query.select(from); // Select * from

		// where id = 1
		query.where(criteriaBuilder.equal(from.get("id"), 1));
		Query queryx = ses.createQuery(query);
		List<MarvelCharacters> chars = queryx.getResultList();
		System.out.println(chars);

		trans.commit();
	}

}
