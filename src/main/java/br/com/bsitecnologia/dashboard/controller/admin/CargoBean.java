package br.com.bsitecnologia.dashboard.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.Conversation;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;
import org.primefaces.event.SelectEvent;

import br.com.bsitecnologia.dashboard.controller.BaseBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.CargoDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.model.Cargo;

@Named
@ConversationScoped
public class CargoBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = -563351669224686839L;
	
	@Inject Conversation conversation;
	
	@Inject private CargoDao cargoDao;
	
	@Inject @New private Cargo cargoForm;
	
	private List<Cargo> cargosList;
	
	@Inject private CargoDataModel dataModel;
	
	private String saveButtonLabel = "Salvar";
	
	private boolean showDeleteButton = false;
	
	private final String title = "Cargo";
	
	private final BreadcrumbEnum[] breadcrumb = {BreadcrumbEnum.HOME, BreadcrumbEnum.CARGO};
	
	@PostConstruct
	public void init(){
		loadCargosList();
	}
	
	private void loadCargosList(){
		cargosList = cargoDao.findAll();
		dataModel.setCargoList(cargosList);
	}

	public void salvar(){
		cargoDao.save(cargoForm);
		loadCargosList();
		addMessage(FacesMessage.SEVERITY_INFO, String.format("Cargo: %s", cargoForm.getNome()), "Cargo salvo com sucesso.");
		saveButtonLabel = "Salvar";
		showDeleteButton = false;
		cargoForm = new Cargo();
	}
	
	public void deletar(){
		cargoDao.delete(cargoForm);
		loadCargosList();
		addMessage(FacesMessage.SEVERITY_INFO, String.format("Cargo: %s", cargoForm.getNome()), "Cargo deletado com sucesso.");
		saveButtonLabel = "Salvar";
		showDeleteButton = false;
		cargoForm = new Cargo();
	}
	
	public void onRowSelect(SelectEvent event) {
		saveButtonLabel = "Editar";
		showDeleteButton = true;
        cargoForm = (Cargo) event.getObject();  
    }  
	
	/* get&set */
	
	public List<Cargo> getCargosList(){
		return cargosList;
	}
	
	public Cargo getCargoForm() {
		return cargoForm;
	}

	public void setCargoForm(Cargo cargoForm) {
		this.cargoForm = cargoForm;
	}
	
	public CargoDataModel getDataModel() {
		return dataModel;
	}
	
	public String getSaveButtonLabel() {
		return saveButtonLabel;
	}
	
	public boolean isShowDeleteButton() {
		return showDeleteButton;
	}
	
	public BreadcrumbEnum[] getBreadcrumb() {
		return breadcrumb;
	}
	
	public String getTitle() {
		return title;
	}

}
