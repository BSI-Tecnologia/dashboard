package br.com.bsitecnologia.dashboard.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bsitecnologia.dashboard.model.Usuario;
import br.com.bsitecnologia.dashboard.resources.qualifiers.UsuarioLogado;

@SessionScoped
@Named
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1540160644128909016L;

	@Inject
	@New
	private Usuario usuario;
	
	public String login() {
		return "/admin/cargo/cargo?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@SessionScoped
	@Produces
	@UsuarioLogado
	@Named("usuarioLogado")
	public Usuario getUsuarioLogado(){
		return usuario;
	}
	
}
