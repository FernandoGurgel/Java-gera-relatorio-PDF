package view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Usuario;

public class Principal extends Loga  implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	Loga loga = new Loga();
	
	JFrame tela = new JFrame("Manutenção usuario");
	
	JLabel lbcod = new JLabel("Cod.:"),
			lbnome = new JLabel("Nome:"),
			lblogin = new JLabel("Login:"),
			lbsenha = new JLabel("senha:");
	
	JTextField	txtcod = new JTextField(), 
			txtnome =new JTextField(),
			txtlogin= new JTextField(),
			txtsenha = new JPasswordField();
	
	JButton btnSalvar = new JButton("Salvar"),
			btnlocalizar = new JButton("Buscar"),
			btnlistar = new JButton("Listar"),
			btnexcluir = new JButton("Excluir"),
			btnsair = new JButton("Sair");
	
	public void criaTela(){
		
		setLayout(null);
		add(lbcod);
		add(txtcod);
		add(btnlocalizar);
		add(btnlistar);
		add(lbnome);
		add(lblogin);
		add(lbsenha);
		add(txtlogin);
		add(txtnome);
		add(txtsenha);
		add(btnSalvar);
		add(btnsair);
		tela.add(this);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
		tela.setBounds(30, 40, 250, 240);
		//cod
		lbcod.setBounds(20, 15, 60, 20);
		txtcod.setBounds(90, 12, 40, 25);
		btnlocalizar.setBounds(140, 10, 90, 30);
		//Nome
		lbnome.setBounds(20, 45, 60, 20);
		txtnome.setBounds(90, 42, 140, 25);
		//Login
		lblogin.setBounds(20, 75, 60, 20);
		txtlogin.setBounds(90, 72, 140, 25);
		//senha
		lbsenha.setBounds(20, 105, 60, 20);
		txtsenha.setBounds(90, 102, 140, 25);
		//botoes
		btnSalvar.setBounds(20, 150, 80, 35);
		btnSalvar.setVisible(false);
		btnlistar.setBounds(20, 150, 80, 35);
		btnlistar.setVisible(true);
		btnsair.setBounds(130, 150, 100, 35);
		btnsair.setVisible(true);
		btnexcluir.setBounds(130, 150, 100, 35);
		btnexcluir.setVisible(false);
		add(btnexcluir);
		//action listener
		btnexcluir.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnsair.addActionListener(this);
		btnlistar.addActionListener(this);
		btnlocalizar.addActionListener(this);
		btnsair.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnsair)){
			tela.dispose();
			
		}
		else if(e.getSource().equals(btnlistar)){
			
			usuario.listar();
		}
		else if (e.getSource() == btnlocalizar){
			
			if (txtcod.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Campos Vazios!");
			}
			else{
				
				
				ArrayList<String> listar = new ArrayList<String>();
				listar = usuario.especifico(Integer.parseInt(txtcod.getText()));
				if(listar.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não encontrado");				
				}else{
					txtnome.setText(listar.get(1));
					txtlogin.setText(listar.get(2));
					txtsenha.setText(listar.get(3));
					btnSalvar.setVisible(true);
					btnlistar.setVisible(false);
					btnsair.setVisible(false);
					btnexcluir.setVisible(true);
				}
				
			}
			
		}
		else if(e.getSource().equals(btnexcluir)){
			
			usuario.excluir(Integer.parseInt(txtcod.getText()));
			btnSalvar.setVisible(false);
			btnlistar.setVisible(true);
			btnsair.setVisible(true);
			btnexcluir.setVisible(false);
			txtnome.setText("");
			txtlogin.setText("");
			txtsenha.setText("");
			txtcod.setText("");
			
			
		}
		
		else if(e.getSource() == btnSalvar){
			
			usuario.alterar(txtnome.getText(),txtlogin.getText(),txtsenha.getText(),Integer.parseInt(txtcod.getText()));
			btnSalvar.setVisible(false);
			btnlistar.setVisible(true);
			btnsair.setVisible(true);
			btnexcluir.setVisible(false);
			txtnome.setText("");
			txtlogin.setText("");
			txtsenha.setText("");
			txtcod.setText("");
		}
		
		
	}

}
