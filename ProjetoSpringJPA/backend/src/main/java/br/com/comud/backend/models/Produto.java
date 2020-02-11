package br.com.comud.backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
	private int idProduto;

	@Column(name = "linkFoto", length = 1000)
	private String linkFoto;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "detalhes", length = 1000)
	private String detalhes;

	@Column(name = "categoria", length = 20)
	private String categoria;

	@Column(name = "classificacao", length = 20)
	private String classificacao;

	@Column(name = "condicao", length = 20)
	private String condicao;

	@Column(name = "tamanho", length = 5)
	private String tamanho;

	@Column(name = "status", length = 10)
	private String status;

	@ManyToOne
	@JsonIgnoreProperties({"doados", "cedidos", "recebidos", "produtos"})
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cedido")
	@JsonIgnoreProperties({"produtos"})
	private List<Troca> cedidos;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recebido")
	@JsonIgnoreProperties({"produtos"})
	private List<Troca> recebidos;
	
	@OneToMany
	@JsonIgnoreProperties({"doados", "cedidos", "recebidos", "produtos"})
	private List<Doacao> doados;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Troca> getCedidos() {
		return cedidos;
	}

	public void setCedidos(List<Troca> cedidos) {
		this.cedidos = cedidos;
	}

	public List<Troca> getRecebidos() {
		return recebidos;
	}

	public void setRecebidos(List<Troca> recebidos) {
		this.recebidos = recebidos;
	}

}
