package model;

import java.util.Date;

public class Cliente {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private Date dataNasc;
	private String telefone;

	public Cliente() {
	}

	
	public Cliente(Integer idCliente, String nome, String cpf, Date dataNasc, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}


	public Cliente(String nome, String cpf, Date dataNasc, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//toString
	@Override
	public String toString() {
		return "Cliente [id="+ idCliente + ", nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", telefone=" + telefone +"]";
	}

}
