package com.algaworks.erp.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable {

	private static final long serialVersionUID = 1L;

	private void add(String message, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(severity);
		
		context.addMessage(null, msg);
	}
	
	public void info(String message) {
		add(message, FacesMessage.SEVERITY_INFO);
	}
	
	public void error(String message) {
		add(message, FacesMessage.SEVERITY_ERROR);
	}
	
}