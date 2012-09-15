package br.com.bsitecnologia.dashboard.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;

@HandlesExceptions
public class ExceptionHandler {
	
	public void catchConstraintViolationException(@Handles CaughtException<ConstraintViolationException> evt){
		addMessage("Tentativa de criar um registro já existente.", evt.getException().getLocalizedMessage());
		evt.markHandled();
	}
	
	private void addMessage(String summary, String detail){
		FacesMessage fm =  new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

}
