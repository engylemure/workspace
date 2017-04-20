package br.ufes.inf.nemo.javahostel.control;

import java.io.Serializable;

import javax.ejb.*;
import javax.enterprise.context.*;
import javax.inject.*;

import br.ufes.inf.nemo.javahostel.application.*;
import br.ufes.inf.nemo.javahostel.domain.*;
@Named @SessionScoped
public class RoomRegistrationController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private RoomRegistrationService rregistrationService;
	
	private Room room = new Room();

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	public String start(){
		return "/rregistration/index.xhtml";
	}
	public String register(){
			try{
				rregistrationService.register(room);
			}catch(Exception e){
				System.out.println(e.getMessage());
				return "/rregistration/error.xhtml";
			}
			return "/rregistration/success.xhtml";
	}

}
