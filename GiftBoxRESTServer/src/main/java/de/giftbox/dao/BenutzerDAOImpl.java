package de.giftbox.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.giftbox.domain.Benutzer;

public class BenutzerDAOImpl implements BenutzerDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveBenutzer(Benutzer benutzer) {
		hibernateTemplate.saveOrUpdate(benutzer);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Benutzer> listBenutzer() {
		return hibernateTemplate.find("from Benutzer");
	}

}
