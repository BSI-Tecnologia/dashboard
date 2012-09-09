package br.com.bsitecnologia.dashboard.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable{

	private static final long serialVersionUID = 1906091377786784028L;
	
	public void addMessage(Severity severity, String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage fm =  new FacesMessage(severity, summary, detail);
        context.addMessage(null, fm);
        context.renderResponse();
	}

}
