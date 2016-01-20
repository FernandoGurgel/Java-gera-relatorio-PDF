package model.bean;

public class ProdutoBean {

	private int cod;
	private String produto;
	private Double valor;
	
	public ProdutoBean(){}
	
	public ProdutoBean(int cod, String produto, Double valor) {
		super();
		this.cod = cod;
		this.produto = produto;
		this.valor = valor;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public ProdutoBean(String produto, Double valor) {
		super();
		this.produto = produto;
		this.valor = valor;
	}

	public  void produtoBean (){}
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
