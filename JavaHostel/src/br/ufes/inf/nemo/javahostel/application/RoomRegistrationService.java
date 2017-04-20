package br.ufes.inf.nemo.javahostel.application;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.javahostel.domain.Guest;
import br.ufes.inf.nemo.javahostel.domain.Room;

@Stateless @LocalBean
public class RoomRegistrationService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;
	
	public void register(Room room) throws Exception{
		
		Room aux = entityManager.createQuery("SELECT u from Room u WHERE u.number = :number",Room.class).setParameter("number",room.getNumber()).getSingleResult();
		if(aux.getId() == null)
			entityManager.merge(room);
		else throw new Exception("Quarto já registrado!");
	}
	
}
