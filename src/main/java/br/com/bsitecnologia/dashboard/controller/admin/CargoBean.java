package br.com.bsitecnologia.dashboard.controller.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;

import br.com.bsitecnologia.dashboard.controller.BaseBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.DashboardDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.model.Cargo;

@Named
@ConversationScoped
@SuppressWarnings("unchecked")
public class CargoBean extends BaseBean<Cargo> implements Serializable {
	
	private static final long serialVersionUID = -563351669224686839L;
	
	@Inject private CargoDao cargoDao;
	@Inject @New private Cargo cargoForm;
	@Inject private DashboardDataModel<Cargo> dataModel;
	
	@PostConstruct
	public void postConstruct(){
		super.init();
	}
	
	/*BASE BEAN ABSTRACT METHODS IMPLEMENTATION*/

	@Override
	protected CargoDao getDao() {
		return cargoDao;
	}

	@Override
	protected Cargo getFormEntity() {
		return cargoForm;
	}

	@Override
	protected void setFormEntity(Cargo cargo) {
		cargoForm = cargo;		
	}

	@Override
	public void prePersist() {
		return;
	}

	@Override
	public void postPersist() {
		cargoForm = new Cargo();
	}

	@Override
	public String getEntityDescription() {
		return cargoForm.getNome();
	}

	@Override
	protected BreadcrumbEnum[] setBreadcrumbArray() {
		return new BreadcrumbEnum[]{BreadcrumbEnum.HOME, BreadcrumbEnum.CARGO};
	}

	@Override
	protected void postRowSelect() {
		return;
	}
	
	@Override
	protected void postLoad() {
		return;
	}
	
	/* get&set */
	
	public Cargo getCargoForm() {
		return cargoForm;
	}

	public void setCargoForm(Cargo cargoForm) {
		this.cargoForm = cargoForm;
	}
	
	public DashboardDataModel<Cargo> getDataModel() {
		return dataModel;
	}

}
