package de.giftbox.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.giftbox.domain.Geschenk;

public class GeschenkDAOImpl implements GeschenkDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveGeschenk(Geschenk geschenk) {
		hibernateTemplate.saveOrUpdate(geschenk);
	}

	@Override
	public void deleteGeschenk(Geschenk geschenk) {
		hibernateTemplate.delete(geschenk);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Geschenk> listGeschenk() {
		return hibernateTemplate.find("from Geschenk");
	}
}
