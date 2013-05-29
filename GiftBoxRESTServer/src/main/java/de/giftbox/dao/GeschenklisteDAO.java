package de.giftbox.dao;

// Generated 29.05.2013 11:21:40 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.giftbox.domain.Geschenkliste;

/**
 * Home object for domain model class Geschenkliste.
 * @see de.giftbox.domain.Geschenkliste
 * @author Hibernate Tools
 */
@Stateless
public class GeschenklisteDAO {

	private static final Log log = LogFactory.getLog(GeschenklisteDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Geschenkliste transientInstance) {
		log.debug("persisting Geschenkliste instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Geschenkliste persistentInstance) {
		log.debug("removing Geschenkliste instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Geschenkliste merge(Geschenkliste detachedInstance) {
		log.debug("merging Geschenkliste instance");
		try {
			Geschenkliste result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Geschenkliste findById(int id) {
		log.debug("getting Geschenkliste instance with id: " + id);
		try {
			Geschenkliste instance = entityManager
					.find(Geschenkliste.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
