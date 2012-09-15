package br.com.bsitecnologia.dashboard.controller.admin;

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
import br.com.bsitecnologia.dashboard.controller.datamodel.EquipeDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.EquipeDao;
import br.com.bsitecnologia.dashboard.model.Equipe;

@Named
@ConversationScoped
public class EquipeBean extends BaseBean{

	private static final long serialVersionUID = 1375567838606752462L;
	
	@Inject Conversation conversation;
	
	@Inject private EquipeDao equipeDao;
	
	@Inject @New private Equipe equipeForm;
	
	private List<Equipe> equipesList;
	
	@Inject private EquipeDataModel dataModel;
	
	private String saveButtonLabel = "Salvar";
	
	private boolean showDeleteButton = false;
	
	private final String title = "Equipe";
	
	private final BreadcrumbEnum[] breadcrumb = {BreadcrumbEnum.HOME, BreadcrumbEnum.EQUIPE};
	
	@PostConstruct
	public void init(){
		loadEquipesList();
	}
	
	private void loadEquipesList(){
		equipesList = equipeDao.findAll();
		dataModel.setEquipeList(equipesList);
	}

	public void salvar(){
		equipeDao.save(equipeForm);
		loadEquipesList();
		addMessage(FacesMessage.SEVERITY_INFO, String.format("Cargo: %s", equipeForm.getNome()), "Equipe salva com sucesso.");
		saveButtonLabel = "Salvar";
		showDeleteButton = false;
		equipeForm = new Equipe();
	}
	
	public void deletar(){
		equipeDao.delete(equipeForm);
		loadEquipesList();
		addMessage(FacesMessage.SEVERITY_INFO, String.format("Cargo: %s", equipeForm.getNome()), "Equipe deletada com sucesso.");
		saveButtonLabel = "Salvar";
		showDeleteButton = false;
		equipeForm = new Equipe();
	}
	
	public void onRowSelect(SelectEvent event) {
		saveButtonLabel = "Editar";
		showDeleteButton = true;
        equipeForm = (Equipe) event.getObject();  
    }
	
	/*gets&sets*/
	
	public String getTitle() {
		return title;
	}

	public BreadcrumbEnum[] getBreadcrumb() {
		return breadcrumb;
	}

	public Equipe getEquipeForm() {
		return equipeForm;
	}

	public void setEquipeForm(Equipe equipeForm) {
		this.equipeForm = equipeForm;
	}

	public EquipeDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(EquipeDataModel dataModel) {
		this.dataModel = dataModel;
	}

	public List<Equipe> getEquipesList() {
		return equipesList;
	}

	public String getSaveButtonLabel() {
		return saveButtonLabel;
	}

	public boolean isShowDeleteButton() {
		return showDeleteButton;
	}
	
}
