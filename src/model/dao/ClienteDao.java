package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
import model.bean.ClienteBean;

public class ClienteDao extends Conexao{

	Connection conn;
	Statement st;
	
	public ArrayList<String> selectId (ClienteBean cliente) {
		
		ArrayList<String> lista = new ArrayList<String>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from cliente where codcliente = "+ cliente.getCod();
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(resul.getString("codcliente"));
				lista.add(resul.getString("nomecliente"));
				lista.add(resul.getString("sobrecliente"));
				lista.add(resul.getString("emailcliente"));
				lista.add(resul.getString("datacliente"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void insert(ClienteBean cliente) {
		//String nome, String sobre, String email, int sexo, String data
		conn = Conexao.getConnection();
		// Criando tabela
		try {
			st = conn.createStatement();
			String sql= "Create table if not exists cliente("+
			"codcliente int not null primary key auto_increment,"+
			"nomecliente varchar(45) not null,"+
			"sobrecliente varchar(45) not null,"+
			"emailcliente varchar(45) not null,"+
			"datacliente varchar(45) not null)";
			
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}finally {
			try {
				st = conn.createStatement();
				String sql = "insert into cliente"+
				"(nomecliente, sobrecliente, emailcliente, datacliente)"+
				"values ('"+cliente.getNome()+"','"+cliente.getSobrenome()+"','"+cliente.getEmail()+"','"+cliente.getData()+"')";
				st.execute(sql);
				JOptionPane.showMessageDialog(null, "Salvor com sucesso!!!!!!!");
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		
	}


	public void delete(ClienteBean cliente) {
		
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "delete from cliente where codcliente="+cliente.getCod();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}


	public void update(ClienteBean cliente) {
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "update cliente set "+
			" nomecliente = '"+cliente.getNome()+"', sobrecliente ='"+cliente.getSobrenome()+
			"', emailcliente ='"+cliente.getEmail()+"', datacliente = '"+cliente.getData()+"' where codcliente="+cliente.getCod();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	
	public List<ClienteBean> listar(ClienteBean cliente) {
		
		List<ClienteBean> lista = new ArrayList<>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from cliente";
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(new ClienteBean(resul.getInt("codcliente"),
						resul.getString("nomecliente"),
						resul.getString("sobrecliente"),
						resul.getString("emailcliente")));
			}
			st.close();
			if(lista.isEmpty()){
				JOptionPane.showMessageDialog(null, "Não há registro!");
			}
			else{
				return lista;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return lista;
	}

	
}
