package br.com.projeto1.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.projeto1.domain.Cliente;


@Local
public interface ClienteDao {
	
	public void inserir(Cliente c);
	public void alterar(Cliente c);
	public void excluir(Cliente c);
	public Cliente obter(Integer id);
	public List<Cliente> listar();
	public Integer sequencial();
	

}
