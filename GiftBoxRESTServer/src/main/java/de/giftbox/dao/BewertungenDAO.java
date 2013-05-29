package de.giftbox.dao;

// Generated 29.05.2013 11:21:40 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.giftbox.domain.Bewertungen;

/**
 * Home object for domain model class Bewertungen.
 * @see de.giftbox.domain.Bewertungen
 * @author Hibernate Tools
 */
@Stateless
public class BewertungenDAO {

	private static final Log log = LogFactory.getLog(BewertungenDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Bewertungen transientInstance) {
		log.debug("persisting Bewertungen instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Bewertungen persistentInstance) {
		log.debug("removing Bewertungen instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Bewertungen merge(Bewertungen detachedInstance) {
		log.debug("merging Bewertungen instance");
		try {
			Bewertungen result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bewertungen findById(Integer id) {
		log.debug("getting Bewertungen instance with id: " + id);
		try {
			Bewertungen instance = entityManager.find(Bewertungen.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
