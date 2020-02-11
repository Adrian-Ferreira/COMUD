package br.com.comud.backend.model;

public class produto {
	private int id;
	private String nome;
	private String linkFoto;
	private String detalhes;
	private String categoria = "Selecione";
	private String classificacao = "Selecione";
	private String condicao = "Selecione";
	private String tamanho = "Selecione";
	
	
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
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
	
	@Override
	public String toString() {
		return "produto [nome=" + nome + ", linkFoto=" + linkFoto + ", detalhes=" + detalhes + ", categoria="
				+ categoria + ", classificacao=" + classificacao + ", condicao=" + condicao + ", tamanho=" + tamanho
				+ "]";
	}
	
}
