package de.giftbox.domain_ejb;

// Generated 29.05.2013 11:21:40 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class GeschenklisteHasGeschenk.
 * @see de.giftbox.domain_ejb.GeschenklisteHasGeschenk
 * @author Hibernate Tools
 */
@Stateless
public class GeschenklisteHasGeschenkHome {

	private static final Log log = LogFactory
			.getLog(GeschenklisteHasGeschenkHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(GeschenklisteHasGeschenk transientInstance) {
		log.debug("persisting GeschenklisteHasGeschenk instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(GeschenklisteHasGeschenk persistentInstance) {
		log.debug("removing GeschenklisteHasGeschenk instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public GeschenklisteHasGeschenk merge(
			GeschenklisteHasGeschenk detachedInstance) {
		log.debug("merging GeschenklisteHasGeschenk instance");
		try {
			GeschenklisteHasGeschenk result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GeschenklisteHasGeschenk findById(GeschenklisteHasGeschenkId id) {
		log.debug("getting GeschenklisteHasGeschenk instance with id: " + id);
		try {
			GeschenklisteHasGeschenk instance = entityManager.find(
					GeschenklisteHasGeschenk.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
