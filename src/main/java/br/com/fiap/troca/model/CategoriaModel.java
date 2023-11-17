package br.com.fiap.troca.model;

public class CategoriaModel {

	private int idCategoria;
	
	private String nomeCategoria;
	
	private String descricaoCategoria;

	public CategoriaModel() {
		super();
	}

	public CategoriaModel(int idCategoria, String nomeCategoria, String descricaoCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria
				+ ", descricaoCategoria=" + descricaoCategoria + "]";
	}
	
	
	
	
}

