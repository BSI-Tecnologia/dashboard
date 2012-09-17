package br.com.bsitecnologia.dashboard.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.bsitecnologia.dashboard.controller.datamodel.DashboardDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.controller.template.Buttons;
import br.com.bsitecnologia.dashboard.dao.base.GenericJpaRepository;
import br.com.bsitecnologia.dashboard.util.BaseEntity;

@SuppressWarnings("unchecked")
public abstract class BaseCrudBean<T extends BaseEntity> implements Serializable{

	private static final long serialVersionUID = 1906091377786784028L;
	private final Class<T> entityClass = (Class<T>)getClass();	
	
	
	/* Propriedades comuns a todos os beans - variaveis de layout e controle de tela */
	
	private String title = entityClass.getSimpleName().replace("Bean", "");
	private final BreadcrumbEnum[] breadcrumb = setBreadcrumbArray();
	private String saveButtonLabel = Buttons.SAVE.getLabel();
	private boolean showDeleteButton = false;
	private List<T> list;

	
	/*Metodos a serem implementados pelos beans, operações comuns a todos*/
	
	protected abstract <X extends GenericJpaRepository<T, Serializable>> X getDao();
	protected abstract T getFormEntity();
	protected abstract void setFormEntity(T t);
	protected abstract DashboardDataModel<T> getDataModel();
	protected abstract String getEntityDescription();
	protected abstract BreadcrumbEnum[] setBreadcrumbArray();
	protected abstract void resetFormEntity();
	
	
	/*Metodos a serem sobreescritos quando necessario*/
	
	protected void postRowSelect(){}
	protected void postLoad(){}
	protected void postPersist(){}
	protected void prePersist(){}
	
	
	/*Ações comuns a serem herdadas*/
	
	public void init() {
		loadList();
		postLoad();
	}
	
	protected void loadList(){
		list = getDao().findAll();
		getDataModel().setList(list);
	}
	
	public void save(){
		prePersist();
		getDao().save(getFormEntity());
		loadList();
		addMessage(FacesMessage.SEVERITY_INFO, String.format("%s: %s", title, getEntityDescription()), String.format("%s salvo(a) com sucesso.", title));
		saveButtonLabel = Buttons.SAVE.getLabel();
		showDeleteButton = false;
		postPersist();
	}
	
	public void delete(){
		prePersist();
		getDao().delete(getFormEntity());
		loadList();
		addMessage(FacesMessage.SEVERITY_INFO,  String.format("%s: %s", title, getEntityDescription()), String.format("%s deletado(a) com sucesso.", title));
		saveButtonLabel = Buttons.SAVE.getLabel();
		showDeleteButton = false;
		postPersist();
	}
	
	public void cancel(){
		showDeleteButton = false;
		saveButtonLabel = Buttons.SAVE.getLabel();
		resetFormEntity();
	}
	
	public void onRowSelect(SelectEvent event) {
		saveButtonLabel = Buttons.EDIT.getLabel();
		showDeleteButton = true;
        setFormEntity((T) event.getObject());
        postRowSelect();
    }
	
	public void addMessage(Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage fm =  new FacesMessage(severity, summary, detail);
        context.addMessage(null, fm);
        context.renderResponse();
	}
	
	
	/*get&set*/
	
	public String getSaveButtonLabel() {
		return saveButtonLabel;
	}
	
	public void setSaveButtonLabel(String saveButtonLabel) {
		this.saveButtonLabel = saveButtonLabel;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isShowDeleteButton() {
		return showDeleteButton;
	}

	public void setShowDeleteButton(boolean showDeleteButton) {
		this.showDeleteButton = showDeleteButton;
	}

	public BreadcrumbEnum[] getBreadcrumb() {
		return breadcrumb;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}

}
