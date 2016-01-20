package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.bean.ClienteBean;
import model.bean.ProdutoBean;
import model.dao.ClienteDao;
import view.roow.GerarPDF;

public class Cliente extends ClienteBean {
	
	ClienteDao dao = new ClienteDao();
	
	//txtnome.getText(),txtsobre.getText(),txtemail.getText(),selectsexo.getSelectedItem(),txtnasc.getText()
	public void salvar(String nome, String sobre, String email, int sexo, String data) {
		this.setNome(nome);
		this.setSobrenome(sobre);
		this.setEmail(email);
		this.setSexo(sexo);
		this.setData(data);
		dao.insert(this);
	}

	public ArrayList<String> especifico(int cod) {
	
		this.setCod(cod);
		return dao.selectId(this);
	}

	public void excluir(int cod) {
		this.setCod(cod);
		dao.delete(this);
	}

	public void alterar(int cod, String nome, String sobre, String email, int sexo, String data) {
		this.setNome(nome);
		this.setSobrenome(sobre);
		this.setEmail(email);
		this.setSexo(sexo);
		this.setData(data);
		this.setData(data);
		dao.update(this);
	}

	public DefaultTableModel listar() {
		List<ClienteBean> lista = dao.listar(this);
		
		// criando caixa de dialogo com tabela 
		String[] coluna = {"Id", "Nome","Sobrenome", "Login"};
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		
		// populando tabela
		for(ClienteBean teste : lista){
			modelo.addRow(new Object[]{teste.getCod(),teste.getNome(),teste.getSobrenome(),teste.getEmail()});
		}
		return modelo;
		
	}

	public void geraPDF() throws IOException {
		GerarPDF pdf = new GerarPDF();
		String arquivo = "Cliente";
		String[] coluna = {"Cod", "Nome Cliente", "email"};
		List<ClienteBean> lista = dao.listar(this);
		DefaultTableModel modelo = new DefaultTableModel(coluna, 0);
		for(ClienteBean resul : lista){
			modelo.addRow(new Object[]{resul.getCod(),resul.getNome(),resul.getEmail()});
			
		}
		pdf.GerarRelPdf(coluna, modelo, arquivo);
	}

}
