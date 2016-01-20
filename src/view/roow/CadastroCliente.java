package view.roow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controlador.Cliente;

public class CadastroCliente extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Cliente cliente = new Cliente();
	
	JFrame tela = new JFrame("Cadastro Usuario");
	
	JLabel lbnome = new JLabel("Nome:"),
			lbsobre = new JLabel("Sobrenome:"),
			lbemail = new JLabel("Email:"),
			lbsexo = new JLabel("Sexo:"),
			lbcod = new JLabel("Cod:"),
			lbnasc = new JLabel("Dt. Nasc.:");
	
	String[] lista = {"Ferminino","Masculino"};
	JComboBox selectsexo = new JComboBox(lista);
	
	JTextField txtnome =new JTextField(),
			txtsobre= new JTextField(),
			txtemail= new JTextField(),
			txtnasc= new JTextField(),
			txtcod= new JTextField();
			
	
	JButton btnSalvar = new JButton("Salvar"),
			btnexcluir = new JButton("Excluir"),
			btnalterar = new JButton("Alterar"),
			btnlocalizar = new JButton("Localizar");
	
	
	public void criaTela(){
				
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
		tela.setSize(280, 280);
		tela.setLocationRelativeTo(null);
						
		//Nome
		lbnome.setBounds(20, 15, 60, 20);
		txtnome.setBounds(110, 12, 150, 25);
		//sobrenome
		lbsobre.setBounds(20, 40, 90, 20);
		txtsobre.setBounds(110, 37, 150, 25);
		//sexo
		lbsexo.setBounds(20, 67, 90, 20);
		selectsexo.setBounds(110, 67, 150, 25);
		//email
		lbemail.setBounds(20, 97, 90, 20);
		txtemail.setBounds(110, 97, 150, 25);
		//data
		lbnasc.setBounds(20, 120, 90, 20);
		txtnasc.setBounds(110, 125, 150, 25);
		//cod
		lbcod.setBounds(20, 150, 90, 20);
		txtcod.setBounds(110, 155, 150, 25);
		
		
		//botoes
		btnSalvar.setBounds(20, 200, 80, 35);
		btnalterar.setBounds(20, 200, 80, 35);
		btnalterar.addActionListener(this);
		btnalterar.setVisible(false);
		
		btnlocalizar.setBounds(160, 200, 100, 35);
		btnlocalizar.addActionListener(this);
		
		btnexcluir.setBounds(160, 200, 100, 35);
		btnexcluir.setVisible(false);
		
		btnexcluir.addActionListener(this);
		btnlocalizar.addActionListener(this);
		btnSalvar.addActionListener(this);
		
		tela.add(btnalterar);
		tela.add(btnexcluir);
		tela.add(lbcod);
		tela.add(txtcod);
		tela.add(btnSalvar);
		tela.add(btnlocalizar);
		tela.add(lbemail);
		tela.add(txtemail);
		tela.add(lbnasc);
		tela.add(txtnasc);
		tela.add(lbsexo);
		tela.add(selectsexo);
		tela.add(lbsobre);
		tela.add(txtsobre);
		tela.add(lbnome);
		tela.add(txtnome);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnlocalizar){
			if (txtcod.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Campos Vazios!");
			}
			else{
				
				ArrayList<String> listar = new ArrayList<String>();
				listar = cliente.especifico(Integer.parseInt(txtcod.getText()));
				if(listar.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não encontrado");				
				}else{
					txtnome.setText(listar.get(1));
					txtsobre.setText(listar.get(2));
					txtemail.setText(listar.get(3));
					txtnasc.setText(listar.get(4)); 
					btnSalvar.setVisible(false);
					btnalterar.setVisible(true);
					btnlocalizar.setVisible(false);
					btnexcluir.setVisible(true);
				}
				
			}
		}
		else if (e.getSource() == btnSalvar){
			cliente.salvar(txtnome.getText(),txtsobre.getText(),txtemail.getText(),selectsexo.getSelectedIndex(),txtnasc.getText());
			txtnome.setText("");
			txtsobre.setText("");
			txtemail.setText("");
			txtnasc.setText("");
		}
		if (e.getSource().equals(btnexcluir)){
			cliente.excluir(Integer.parseInt(txtcod.getText()));
			txtnome.setText("");
			txtsobre.setText("");
			txtemail.setText("");
			txtnasc.setText("");
			txtcod.setText("");
		}
		if(e.getSource().equals(btnalterar)){
			cliente.alterar(Integer.parseInt(txtcod.getText()), txtnome.getText(),txtsobre.getText(),txtemail.getText(),selectsexo.getSelectedIndex(),txtnasc.getText());
			txtnome.setText("");
			txtsobre.setText("");
			txtemail.setText("");
			txtnasc.setText("");
			txtcod.setText("");
		}
	}

}
