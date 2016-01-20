package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
import model.bean.ProdutoBean;

public class ProdutoDao extends Conexao{

	Connection conn;
	Statement st;
	
	public ArrayList<String> selectId(ProdutoBean produto) {
		ArrayList<String> lista = new ArrayList<String>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from produto where codpro = "+ produto.getCod();
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(resul.getString("codpro"));
				lista.add(resul.getString("nomepro"));
				lista.add(resul.getString("valorpro"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void insert(ProdutoBean produto) {

		conn = Conexao.getConnection();
		// Criando tabela
		try {
			st = conn.createStatement();
			String sql= "Create table if not exists produto("+
			"codpro int not null auto_increment primary key,"+
			"nomepro varchar(45) not null,"+
			"valorpro decimal not null)";
			
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}finally {
			try {
				st = conn.createStatement();
				String sql = "insert into produto"+
				"(nomepro, valorpro)"+
				"values ('"+produto.getProduto()+"',"+produto.getValor()+")";
				st.execute(sql);
				JOptionPane.showMessageDialog(null, "Salvor com sucesso!!!!!!!");
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
	}

	public void delete(ProdutoBean produto) {
		
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "delete from produto where codpro="+produto.getCod();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void update(ProdutoBean produto) {
		
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "update produto set "+
			" nomepro = '"+produto.getProduto()+"', valorpro ="+produto.getValor()+
			" where codpro="+produto.getCod();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	public List<ProdutoBean> listar(ProdutoBean produto) {
		
		List<ProdutoBean> lista = new ArrayList<>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from produto";
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(new ProdutoBean(resul.getInt("codpro"),resul.getString("nomepro"),resul.getDouble("valorpro")));
			}
			st.close();
			if(lista.isEmpty()){
				JOptionPane.showMessageDialog(null, "Não há registro!");
			}
			else{
				//System.out.println();
				return lista;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}

}
