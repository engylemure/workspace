package br.ufes.inf.nemo.javahostel.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.javahostel.domain.Guest;
@Stateless
public class GuestDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Guest findByEmail(String email){
		Guest user = entityManager.createQuery("SELECT u from Guest u WHERE u.email = :email",Guest.class).setParameter("email",email).getSingleResult();
		return user;
	}
	
}
