package br.com.projeto1.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projeto1.domain.Pessoa;

/**
 * Session Bean implementation class PessoaDaoImpl
 */
@Stateless
@LocalBean
public class PessoaDaoImpl extends AbstractDao<Pessoa> implements PessoaDao {

	@PersistenceContext(name="")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PessoaDaoImpl() {
    	super(Pessoa.class);
    }
    
    public boolean isAutenticado(Pessoa p){
    	Pessoa pes = (Pessoa) em.createNamedQuery("Pessoa.autenticacao")
    			.setParameter("usuario", p.getUsuario())
    			.setParameter("senha", p.getSenha()).getSingleResult();
    	if(pes.getUsuario().isEmpty())
    	    return false;
    	else
    		return true;
    }

}
