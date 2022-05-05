package com.generation.lojaGames.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class ProdutosModel {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
	private long id;
    @NotNull
    private String descricao;
    @OneToMany (mappedBy = "produtos" , cascade = cascadeType.ALL)
    @JsonIgnoreProperties("produtos")
    private java.util.List<Categoria>categoria;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public java.util.List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(java.util.List<Categoria> categoria) {
		this.categoria = categoria;
	}
    
}