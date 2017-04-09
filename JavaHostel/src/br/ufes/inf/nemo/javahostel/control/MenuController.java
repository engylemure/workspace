package br.ufes.inf.nemo.javahostel.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import br.ufes.inf.nemo.javahostel.application.LoginService;
import br.ufes.inf.nemo.javahostel.domain.Guest;

@Named @SessionScoped
public class MenuController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private LoginService loginservice;
	
	private Guest guest;
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String login(){
			try{
				guest = loginservice.login(guest);
			}catch( EntityNotFoundException a ){
				return "/menu/loginexception.xhtml"; 
			}
			if(guest == null) return "/menu/loginexception.xhtml";
			else return "/menu/sucess.xhtml";
	}
}
