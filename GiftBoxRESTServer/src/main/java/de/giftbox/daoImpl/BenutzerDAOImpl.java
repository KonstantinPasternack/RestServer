package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveBenutzer(Benutzer benutzer) {
		sessionFactory.getCurrentSession().saveOrUpdate(benutzer);
		// hibernateTemplate.saveOrUpdate(benutzer);
	}

	@Transactional
	public Integer findBenutzerById(Integer id) {
		Benutzer b =  (Benutzer) sessionFactory.getCurrentSession().get(
				Benutzer.class, id);
		
		return b.getIdBenutzer();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Benutzer> listBenutzer() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
	}

}
