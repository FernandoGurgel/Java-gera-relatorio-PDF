package view.roow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.Produto;

public class CadastroProduto extends JPanel  implements ActionListener {

	private static final long serialVersionUID = 1L;

	Produto produto = new Produto();
	
	JFrame tela = new JFrame("Cadastro Produto");
	
	JLabel lbproduto = new JLabel("Nome:"),
			lbcod = new JLabel("Cod:"),
			lbvalor = new JLabel("Valor:");
			
	
	JTextField txtnome =new JTextField(),
			txtvalor= new JTextField(),
			txtcod= new JTextField();
			
			
	JButton btnSalvar = new JButton("Salvar"),
			btnexcluir = new JButton("Excluir"),
			btnalterar = new JButton("Alterar"),
			btnlocalizar = new JButton("Localizar");
	
	public void criaTela(){
				
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		tela.setSize(280, 180);
		//Nome
		lbproduto.setBounds(20, 15, 60, 20);
		txtnome.setBounds(90, 12, 140, 25);
		//Login
		lbvalor.setBounds(20, 45, 60, 20);
		txtvalor.setBounds(90, 42, 140, 25);
		//
		lbcod.setBounds(20, 70, 60, 20);
		txtcod.setBounds(90, 75, 140, 25);
		
		
		//botoes
		btnSalvar.setBounds(20, 110, 80, 35);
		btnalterar.setBounds(20, 110, 80, 35);
		btnalterar.setVisible(false);
		
		btnlocalizar.setBounds(160, 110, 100, 35);
		btnexcluir.setBounds(160, 110, 100, 35);
		btnexcluir.setVisible(false);
		
		btnexcluir.addActionListener(this);
		btnalterar.addActionListener(this);
		btnlocalizar.addActionListener(this);
		btnSalvar.addActionListener(this);

		tela.add(btnSalvar);
		tela.add(btnlocalizar);
		tela.add(btnexcluir);
		tela.add(btnalterar);
		tela.add(lbcod);
		tela.add(txtcod);
		tela.add(lbproduto);
		tela.add(lbvalor);
		tela.add(txtnome);
		tela.add(txtvalor);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnlocalizar){
			if (txtcod.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Campos Vazios!");
			}
			else{
				
				ArrayList<String> listar = new ArrayList<String>();
				listar = produto.especifico(Integer.parseInt(txtcod.getText()));
				if(listar.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não encontrado");				
				}else{
					txtnome.setText(listar.get(1));
					txtvalor.setText(listar.get(2));
					btnSalvar.setVisible(false);
					btnalterar.setVisible(true);
					btnlocalizar.setVisible(false);
					btnexcluir.setVisible(true);
				}
				
			}
		}
		else if (e.getSource() == btnSalvar){
			produto.salvar(txtnome.getText(),Double.parseDouble(txtvalor.getText()));
		}
		if (e.getSource().equals(btnexcluir)){
			produto.excluir(Integer.parseInt(txtcod.getText()));
			btnSalvar.setVisible(true);
			btnalterar.setVisible(false);
			btnlocalizar.setVisible(true);
			btnexcluir.setVisible(false);
			txtnome.setText("");
			txtvalor.setText("");
			tela.repaint();
		}
		if(e.getSource().equals(btnalterar)){
			produto.alterar(Integer.parseInt(txtcod.getText()), txtnome.getText(),Double.parseDouble(txtvalor.getText()));
			btnSalvar.setVisible(true);
			btnalterar.setVisible(false);
			btnlocalizar.setVisible(true);
			btnexcluir.setVisible(false);
			txtnome.setText("");
			txtvalor.setText("");
			tela.repaint();
		}
	}
}