package view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controlador.Usuario;

public class Loga extends JPanel implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Usuario usuario = new Usuario();
	
	JFrame telaLoga = new JFrame("Sistema Lavanderia");
	
	JLabel lblogin = new JLabel("Login:"),
			lbsenha = new JLabel("Senha:"),
			lbnovouser = new JLabel("Novo Usuario");
	
	JTextField txtlogin = new JTextField(),
			txtsenha = new JPasswordField();
	
	JButton btnentrar = new JButton("Entrar"),
			btnsair = new JButton("Sair");
	
	public void activa(int i) {
		if (i == 0){
			JOptionPane.showMessageDialog(null, "Fecha FDp");
			telaLogin();
		}
		
	}
	public void telaLogin(){
		telaLoga.setUndecorated(true);
		setBackground(Color.ORANGE);
		setLayout(null);
		add(lblogin);
		add(lbsenha);
		add(lbnovouser);
		add(txtlogin);
		add(txtsenha);
		add(btnentrar);
		add(btnsair);
		btnentrar.addActionListener(this);
		btnsair.addActionListener(this);
		lbnovouser.addMouseListener(this);
		lbnovouser.setFont(new Font("Stilu-Oblique.otf",Font.CENTER_BASELINE, 15));
		telaLoga.setVisible(true);
		telaLoga.setSize(225, 150);
		telaLoga.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width /3) + 150),   
		        ((Toolkit.getDefaultToolkit().getScreenSize().height/3) + 50 )); 
		telaLoga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaLoga.add(this);
		lblogin.setBounds(10, 25, 60, 20);
		txtlogin.setBounds(90, 20, 120, 30);
		lbsenha.setBounds(10, 65, 60, 20);
		txtsenha.setBounds(90, 60, 120, 30);
		btnentrar.setBounds(20, 100, 80, 20);
		btnsair.setBounds(130, 100, 80, 20);
		lbnovouser.setBounds(70, 130, 120, 15);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Evento do controle Botoes
		
		if(e.getSource() == btnentrar){
			telaLoga.dispose();
			usuario.logar(txtlogin.getText(),txtsenha.getText());
		}
		else if (e.getSource() == btnsair){
			telaLoga.dispose();
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// Evento do controle mouse
		
		if(e.getSource() == lbnovouser){
			usuario.irCadastro();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
