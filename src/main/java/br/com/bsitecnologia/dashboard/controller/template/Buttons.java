package br.com.bsitecnologia.dashboard.controller.template;

public enum Buttons {
	
	SALVAR("Salvar"), EDITAR("Editar"), DELETAR("Deletar");
	
	private Buttons(String label) {
		this.label = label;
	}
	
	private String label;
	
	public String getLabel(){
		return this.label;
	}


}
