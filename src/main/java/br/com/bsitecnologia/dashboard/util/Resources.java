package br.com.bsitecnologia.dashboard.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence
 * context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * private EntityManager entityManager;
 * </pre>
 */
public class Resources {
	@Produces
	@DashboardDB
	@PersistenceContext
	EntityManager entityManager;
	
	@Produces
	@DashboardDB
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
}
