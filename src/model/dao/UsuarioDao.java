package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import conexao.Conexao;
import controlador.Usuario;
import model.bean.UsuarioBean;

public class UsuarioDao extends Conexao{

	Connection conn;
	Statement st;
	
	public List<UsuarioBean> listar (UsuarioBean usuario) {
		
		List<UsuarioBean> lista = new ArrayList<>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from usuario";
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(new UsuarioBean(resul.getInt("coduser"),resul.getString("nomeuser"),resul.getString("loginuser")));
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

	public ArrayList<String> selectId(UsuarioBean usuario) {
		
		ArrayList<String> lista = new ArrayList<String>();
		conn = Conexao.getConnection();
		
		try {
			st = conn.createStatement();
			String sql = "Select * from usuario where coduser = "+ usuario.getCoduser();
			ResultSet resul = st.executeQuery(sql);
			
			while(resul.next()){
				lista.add(resul.getString("coduser"));
				lista.add(resul.getString("nomeuser"));
				lista.add(resul.getString("loginuser"));
				lista.add(resul.getString("senhauser"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void update(UsuarioBean usuario) {
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "update usuario set "+
			" nomeuser = '"+usuario.getNomeuser()+"', loginuser ='"+usuario.getLoginuser()+
			"', senhauser = md5('"+usuario.getSenhauser()+"') where coduser="+usuario.getCoduser();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	public void insert(UsuarioBean usuario) {
		// Abrindo conexao e inserindo
		conn = Conexao.getConnection();
		// Criando tabela
		try {
			st = conn.createStatement();
			String sql= "Create table if not exists usuario("+
			"coduser int not null  auto_increment primary key,"+
			"nomeuser varchar(45) not null,"+
			"loginuser varchar(45) not null,"+
			"senhauser varchar(34) not null);";
			
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}finally {
			try {
				st = conn.createStatement();
				String sql = "insert into usuario"+
				"(nomeuser, loginuser, senhauser)"+
				"values ('"+usuario.getNomeuser()+"','"+usuario.getLoginuser()+"',md5('"+usuario.getSenhauser()+"'))";
				st.execute(sql);
				JOptionPane.showMessageDialog(null, "Salvor com sucesso!!!!!!!");
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		
		
	}

	public boolean logar(UsuarioBean usuario) {
		// Compra usuario
		conn = Conexao.getConnection();
		boolean login = false;
		try {
			st = conn.createStatement();
			String sql = "Select * from usuario where senhauser = md5('"+usuario.getSenhauser()+"') and loginuser = '"+usuario.getLoginuser()+"'";
			ResultSet resul = st.executeQuery(sql);
						
			if(resul.next())
				
				login = true;
			
			
						
		}catch (Exception e){
			e.printStackTrace();
		}
		return login;
			
	}

	public void delete(UsuarioBean usuario) {
		
		conn = Conexao.getConnection();
		try {
			st = conn.createStatement();
			String sql = "delete from usuario where coduser="+usuario.getCoduser();
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!!!!!");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public int contLinha(Usuario usuario) {
		
		conn = Conexao.getConnection();
		int cont = 0;
		try {
			st = conn.createStatement();
			String sql = "Select count(*) as c from usuario";
			ResultSet resul = st.executeQuery(sql);
			
			if(resul.next())
				cont = resul.getInt("c");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cont;
	}

	public String[][] listarString(int linha) {
		String[][] lista = new String[linha][3];
		try {
			st = conn.createStatement();
			String sql = "Select * from usuario";
			ResultSet resul = st.executeQuery(sql);
			int i= 0;
			while(resul.next()){
				lista[i][0] = resul.getString("coduser");
				lista[i][1] = resul.getString("nomeuser");
				lista[i][2] = resul.getString("loginuser");
				i++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
