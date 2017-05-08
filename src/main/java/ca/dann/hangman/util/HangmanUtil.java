package ca.dann.hangman.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class HangmanUtil {

	public static void addSucessMsg(String message) {
		// TODO Auto-generated method stub
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		FacesContext context= FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
	public static void addErrorMsg(String message){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,message);
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null,msg);
	
	}
}
