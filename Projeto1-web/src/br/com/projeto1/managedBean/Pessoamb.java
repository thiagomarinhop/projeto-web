package br.com.projeto1.managedBean;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.projeto1.dao.PessoaDao;
import br.com.projeto1.domain.Pessoa;

@ManagedBean
@SessionScoped
public class Pessoamb {
	
	@EJB
	private PessoaDao pdao;

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	
	
	
	public Pessoamb() {
		pessoa = new Pessoa();
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public String autenticar(){
		String page = null;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(pdao.isAutenticado(pessoa))
				page="principal";
						
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Falha",  "Login invalido"
					+ "! "+pessoa.toString()) );
			page= "index";
		}
		
		return page;
	}
	
	public String logoff(){
		pessoa=new Pessoa();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("Pessoamb"); 
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Pessoamb", new Pessoamb()); 
		return "index";
	}
	
	
}
