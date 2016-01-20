package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
import model.bean.ServicoBean;
import model.bean.UsuarioBean;

public class ServicoDao extends Conexao{

	
	Connection conn;
	Statement st;
	
	public void insertiItem(ServicoBean servico) {
		
		conn = Conexao.getConnection();
		// Criando tabela
		try {
			st = conn.createStatement();
			String sql = "insert into ItemSevico (codroowcod,codprocod,qtditem)"+
			"values("+servico.getCodserv()+","+servico.getCodpro()+","+servico.getQtdserv()+")";
			st.execute(sql);
			System.out.println("Salvor com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
			
	}

	public void geraRoow(ServicoBean servico) {
		
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "insert into RealizaRoow"+
			"(Status, dtLancamentoRoow, codclicod, codusercod)"+
			"values ("+servico.getTiporoow()+",now(),"+servico.getCodscli()+","+servico.getCodserv()+")";
			st.execute(sql);
			
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	
	@SuppressWarnings("finally")
	public int numeroRoow() {
		conn = Conexao.getConnection();
		int cont = 0;
		try {
			st = conn.createStatement();
			
			String sql ="CREATE TABLE IF NOT EXISTS ItemSevico ("
					  +"coditem INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					  +"qtditem INT ,"
					  +"codprocod INT ,"
					  +"codroowcod int)";
			st.executeUpdate(sql);
		
			sql= "CREATE TABLE IF NOT EXISTS RealizaRoow ("
				 +"codroow INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				 +"codclicod INT ,"
				 +"codusercod INT ,"
				 +"coditemcod INT ,"
				 +"Status ENUM('O','P','C') NOT NULL DEFAULT 'O',"
				 +"dtLancamentoRoow DATETIME);";
			st.executeUpdate(sql);
			
			sql= "CREATE TABLE IF NOT EXISTS pagamento ("
					 +"codpg INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					 +"formapg ENUM('D','CC','CD') NOT NULL DEFAULT 'D',"
					 +"codroowcod int,"
					 +"confpg ENUM('P','N') NOT NULL DEFAULT 'P')";
			st.executeUpdate(sql);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}finally {	
			
			try {
				st = conn.createStatement();
				String sql = "Select count(*) as c from RealizaRoow";
				ResultSet resul = st.executeQuery(sql);
				if (resul.next()){
					cont = resul.getInt(1);
				}
				st.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
			return cont;
		}
	}

	public void geraPagamento(ServicoBean servico) {
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "insert into pagamento"+
			"(formapg, confpg, codroowcod)"+
			"values ("+servico.getTipopg()+","+servico.getPg()+","+servico.getCodserv()+")";
			st.execute(sql);
			
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public List<ServicoBean> listar(ServicoBean servico) {
		List<ServicoBean> lista = new ArrayList<>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "select codroow,nomecliente,Status,valorpro*qtditem from RealizaRoow "+
			" inner join cliente on RealizaRoow.codclicod = cliente.codcliente"+
			" inner join ItemSevico on RealizaRoow.codroow = ItemSevico.codroowcod"+
			" inner join produto on ItemSevico.codprocod = produto.codpro where Status = 1 or Status = 2;";
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(new ServicoBean(resul.getInt("codroow"),resul.getString("nomecliente"),resul.getString("Status"),resul.getDouble("valorpro*qtditem")));
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
		return null;
	}

	public void excluir(ServicoBean servico) {
		
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "update RealizaRoow set "+
			"Status = 3 where codroow = "+servico.getCodserv();
			st.execute(sql);
		
				JOptionPane.showMessageDialog(null, "Servico excluido!!");
			
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public String lista2() {
		conn = Conexao.getConnection();
		
		String lista="";
		try {
			st = conn.createStatement();
			String sql = "select codroow,nomecliente,Status,valorpro*qtditem from RealizaRoow "+
					" inner join cliente on RealizaRoow.codclicod = cliente.codcliente"+
					" inner join ItemSevico on RealizaRoow.codroow = ItemSevico.codroowcod"+
					" inner join produto on ItemSevico.codprocod = produto.codpro where Status = 1 or Status = 2;";
			ResultSet resul = st.executeQuery(sql);
			while (resul.next()){
				
			}
			if(lista == "")
				lista = "Nao ha registro";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;	
	}

	public List<ServicoBean> listarfat(ServicoBean servico) {
conn = Conexao.getConnection();
		List<ServicoBean> lista = new ArrayList<>();
		
		try {
			st = conn.createStatement();
			String sql = "select codroow,nomecliente,formapg,valorpro*qtditem from RealizaRoow "+
			"inner join cliente on RealizaRoow.codclicod = cliente.codcliente "+
			"inner join ItemSevico on RealizaRoow.codroow = ItemSevico.codroowcod "+
			"inner join pagamento on RealizaRoow.codroow = pagamento.codroowcod "+
			"inner join produto on ItemSevico.codprocod = produto.codpro where confpg = 1;";
			ResultSet resul = st.executeQuery(sql);
			while (resul.next()){
				lista.add(new ServicoBean(resul.getInt("codroow"),resul.getString("nomecliente"),resul.getString("formapg"),resul.getDouble("valorpro*qtditem")));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lista;
	}
}
	
