package de.giftbox.dao;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.giftbox.domain.Geschenk;

/**
 * Home object for domain model class Geschenk.
 * @see de.giftbox.domain.Geschenk
 * @author Hibernate Tools
 */
@Stateless
public class GeschenkDAO {

	private static final Log log = LogFactory.getLog(GeschenkDAO.class);

	EntityManagerFactory emf;
	
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Geschenk transientInstance) {
		
		emf = Persistence.createEntityManagerFactory("JPAPU");
		entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		log.debug("persisting Geschenk instance");
		try {
			
			tx.begin();
			entityManager.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		entityManager.flush();
	}

	public void remove(Geschenk persistentInstance) {
		log.debug("removing Geschenk instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Geschenk merge(Geschenk detachedInstance) {
		log.debug("merging Geschenk instance");
		try {
			Geschenk result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Geschenk findById(Integer id) {
		log.debug("getting Geschenk instance with id: " + id);
		try {
			Geschenk instance = entityManager.find(Geschenk.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
