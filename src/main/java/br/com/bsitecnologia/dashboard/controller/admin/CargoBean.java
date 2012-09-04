package br.com.bsitecnologia.dashboard.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bsitecnologia.dashboard.dao.CargoDao;
import br.com.bsitecnologia.dashboard.model.Cargo;

@SuppressWarnings("unused")
@Named
@ConversationScoped
public class CargoBean implements Serializable {
	
	private static final long serialVersionUID = -563351669224686839L;

	@Inject
    private CargoDao cargoDao;
	
	@Inject
	private Conversation conversation;
	
	private Cargo cargoForm;
	
	private String tituloAccordion = "Incluir_não_funfa";
	
	private List<Cargo> cargosList;
	
	@PostConstruct
	private void init(){
		conversation.begin();
		loadCargosList();
		cargoForm = new Cargo();
	}
	
	private void loadCargosList(){
		cargosList = cargoDao.findAll();
	}

	public String salvar() throws Exception{
		cargoDao.save(cargoForm);
		System.out.println("SALVOUUUUUUUUUUU !!!");
		cargoForm = new Cargo();
		return "";
	}
	
	public List<Cargo> getCargosList(){
		return cargosList;
	}
	
	public String getTituloAccordion() {
		return tituloAccordion;
	}

	public void setTituloAccordion(String tituloAccordion) {
		this.tituloAccordion = tituloAccordion;
	}
	
	public Cargo getCargoForm() {
		return cargoForm;
	}

	public void setCargoForm(Cargo cargoForm) {
		this.cargoForm = cargoForm;
	}
	
	
}
