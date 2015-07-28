package br.com.projeto1.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projeto1.domain.Cliente;

/**
 * Session Bean implementation class ClienteDaoImpl
 */
@Stateless
@LocalBean
public class ClienteDaoImpl extends AbstractDao<Cliente> implements ClienteDao {

	@PersistenceContext(name="")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ClienteDaoImpl() {
    	super(Cliente.class);
    }

	@Override
	public Integer sequencial() {
		Integer seq  = (Integer) em.createNamedQuery("Cliente.sequencial").getSingleResult();
		return seq;
	}
    
    

}
