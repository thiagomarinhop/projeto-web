package br.com.projeto1.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projeto1.domain.Produto;

/**
 * Session Bean implementation class ProdutoDaoImpl
 */
@Stateless
@LocalBean
public class ProdutoDaoImpl extends AbstractDao<Produto> implements ProdutoDao {

	
	@PersistenceContext(name="")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProdutoDaoImpl() {
    	super(Produto.class);
    }

	@Override
	public Integer sequencial() {
		Integer seq  = (Integer) em.createNamedQuery("Produto.sequencial").getSingleResult();
		return seq;
	}

}
