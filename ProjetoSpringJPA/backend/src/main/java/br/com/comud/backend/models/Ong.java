package br.com.comud.backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ong")
public class Ong {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idONG")
	private int idONG;
	
	@Column(name="nome", length = 100)
	private String nome;
	
	@Column(name="telefone", length = 11)
	private String telefone;
	
	@Column(name="email", length = 50, unique=true)
	private String email;
	
	@Column(name="descricao", length = 1000)
	private String descricao;
	
	@Column(name="endereco", length = 150)
	private String endereco;
	
	@Column(name="site", length = 1000)
	private String site;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ong")
	@JsonIgnoreProperties({"ong", "doacoes"})
	private List<Doacao> doacoes;
		

	public List<Doacao> getDoacoes() {
		return doacoes;
	}
	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
	public int getIdONG() {
		return idONG;
	}
	public void setIdONG(int idONG) {
		this.idONG = idONG;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}
