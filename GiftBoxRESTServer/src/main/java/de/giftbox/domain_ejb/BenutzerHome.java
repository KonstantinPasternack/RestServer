package de.giftbox.domain_ejb;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Benutzer.
 * @see de.giftbox.domain_ejb.Benutzer
 * @author Hibernate Tools
 */
@Stateless
public class BenutzerHome {

	private static final Log log = LogFactory.getLog(BenutzerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Benutzer transientInstance) {
		log.debug("persisting Benutzer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Benutzer persistentInstance) {
		log.debug("removing Benutzer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Benutzer merge(Benutzer detachedInstance) {
		log.debug("merging Benutzer instance");
		try {
			Benutzer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Benutzer findById(Integer id) {
		log.debug("getting Benutzer instance with id: " + id);
		try {
			Benutzer instance = entityManager.find(Benutzer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}