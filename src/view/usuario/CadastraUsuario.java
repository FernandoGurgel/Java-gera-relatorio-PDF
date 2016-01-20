package view.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.Usuario;

public class CadastraUsuario extends JPanel  implements ActionListener {

	private static final long serialVersionUID = 1L;

	Usuario usuario = new Usuario();
	
	JFrame tela = new JFrame("Cadastro Usuario");
	
	JLabel lbnome = new JLabel("Nome:"),
			lblogin = new JLabel("Login:"),
			lbsenha = new JLabel("senha:");
	
	JTextField txtnome =new JTextField(),
			txtlogin= new JTextField(),
			txtsenha = new JPasswordField();
	
	JButton btnSalvar = new JButton("Salvar"),
			btnsair = new JButton("Cancelar");
	
	public void criaTela(){
				
		setLayout(null);
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
		//Nome
		lbnome.setBounds(20, 15, 60, 20);
		txtnome.setBounds(90, 12, 140, 25);
		//Login
		lblogin.setBounds(20, 55, 60, 20);
		txtlogin.setBounds(90, 52, 140, 25);
		//senha
		lbsenha.setBounds(20, 95, 60, 20);
		txtsenha.setBounds(90, 92, 140, 25);
		//botoes
		btnSalvar.setBounds(20, 150, 80, 35);
		btnsair.setBounds(130, 150, 100, 35);
		btnsair.addActionListener(this);
		btnSalvar.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsair){
			tela.dispose();
		}
		else if (e.getSource() == btnSalvar){
			usuario.salvar(txtnome.getText(),txtlogin.getText(),txtsenha.getText());
		}
	}

}
