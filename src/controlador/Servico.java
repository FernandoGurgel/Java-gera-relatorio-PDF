package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.bean.ServicoBean;
import model.dao.ServicoDao;
import view.roow.GerarPDF;

public class Servico extends ServicoBean{

	ServicoDao dao = new ServicoDao();

	public void salvar(int codcli, int coduser) {
		this.setCodscli(codcli);
		this.setTiporoow(1);
		this.setCoduser(coduser);
		dao.geraRoow(this);
	}

	public void insertitem(int qtd, int codpro, int codserv) {
		this.setCodpro(codpro);
		this.setQtdserv(qtd);
		this.setCodserv(codserv);
		dao.insertiItem(this);
		
	}

	public void finalizar(int codcli, int coduser, int tipopg, int pg) {
		this.setCodscli(codcli);
		this.setCoduser(coduser);
		this.setTipopg(tipopg);
		this.setPg(pg);
		this.setTiporoow(2);
		dao.geraRoow(this);
		dao.geraPagamento(this);
		
	}

	public DefaultTableModel listar() {
		List<ServicoBean> lista = dao.listar(this);
		
		// criando caixa de dialogo com tabela 
		String[] coluna = {"Nº Roow", "Nome Cliente", "Status", "Total"};
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		
		// populando tabela
		for(ServicoBean teste : lista){
			modelo.addRow(new Object[]{teste.getCodserv(),teste.getNomecli(),teste.getStatus(),teste.getValor()});
			
		}
		return modelo;
	}

	public int listarCont() {
		int cont = dao.numeroRoow();
		return cont + 1;
	}

	public void excluir(int  valor) {
		int valor1 = valor; 
		this.setCodserv(valor1);
		dao.excluir(this);
	}

	public void geraPDF() throws IOException {
		GerarPDF pdf = new GerarPDF();
		String arquivo = "Usuario";
		String[] coluna = {"Nº Roow", "Nome Cliente", "Status", "Total"};
		List<ServicoBean> lista = dao.listar(this);
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);
		for(ServicoBean teste : lista){
			modelo.addRow(new Object[]{teste.getCodserv(),teste.getNomecli(),teste.getStatus(),teste.getValor()});
			
		}
		pdf.GerarRelPdf(coluna, modelo, arquivo);
	}

	public void geraPDFfau() throws IOException {
		GerarPDF pdf = new GerarPDF();
		String arquivo = "faturamento";
		String[] coluna = {"Nº Pedido", "Nome Cliente", "Tipo Pagamento","Total"};
		List<ServicoBean> lista = dao.listarfat(this);
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);
		for(ServicoBean teste : lista){
			modelo.addRow(new Object[]{teste.getCodserv(),teste.getNomecli(),teste.getStatus(),teste.getValor()});
			
		}
		pdf.GerarRelPdf(coluna, modelo, arquivo);
	}

	
}
