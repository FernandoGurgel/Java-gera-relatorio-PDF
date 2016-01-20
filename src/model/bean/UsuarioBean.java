package model.bean;

public class UsuarioBean {
	
	private String nomeuser;
	private int coduser;
	private String loginuser;
	private String senhauser;
	private boolean sessao;
	
	
	public UsuarioBean(){
		
	}
	public UsuarioBean(int cod, String nome, String login) {
		this.nomeuser = nome;
		this.coduser = cod;
		this.loginuser = login;
	}
	public boolean isSessao() {
		return sessao;
	}
	public void setSessao(boolean sessao) {
		this.sessao = sessao;
	}
	public String getNomeuser() {
		return nomeuser;
	}
	public void setNomeuser(String nomeuser) {
		this.nomeuser = nomeuser;
	}
	public int getCoduser() {
		return coduser;
	}
	public void setCoduser(int coduser) {
		this.coduser = coduser;
	}
	public String getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}
	public String getSenhauser() {
		return senhauser;
	}
	public void setSenhauser(String senhauser) {
		this.senhauser = senhauser;
	}
	
}
