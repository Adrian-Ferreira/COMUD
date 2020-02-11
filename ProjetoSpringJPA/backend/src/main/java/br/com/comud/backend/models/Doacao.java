package br.com.comud.backend.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "doar")
public class Doacao {
	
	@Id
	@Column(name="iddoacao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddoacao;
	
	@Column(name="dataD", length = 10)
	private String dataD;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("doacoes")
	private Ong ong;
	
	@ManyToOne
	@JsonIgnoreProperties({"usuario", "cedidos", "recebidos"})
	private Produto produto;

	public int getIddoacao() {
		return iddoacao;
	}

	public void setIddoacao(int iddoacao) {
		this.iddoacao = iddoacao;
	}

	public String getDataD() {
		return dataD;
	}

	public void setDataD(String dataD) {
		this.dataD = dataD;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
