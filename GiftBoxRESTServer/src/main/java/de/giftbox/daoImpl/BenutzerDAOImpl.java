package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {

	private HibernateTemplate hibernateTemplate;
	
	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveBenutzer(Benutzer benutzer) {
		sessionFactory.getCurrentSession().persist(benutzer);
		//		hibernateTemplate.saveOrUpdate(benutzer);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Benutzer> listBenutzer() {
		return hibernateTemplate.find("from Benutzer");
	}

}
