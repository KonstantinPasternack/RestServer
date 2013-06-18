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
import de.giftbox.dao.GeschenkDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Geschenk;

@Repository
public class GeschenkDAOImpl implements GeschenkDAO {

	@Autowired	
	SessionFactory sessionFactory;

	@Transactional
	public void saveGeschenk(Geschenk geschenk) {
		sessionFactory.getCurrentSession().saveOrUpdate(geschenk);
		//		hibernateTemplate.saveOrUpdate(benutzer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Geschenk> listGeschenk() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Geschenk.class);
//		criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
	}

	public void deleteGeschenk(Geschenk geschenk) {
		sessionFactory.getCurrentSession().delete(geschenk);
		
	}

}
