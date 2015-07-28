package br.com.projeto1.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.projeto1.dao.ClienteDao;
import br.com.projeto1.domain.Cliente;

@ManagedBean
@RequestScoped
public class Clientemb {
	
	@EJB
	private ClienteDao cdao;
	
	private Cliente cliente;
	
	private List<Cliente> clientes;

	public Clientemb() {
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public String novo(){
		cliente.setId(cdao.sequencial());
		return "cad_cliente";
	}
	public String adm(){
		clientes = cdao.listar();
		return "adm_cliente";
	}
	
	public String inserir(){
		FacesContext context = FacesContext.getCurrentInstance();
        
		try {
			context.addMessage(null, new FacesMessage("Sucesso",  "Cliente cadastrado! ") );		
			cdao.inserir(cliente);
			cliente = new Cliente();
			System.out.println(cliente.toString());
			return "cad_cliente";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir Cliente, mensagem de erro: "+e.getMessage());
			context.addMessage(null, new FacesMessage("Falha",  "Cliente não cadastrado! ") );
			return "index";
		}
	}

}
