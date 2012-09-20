package br.com.bsitecnologia.dashboard.controller.template;

public enum BreadcrumbEnum {
	
	HOME("Home", "/index.jsf", "Ir para a página inicial"), 
	CARGO("Cargo", "/admin/cargo/cargo.jsf", "Administração de cargos"),
	EQUIPE("Equipe", "/admin/equipe/equipe.jsf", "Administração de Equipes"), 
	STATUS("Status", "/admin/status/status.jsf", "Administração de status"), 
	ATOR_EXTERNO("Ator externo", "/admin/atorexterno/atorexterno.jsf", "Administração de atores externos"),
	IMPACTO("Impacto", "/admin/impacto/impacto.jsf", "Administração de impactos"),
	TRANSICAO_STATUS("Transição de status", "/admin/transicaostatus/transicaostatus.jsf", "Administração transições de status"),
	COLABORADOR("Colaborador", "/admin/colaborador/colaborador.jsf", "Administração de colaboradores"), 
	PROJETO("Projeto", "/admin/projeto/projeto.jsf", "Administração de projetos"), 
	IMPEDIMENTO("Impedimento", "/admin/impedimento/impedimento.jsf", "Administração de impedimentos"); 
	
	BreadcrumbEnum(String name, String url, String tooltip){
		this.name = name;
		this.url = url;
		this.tooltip = tooltip;
	}
	
	private String name;
	private String url;
	private String tooltip;
	
	public String getName(){
		return this.name;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public String getTooltip(){
		return this.tooltip;
	}

}
