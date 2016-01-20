package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bean.ProdutoBean;
import model.bean.ServicoBean;
import model.dao.ProdutoDao;
import view.roow.GerarPDF;

public class Produto extends ProdutoBean{

	ProdutoDao dao = new ProdutoDao();
	
	public ArrayList<String> especifico(int cod) {
		this.setCod(cod);
		return dao.selectId(this);
	}

	public void salvar(String produto, double valor) {
		this.setProduto(produto);
		this.setValor(valor);
		dao.insert(this);
		
	}

	public void excluir(int cod) {
		this.setCod(cod);
		dao.delete(this);
		
	}

	public void alterar(int cod, String produto, double valor) {
		this.setCod(cod);
		this.setProduto(produto);
		this.setValor(valor);
		dao.update(this);
		
	}

	public DefaultTableModel listar() {
		List<ProdutoBean> lista = dao.listar(this);
		
		String[] coluna = {"Cod. produto","Produto", "Valor"};
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		
		// populando tabela
		for(ProdutoBean teste : lista){
			modelo.addRow(new Object[]{teste.getCod(),teste.getProduto(),teste.getValor()});
		}
		return modelo;
	}
	public void geraPDF() throws IOException {
		GerarPDF pdf = new GerarPDF();
		String arquivo = "Usuario";
		String[] coluna = {"Cod", "Nome Servico", "Valor"};
		List<ProdutoBean> lista = dao.listar(this);
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);
		for(ProdutoBean resul : lista){
			modelo.addRow(new Object[]{resul.getCod(),resul.getProduto(),resul.getValor()});
			
		}
		pdf.GerarRelPdf(coluna, modelo, arquivo);
	}

}
