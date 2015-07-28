package br.com.projeto1.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.projeto1.domain.Produto;

@Local
public interface ProdutoDao {

	public void inserir(Produto p);
	public void alterar(Produto p);
	public void excluir(Produto p);
	public Produto obter(Integer id);
	public List<Produto> listar();
	public Integer sequencial();
	
}
