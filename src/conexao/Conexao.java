package conexao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	
    public static Connection getConnection(){
        
    	Connection con = null;
        Statement st;
        String nomeBD = "desafio";
    	
        try {
        	//Criando conexao e banco
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String host = "jdbc:mysql://localhost/?";
            String usuario = "root";
            String senha = "";
            con=DriverManager.getConnection(host,usuario,senha);
            st = con.createStatement();
            st.executeUpdate("create database if not exists desafio");
            //chamando banco
            String url = "jdbc:mysql://localhost/"+nomeBD;
            con=DriverManager.getConnection(url,usuario,senha);
            
            
            st.close();
            
            System.out.println("Conectado");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nao conectado");
        }
        
        return con;
    }
}
