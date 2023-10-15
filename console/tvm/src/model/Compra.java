package model;


public class Compra {

	private Integer idCompra;
	private Integer idCliente;
	private Integer idPassagem;
	private String formaPgto;
	private Float valorTotal;


	public Compra() {
	}

	public Compra(Integer idCliente, Integer idPassagem, String formaPgto, Float valorTotal) {
		this.idCliente = idCliente;
		this.idPassagem = idPassagem;
		this.formaPgto = formaPgto;
		this.valorTotal = valorTotal;
	}
	
	public Compra(Integer idCompra, Integer idCliente, Integer idPassagem, String formaPgto, Float valorTotal) {
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.idPassagem = idPassagem;
		this.formaPgto = formaPgto;
		this.valorTotal = valorTotal;
	}

	public Integer getIdPassagem() {
		return this.idPassagem;
	}

	public void setIdPassagem(Integer idPassagem) {
		this.idPassagem = idPassagem;
	}

	public Float getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getFormaPgto() {
		return this.formaPgto;
	}

	public void setFormaPgto(String formaPgto) {
		this.formaPgto = formaPgto;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	//toString
  	@Override
  	public String toString() {
  		return "Compra [idCompra="+ idCompra + ", idCliente=" + idCliente + ", idPassagem=" + idPassagem + ", formaPgto=" + formaPgto + ", valorTotal=" + valorTotal+"]";
  	}

}
