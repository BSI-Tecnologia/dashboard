package br.com.bsitecnologia.dashboard.controller.admin;

import static org.junit.Assert.fail;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.inject.Inject;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.Conversation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.solder.exception.control.ExceptionToCatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.event.SelectEvent;

import br.com.bsitecnologia.dashboard.controller.BaseBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.CargoDataModel;
import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.dao.base.GenericJpaRepository;
import br.com.bsitecnologia.dashboard.dao.base.GenericRepository;
import br.com.bsitecnologia.dashboard.model.Cargo;
import br.com.bsitecnologia.dashboard.util.Breadcrumb;

@RunWith(Arquillian.class)
public class CargoBeanTest {
	
	@Inject
	CargoBean cargoBean;
	
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(Cargo.class, CargoBean.class, BaseBean.class, Severity.class, Criterion.class, ExceptionToCatch.class,Criteria.class,
            		Conversation.class, FacesMessage.class, GenericRepository.class, 
            		GenericJpaRepository.class, CargoDao.class, SelectEvent.class,
            		CargoDataModel.class, Breadcrumb.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
