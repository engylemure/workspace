package br.ufes.inf.nemo.javahostel.application;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public Guest login(Guest guest,Guest user){
		try{
			user = entityManager.createQuery("SELECT u from Guest u WHERE u.email = :email",Guest.class).setParameter("email",guest.getEmail()).getSingleResult();
		}catch(NoResultException e){
			user = new Guest();
		}
		
		System.out.println("Usuario:"+user.getName()+", Email: "+user.getEmail()+", Pwd: "+user.getPassword());
		return user;
	}
}
