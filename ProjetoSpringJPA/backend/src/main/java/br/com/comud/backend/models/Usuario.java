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
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private int idUsuario;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "email", length = 30, unique=true)
	private String email;

	@Column(name = "telefone", length = 11)
	private String telefone;

	@Column(name = "endereco", length = 150)
	private String endereco;

	@Column(name = "senha", length = 20)
	private String senha;

	@JsonIgnoreProperties({"doados", "cedidos", "recebidos", "usuario"})
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Produto> produtos;

	@JsonIgnoreProperties("remetente")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "remetente")
	private List<Troca> remetentes;

	@JsonIgnoreProperties("destinatario")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destinatario")
	private List<Troca> destinatarios;

	@JsonIgnoreProperties("usuario")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Doacao> doacoes;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return idUsuario+":"+nome+":"+email;
	}

}
