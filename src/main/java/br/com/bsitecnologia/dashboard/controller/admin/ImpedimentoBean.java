package br.com.bsitecnologia.dashboard.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;

import br.com.bsitecnologia.dashboard.controller.BaseCrudBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.DashboardDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.ColaboradorDao;
import br.com.bsitecnologia.dashboard.dao.ProjetoDao;
import br.com.bsitecnologia.dashboard.dao.base.GenericJpaRepository;
import br.com.bsitecnologia.dashboard.model.Colaborador;
import br.com.bsitecnologia.dashboard.model.Impedimento;
import br.com.bsitecnologia.dashboard.model.Projeto;

@Named
@ConversationScoped
public class ImpedimentoBean extends BaseCrudBean<Impedimento>{

	@Override
	protected <X extends GenericJpaRepository<Impedimento, Serializable>> X getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Impedimento getFormEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setFormEntity(Impedimento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected DashboardDataModel<Impedimento> getDataModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BreadcrumbEnum[] setBreadcrumbArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void resetFormEntity() {
		// TODO Auto-generated method stub
		
	}

	private static final long serialVersionUID = 1375567838606752462L;
	
	@Inject private ProjetoDao projetoDao;
	private List<Projeto> allProjetosFromDb;
	
	@Inject private ColaboradorDao colaboradorDao;
	private List<Colaborador> allColaboradorFromDb;
	
//	@Inject private RiscoDao riscoDao; 
//	private List<Risco> allRiscoFromDb;
	
	private List<SelectItem> statusList;
	private String statusSelectedItemId;
	
	private List<SelectItem> projetoPaiList;
	private String projetoPaiSelectedItemId;
	
	
	@Inject @New private Projeto projetoForm;
	@Inject private DashboardDataModel<Projeto> dataModel;

	@PostConstruct
	public void postConstruct(){
		init();
	}
	
//	public void statusValueChangeListener(ValueChangeEvent event){
//		projetoForm.setStatus(getEntityFromValueChangeEvent(event, allStatusFromDb));
//	}
//	
//	public void projetoPaiValueChangeListener(ValueChangeEvent event){
//		projetoForm.setProjetoPai(getEntityFromValueChangeEvent(event, getList()));
//	}
	
	/*BASE BEAN ABSTRACT METHODS IMPLEMENTATION*/
	
	

}