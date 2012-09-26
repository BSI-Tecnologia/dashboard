package br.com.bsitecnologia.dashboard.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;

import br.com.bsitecnologia.dashboard.controller.BaseCrudBean;
import br.com.bsitecnologia.dashboard.controller.datamodel.DashboardDataModel;
import br.com.bsitecnologia.dashboard.controller.template.BreadcrumbEnum;
import br.com.bsitecnologia.dashboard.dao.AtorExternoDao;
import br.com.bsitecnologia.dashboard.dao.ColaboradorDao;
import br.com.bsitecnologia.dashboard.dao.UsuarioDao;
import br.com.bsitecnologia.dashboard.model.AtorExterno;
import br.com.bsitecnologia.dashboard.model.Colaborador;
import br.com.bsitecnologia.dashboard.model.Usuario;

@Named
@ConversationScoped
@SuppressWarnings("unchecked")
public class UsuarioBean extends BaseCrudBean<Usuario>{
	
	private static final long serialVersionUID = -4925905139833098305L;

	@Inject @New private Usuario usuarioForm;
	@Inject private UsuarioDao  usuarioDao;
	@Inject private DashboardDataModel<Usuario> dataModel;
	
	private String confirmacaoSenha;
	private boolean usuarioColaboradorBSI;
	
	@Inject	private ColaboradorDao colaboradorDao;
	private List<Colaborador> allColaboradorFromDb;
	private List<SelectItem> colaboradorSelectItemList = new ArrayList<SelectItem>();
	private String selectedColaboradorItem;
	
	@Inject private AtorExternoDao atorExternoDao;
	private List<AtorExterno> allAtorExternoFromDb;
	private List<SelectItem> atorExternoItemList = new ArrayList<SelectItem>();
	private String selectedAtorExternoItem;
	
	
	public void verificaSenhas(){
		if(!confereIgualdadeSenha()){
			addMessage(FacesMessage.SEVERITY_WARN, "Usuário: senha", "Senha e confirmação de senha são diferentes.");
		}
	}
	
	private boolean confereIgualdadeSenha(){
		if(confirmacaoSenha.equals(usuarioForm.getSenha())){
			return true;
		}
		return false;
	}
	
	public void renderCombos(ValueChangeEvent event){
		System.out.println(event.getNewValue());
	}
	
	
	/*BASE BEAN ABSTRACT METHODS IMPLEMENTATION*/

	@Override
	protected UsuarioDao getDao() {
		return usuarioDao;
	}

	@Override
	protected Usuario getFormEntity() {
		return usuarioForm;
	}

	@Override
	protected void setFormEntity(Usuario usuario) {
		usuarioForm = usuario;
	}

	@Override
	protected DashboardDataModel<Usuario> getDataModel() {
		return dataModel;
	}

	@Override
	protected BreadcrumbEnum[] setBreadcrumbArray() {
		return new BreadcrumbEnum[] {BreadcrumbEnum.HOME, BreadcrumbEnum.USUARIO};
	}

	@Override
	protected void resetFormEntity() {
		usuarioForm = new Usuario();
		selectedColaboradorItem = null;
		selectedAtorExternoItem = null;
	}
	
	@Override
	protected void postLoad() {
		allColaboradorFromDb = colaboradorDao.findAll();
		allAtorExternoFromDb = atorExternoDao.findAll();
		atorExternoItemList = fillSelectItemList(allAtorExternoFromDb);
		colaboradorSelectItemList = fillSelectItemList(allColaboradorFromDb);
	}
	
	/*get&set*/
	
	public List<SelectItem> getColaboradorSelectItemList() {
		return colaboradorSelectItemList;
	}

	public void setColaboradorSelectItemList(
			List<SelectItem> colaboradorSelectItemList) {
		this.colaboradorSelectItemList = colaboradorSelectItemList;
	}

	public String getSelectedColaboradorItem() {
		return selectedColaboradorItem;
	}

	public void setSelectedColaboradorItem(String selectedColaboradorItem) {
		this.selectedColaboradorItem = selectedColaboradorItem;
	}

	public List<SelectItem> getAtorExternoItemList() {
		return atorExternoItemList;
	}

	public void setAtorExternoItemList(List<SelectItem> atorExternoItemList) {
		this.atorExternoItemList = atorExternoItemList;
	}

	public String getSelectedAtorExternoItem() {
		return selectedAtorExternoItem;
	}

	public void setSelectedAtorExternoItem(String selectedAtorExternoItem) {
		this.selectedAtorExternoItem = selectedAtorExternoItem;
	}

	public Usuario getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
	
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	
	public boolean isUsuarioColaboradorBSI() {
		return usuarioColaboradorBSI;
	}

	public void setUsuarioColaboradorBSI(boolean usuarioColaboradorBSI) {
		this.usuarioColaboradorBSI = usuarioColaboradorBSI;
	}

}