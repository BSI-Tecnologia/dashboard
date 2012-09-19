package br.com.bsitecnologia.dashboard.controller.admin;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;

import br.com.bsitecnologia.dashboard.controller.BaseCrudBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.DashboardDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.dao.ColaboradorDao;
import br.com.bsitecnologia.dashboard.dao.EquipeDao;
import br.com.bsitecnologia.dashboard.model.Cargo;
import br.com.bsitecnologia.dashboard.model.Colaborador;
import br.com.bsitecnologia.dashboard.model.Equipe;

@Named
@ConversationScoped
@SuppressWarnings("unchecked")
public class ColaboradorBean extends BaseCrudBean<Colaborador>{

	private static final long serialVersionUID = 1375567838606752462L;
	
	@Inject private EquipeDao equipeDao;
	private List<Equipe> allEquipeFromDb;
	@Inject private CargoDao cargoDao;
	private List<Cargo> allCargoFromDb;
	
	private List<SelectItem> equipeList;
	private List<SelectItem> cargoList;
	private String equipeSelectedItemId;
	private String cargoSelectedItemId;
	
	@Inject private ColaboradorDao colaboradorDao;
	@Inject @New private Colaborador colaboradorForm;
	@Inject private DashboardDataModel<Colaborador> dataModel;

	@PostConstruct
	public void postConstruct(){
		init();
	}
	
	public void cargoValueChangeListener(ValueChangeEvent event){
		colaboradorForm.setCargo(getEntityFromValueChangeEvent(event, Cargo.class, allCargoFromDb));
	}
	
	public void equipeValueChangeListener(ValueChangeEvent event){
		colaboradorForm.setEquipe(getEntityFromValueChangeEvent(event, Equipe.class, allEquipeFromDb));
	}
	
	/*BASE BEAN ABSTRACT METHODS IMPLEMENTATION*/
	
	
	@Override
	protected BreadcrumbEnum[] setBreadcrumbArray() {
		return new BreadcrumbEnum[] {BreadcrumbEnum.HOME, BreadcrumbEnum.COLABORADOR};
	}

	@Override
	protected ColaboradorDao getDao() {
		return colaboradorDao;
	}

	@Override
	protected Colaborador getFormEntity() {
		return colaboradorForm;
	}

	@Override
	protected void setFormEntity(Colaborador colaborador) {
		this.colaboradorForm = colaborador;
	}

	@Override
	protected DashboardDataModel<Colaborador> getDataModel() {
		return dataModel;
	}

	@Override
	protected void resetFormEntity() {
		equipeSelectedItemId = null;
		cargoSelectedItemId = null;
		colaboradorForm = new Colaborador();
	}
	
	@Override
	protected void postLoad() {
		allEquipeFromDb = equipeDao.findAll();
		equipeList = fillSelectItemList(allEquipeFromDb);
		allCargoFromDb = cargoDao.findAll();
		cargoList = fillSelectItemList(allEquipeFromDb);
	}
	

	/*gets&sets*/

	public List<SelectItem> getEquipeList() {
		return equipeList;
	}

	public void setEquipeList(List<SelectItem> equipeList) {
		this.equipeList = equipeList;
	}

	public List<SelectItem> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<SelectItem> cargoList) {
		this.cargoList = cargoList;
	}

	public String getEquipeSelectedItemId() {
		return equipeSelectedItemId;
	}

	public void setEquipeSelectedItemId(String equipeSelectedItemId) {
		this.equipeSelectedItemId = equipeSelectedItemId;
	}

	public String getCargoSelectedItemId() {
		return cargoSelectedItemId;
	}

	public void setCargoSelectedItemId(String cargoSelectedItemId) {
		this.cargoSelectedItemId = cargoSelectedItemId;
	}

	public Colaborador getColaboradorForm() {
		return colaboradorForm;
	}

	public void setColaboradorForm(Colaborador colaboradorForm) {
		this.colaboradorForm = colaboradorForm;
	}

	public void setDataModel(DashboardDataModel<Colaborador> dataModel) {
		this.dataModel = dataModel;
	}

}