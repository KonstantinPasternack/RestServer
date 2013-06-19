package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {

	@Autowired
	SessionFactory sessionFactory;

	// Methode, die einen Benutzer speichert
	@Transactional
	public void saveBenutzer(Benutzer benutzer) {
		sessionFactory.getCurrentSession().saveOrUpdate(benutzer);
		// hibernateTemplate.saveOrUpdate(benutzer);
	}

	// Methode, die einen Benutzer über eine ID zurückliefert
	@Transactional
	public Benutzer findBenutzerById(Integer id) {
		Benutzer b = (Benutzer) sessionFactory.getCurrentSession().get(
				Benutzer.class, id);
		System.out.println("Benutzer zu ID " + id);

		return b;
	}

	// Methode, die eine Liste von allen Benutzer zurückliefert
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Benutzer> listBenutzer() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
		//TODO Methode umschreiben
	}

	// Methode, die einen Benutzer über einen Usernamen zurückliefert
	@Transactional
	public Benutzer findBenutzerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
//		Benutzer b = (Benutzer) sessionFactory.getCurrentSession().get(
//				Benutzer.class, username);
		Criteria criteria = session.createCriteria(Benutzer.class);
		 criteria.add(Restrictions.eq("username", username));

		return (Benutzer) criteria.list().get(0);
	}

}
