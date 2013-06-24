package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.GeschenklisteDAO;
import de.giftbox.domain.Geschenk;
import de.giftbox.domain.Geschenkliste;

@Repository
public class GeschenklisteDAOImpl implements GeschenklisteDAO {

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveGeschenkliste(Geschenkliste geschenkliste) {
		hibernateTemplate.saveOrUpdate(geschenkliste);
	}

	@Override
	public void deleteGeschenkliste(Geschenkliste geschenkliste) {
		hibernateTemplate.delete(geschenkliste);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Geschenkliste> listGeschenkliste() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Geschenkliste.class);
		return criteria.list();	}
}
