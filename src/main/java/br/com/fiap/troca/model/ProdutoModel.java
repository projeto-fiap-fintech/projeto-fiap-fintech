package br.com.fiap.troca.model;

import java.util.Date;

public class ProdutoModel {
	
    private int produtoId;
    
    private String nome;
    
    private String urlImagem;
    
    private boolean disponivel;
    
    private String descricao;
    
    private String sugestaoTroca;
    
    private double valor;
    
    private Date dataCadastro = new Date();
    
    private Date dataExpiracao;
    
    private int usuarioId;
    
    private CategoriaModel categoria;
    
    
	public ProdutoModel() {
		super();
	}
	
	
	public ProdutoModel(int produtoId, String nome, String urlImagem, boolean disponivel, String descricao, String sugestaoTroca,
			double valor, Date dataCadastro, Date dataExpiracao, int usuarioId) {
		super();
		this.produtoId = produtoId;
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.disponivel = disponivel;
		this.descricao = descricao;
		this.sugestaoTroca = sugestaoTroca;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.dataExpiracao = dataExpiracao;
		this.usuarioId = usuarioId;
	}
	
	public ProdutoModel(int produtoId, String nome, String urlImagem, boolean disponivel, String descricao,
			String sugestaoTroca, double valor, Date dataCadastro, Date dataExpiracao, int usuarioId,
			CategoriaModel categoria) {
		super();
		this.produtoId = produtoId;
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.disponivel = disponivel;
		this.descricao = descricao;
		this.sugestaoTroca = sugestaoTroca;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.dataExpiracao = dataExpiracao;
		this.usuarioId = usuarioId;
		this.categoria = categoria;
	}


	public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSugestaoTroca() {
		return sugestaoTroca;
	}

	public void setSugestaoTroca(String sugestaoTroca) {
		this.sugestaoTroca = sugestaoTroca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}


	public String getUrlImagem() {
		return urlImagem;
	}


	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}


	public CategoriaModel getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "ProdutoModel [produtoId=" + produtoId + ", nome=" + nome + ", urlImagem=" + urlImagem + ", disponivel="
				+ disponivel + ", descricao=" + descricao + ", sugestaoTroca=" + sugestaoTroca + ", valor=" + valor
				+ ", dataCadastro=" + dataCadastro + ", dataExpiracao=" + dataExpiracao + ", usuarioId=" + usuarioId
				+ ", categoria=" + categoria + "]";
	}

	
}

