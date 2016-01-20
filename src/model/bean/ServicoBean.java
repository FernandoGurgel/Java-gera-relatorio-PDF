package model.bean;

public class ServicoBean {
	
	private int codserv,coduser, codscli,codpro,qtdserv,coditem, tipopg, pg,tiporoow;
	private String produto,nomecli,status;
	private Double valor;
	public ServicoBean(Object Codserv, Object Nomecli, Object Status, Object Valor) {
		this.codserv = (int) Codserv;
		this.nomecli = (String) Nomecli;
		this.status = (String) Status;
		this.valor = (Double) Valor;
	}

	public void ServicoBeanfat(Object Codserv, Object Nomecli, Object formpg, Object Valor) {
		this.codserv = (int) Codserv;
		this.nomecli = (String) Nomecli;
		this.tipopg = (int) formpg;
		this.valor = (Double) Valor;
	}
	
	public ServicoBean(){}
	
	public String getNomecli() {
		return nomecli;
	}
	public void setNomecli(String nomecli) {
		this.nomecli = nomecli;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTiporoow() {
		return tiporoow;
	}
	public void setTiporoow(int tiporoow) {
		this.tiporoow = tiporoow;
	}
	public int getTipopg() {
		return tipopg;
	}
	public void setTipopg(int tipopg) {
		this.tipopg = tipopg;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}	
	public int getQtdserv() {
		return qtdserv;
	}
	public void setQtdserv(int qtdserv) {
		this.qtdserv = qtdserv;
	}
	public int getCodserv() {
		return codserv;
	}
	public void setCodserv(int codserv) {
		this.codserv = codserv;
	}
	public int getCoduser() {
		return coduser;
	}
	public void setCoduser(int coduser) {
		this.coduser = coduser;
	}
	public int getCodscli() {
		return codscli;
	}
	public void setCodscli(int codscli) {
		this.codscli = codscli;
	}
	public int getCodpro() {
		return codpro;
	}
	public void setCodpro(int codpro) {
		this.codpro = codpro;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getCoditem() {
		return coditem;
	}
	public void setCoditem(int coditem) {
		this.coditem = coditem;
	}


}
