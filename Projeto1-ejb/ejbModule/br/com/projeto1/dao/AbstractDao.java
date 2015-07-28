package br.com.projeto1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractDao<T> {

	@PersistenceContext(unitName="Projeto1-ejb")
	private EntityManager em;
	
	private Class<T> entity;

	public AbstractDao(Class<T> entity) {
		this.entity = entity;
	}
	
	public void inserir(T obj){
		em.persist(obj);
	}
	public void alterar(T obj){
		em.persist(obj);
	}
	public void excluir(T obj){
		em.persist(obj);
	}
	public T obter(Integer id){
		return em.find(entity, id);
	}
	public List<T> listar(){
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entity));
		return em.createQuery(cq).getResultList();
	}
	
	
	
	
}
