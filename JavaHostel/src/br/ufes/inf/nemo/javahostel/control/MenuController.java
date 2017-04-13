package br.ufes.inf.nemo.javahostel.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

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
	
	private Guest guest = new Guest();
	private Guest user;
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String login(){
			try{
			user = loginservice.login(guest,user);
			}catch(NoResultException e){
				return "/menu/loginexception.xhtml";
			}
			System.out.println(user.getPassword()+" // " +guest.getPassword());
			if(user.getPassword().equals(guest.getPassword())) {
				System.out.println("Something is very wrong");
				return "/menu/success.xhtml";
			}
			else {
				System.out.println("Something is very realy wrong");
				return "/menu/pwdincorrect.xhtml";
			}
	}

	public Guest getUser() {
		return user;
	}

	public void setUser(Guest user) {
		this.user = user;
	}
}
