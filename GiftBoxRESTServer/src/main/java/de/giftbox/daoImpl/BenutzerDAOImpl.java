package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	// Methode, die einen Benutzer speichert
	@Transactional
	public void saveBenutzer(Benutzer benutzer) {
		sessionFactory.getCurrentSession().saveOrUpdate(benutzer);
		// hibernateTemplate.saveOrUpdate(benutzer);
	}

	// Methode, die einen Benutzer �ber eine ID zur�ckliefert
	@Transactional
	public Benutzer getBenutzerById(Integer id) {
		log.debug("Getting Benutzer with ID: " + id);
		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Benutzer> b = session.createCriteria(Benutzer.class)
				.add(Restrictions.eq("id_Benutzer", id)).list();

		return b.get(0);
	}

	// Methode, die eine Liste von allen Benutzer zur�ckliefert
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Benutzer> listBenutzer() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
		//TODO Methode umschreiben
	}

	// Methode, die einen Benutzer �ber einen Usernamen zur�ckliefert
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
