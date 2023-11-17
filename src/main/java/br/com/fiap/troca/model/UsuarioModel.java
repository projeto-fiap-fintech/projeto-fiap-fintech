package br.com.fiap.troca.model;

public class UsuarioModel {
	
    private int usuarioId;
    
    private String nome;
    
    private String email;
    
    private String senha;
    
    private String regra;
    

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int usuarioId, String nome, String email, String regra) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.email = email;
		this.regra = regra;
	}

	
	public UsuarioModel(int usuarioId, String nome, String email, String senha, String regra) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.regra = regra;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	@Override
	public String toString() {
		return "UsuarioModel [usuarioId=" + usuarioId + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", regra=" + regra + "]";
	}
    
    
    
    
    
}

