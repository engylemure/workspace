package br.ufes.inf.nemo.javahostel.application;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.javahostel.domain.Guest;

@Stateless @LocalBean
public class LoginService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;
	
	public Guest login(Guest guest){
		long a = 1;
		return entityManager.find(Guest.class,a);		
	}
}
