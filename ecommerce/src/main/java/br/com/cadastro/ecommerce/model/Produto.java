package br.com.cadastro.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name="PRODUTOS_TABLE")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@NotBlank
	private String nome;
	
	@Lob
	private String descricao;
	private String urlimg;
	private float preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
