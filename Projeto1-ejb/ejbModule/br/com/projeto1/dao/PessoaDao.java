package br.com.projeto1.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.projeto1.domain.Pessoa;

@Local
public interface PessoaDao {

	public void inserir(Pessoa p);
	public void alterar(Pessoa p);
	public void excluir(Pessoa p);
	public Pessoa obter(Integer id);
	public List<Pessoa> listar();
	public boolean isAutenticado(Pessoa p);
}
