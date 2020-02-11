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
@Table(name = "troca")
public class Troca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtroca")
	private int idTroca;
	
	@Column(name="dataT", length = 100)
	private String dataT;
	
	@ManyToOne
	@JsonIgnoreProperties({"destinatarios","produtos"})
	private Usuario destinatario;
	
	@ManyToOne
	@JsonIgnoreProperties({"remetentes", "produtos"})
	private Usuario remetente;
	
	@ManyToOne
	@JsonIgnoreProperties({"recebidos", "produtos"})
	private Produto recebido;
	
	@ManyToOne
	@JsonIgnoreProperties({"cedidos", "produtos"})
	private Produto cedido;
	

	public int getIdTroca() {
		return idTroca;
	}
	public void setIdTroca(int idTroca) {
		this.idTroca = idTroca;
	}
	
	public String getDataT() {
		return dataT;
	}
	public Produto getRecebido() {
		return recebido;
	}
	public void setRecebido(Produto recebido) {
		this.recebido = recebido;
	}
	public Produto getCedido() {
		return cedido;
	}
	public void setCedido(Produto cedido) {
		this.cedido = cedido;
	}
	
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public void setDataT(String dataT) {
		this.dataT = dataT;
	}

}
