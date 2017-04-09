package br.ufes.inf.nemo.javahostel.control;

import java.io.Serializable;

import javax.ejb.*;
import javax.enterprise.context.*;
import javax.inject.*;

import br.ufes.inf.nemo.javahostel.application.*;
import br.ufes.inf.nemo.javahostel.domain.*;

@Named @SessionScoped
public class RegistrationController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private RegistrationService registrationService;
	
	private Guest guest = new Guest();
	private int age;
	
	public Guest getGuest() {
		return guest;
	}
	
	public int getAge() {
		return age;
	}
	
	public String register() {
		try {
			registrationService.register(guest);
		}
		catch (UnderAgeException e) {
			age = e.getAge();
			return "/registration/underage.xhtml";
		}
		
		return "/registration/success.xhtml";
	}
}
