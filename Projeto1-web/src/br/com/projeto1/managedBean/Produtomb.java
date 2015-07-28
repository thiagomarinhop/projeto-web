package br.com.projeto1.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.projeto1.dao.ProdutoDao;
import br.com.projeto1.domain.Produto;

@ManagedBean
@RequestScoped
public class Produtomb {

	@EJB
	private ProdutoDao pdao;
	
	private Produto produto;
	
	private List<Produto> produtos;

	public Produtomb() {
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String novo(){
		produto.setId(pdao.sequencial());
		return "cad_produto";
	}
	
	public String adm(){
		produtos = pdao.listar();
		return "adm_produto";
	}
	
	public String inserir(){
		try {
			pdao.inserir(produto);
			return "principal";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir o produto, mensagem de erro: "+e.getMessage() );
			return "index";
		}
		
	}
	
 	
}
