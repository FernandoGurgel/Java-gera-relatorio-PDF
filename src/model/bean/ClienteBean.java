package model.bean;

public class ClienteBean {

	private String nome;
	private String sobrenome;
	private int sexo;
	private String email;
	private String data;
	private int cod;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public ClienteBean(int cod,String nome, String sobrenome, String email) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cod = cod;
	}
	
	public ClienteBean(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
