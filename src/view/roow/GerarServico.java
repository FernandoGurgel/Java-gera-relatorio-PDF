package view.roow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controlador.Cliente;
import controlador.Produto;
import controlador.Servico;
import controlador.Usuario;
import model.bean.ClienteBean;
import model.bean.UsuarioBean;

public class GerarServico extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Servico servico = new Servico();
	
	Usuario usuario = new Usuario();
	
	Cliente clientecon = new Cliente();
	
	Produto produto = new Produto();
	
	UsuarioBean beanuser = new UsuarioBean();
	
	ClienteBean beancli = new ClienteBean();
	
	int cont= 0, subtotal = 0, total = 0;
	Cliente cliente = new Cliente();
	JTextArea listaArea = new JTextArea();
	
	JFrame tela = new JFrame("Novo Servico");
	JPanel fundo = new JPanel();
	
	JLabel lbcliente = new JLabel("Cliente:"),
			lbusuario = new JLabel("Usuario:"),
			lbqtd = new JLabel("Qtd."),
			lbcod = new JLabel("Cod"),
			lbDescricao = new JLabel("Descricao"),
			lbnstatus = new JLabel(),
			lbnnstatus = new JLabel(),
			lbvalor = new JLabel(),
			lbTotal = new JLabel("Total = R$ ");
		
	JTextField txtCliente =new JTextField(),
			txtUsuario= new JTextField(),
			txtqtd= new JTextField(),
			txtcod= new JTextField(),
			txtdescricao = new JTextField();
	
	JButton btnSalvar = new JButton("Salvar"),
			btnfinalizar = new JButton("Finalizar"),
			btnsair = new JButton("Cancelar");
	
	public void criaTela(){
				
		tela.setLayout(null);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setVisible(true);
		tela.setSize(800, 600);
		tela.setLocationRelativeTo(null);
		fundo();
		tela.repaint();
	}
	
	private void fundo() {
		
		fundo.setBounds(0, 0, 800, 600);
		fundo.setLayout(null);
		fundo.setBackground(new Color(151,124,102));
		tela.add(fundo);
		p3();
		p2();
		p1();
	}

	private void p3() {
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBounds(400, 60, 400, 500);
		JLabel imfundo = new JLabel();
		imfundo.setIcon(new ImageIcon("src/papel.png"));
		imfundo.setBounds(0, 0, 400, 500);
		JLabel titulo = new JLabel();
		titulo.setText("Item      Decricao      Qtd.      Valor      Subtotal");
		titulo.setBounds(6, 1, 380, 20);
		titulo.setFont(new Font("src/Comfortaa-Bold.ttf", Font.PLAIN, 16));
		listaArea = new JTextArea(){
			ImageIcon imagem = new ImageIcon("src/papel.png");
			Image image = imagem.getImage();
			
			Image grayImage = GrayFilter.createDisabledImage(image);
	        {
	            setOpaque(false);
	        }

	        public void paint(Graphics g) {
	            g.drawImage(grayImage, 1, 400, this);
	            super.paint(g);
	        }
		};
		
		listaArea.setBounds(7, 45, 380, 400);
		listaArea.setEditable(false);
		
		lbTotal.setBounds(200, 370, 120, 20);
		lbvalor.setBounds(320, 370, 120, 20);
		lbvalor.setFont(new Font("src/Comfortaa-Bold.ttf", Font.PLAIN, 20));
		lbTotal.setFont(new Font("src/Comfortaa-Bold.ttf", Font.PLAIN, 20));
		lbnstatus.setBounds(120, 400, 170, 30);
		lbnnstatus.setBounds(250, 402, 120, 20);
		lbnstatus.setFont(new Font("src/Comfortaa-Bold.ttf", Font.PLAIN, 20));
		lbnnstatus.setFont(new Font("src/Comfortaa-Bold.ttf", Font.PLAIN, 16));
		
		p3.add(lbnnstatus);
		p3.add(lbnstatus);
		p3.add(lbvalor);
		p3.add(lbTotal);
		p3.add(listaArea);
		p3.add(titulo);
		p3.add(imfundo);
		fundo.add(p3);
		
	}

	private void p2() {
		JPanel p2 = new JPanel();
		p2.setBounds(60, 300, 300, 300);
		p2.setLayout(null);
		p2.setBackground(new Color(250, 255, 174));
		lbqtd.setBounds(20, 40, 80, 30);
		lbcod.setBounds(90, 40, 80, 30);
		txtqtd.setBounds(20, 70, 40, 30);
		txtcod.setBounds(90, 70, 190, 30);
		txtcod.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if (txtcod.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campos Vazios!");
					}
					else{
						
						ArrayList<String> listar = new ArrayList<String>();
						listar = produto.especifico(Integer.parseInt(txtcod.getText()));
						if(listar.isEmpty()){
							JOptionPane.showMessageDialog(null, "Não encontrado");				
						}else{
							txtdescricao.setText(listar.get(1));
							cont++;
							servico.insertitem(Integer.parseInt(txtqtd.getText()),Integer.parseInt(txtcod.getText()),Integer.parseInt(lbnnstatus.getText()));
							String item=String.valueOf(cont)+"        "+listar.get(1)+"        "+listar.get(0)+"    X    "+listar.get(2)+"      =      "+(Integer.parseInt(txtqtd.getText())*Integer.parseInt(listar.get(2))+"\n");
							listaArea.append(item);
							subtotal += (Integer.parseInt(txtqtd.getText()))*(Integer.parseInt(listar.get(2)));
							lbvalor.setText(String.valueOf(subtotal));
							
						}
						
					}
				}
				
			}
		});
		lbDescricao.setBounds(20, 110, 80, 30);
		txtdescricao.setBounds(20, 140, 260,30);
		
		btnSalvar.setBounds(20, 180, 120, 30);
		btnSalvar.addActionListener(this);
		btnfinalizar.setBounds(160, 180, 120, 30);
		btnfinalizar.addActionListener(this);
		btnsair.setBounds(20, 225, 260, 30);
		btnsair.addActionListener(this);
		p2.add(btnsair);
		p2.add(btnfinalizar);
		p2.add(btnSalvar);
		p2.add(lbqtd);
		p2.add(lbDescricao);
		p2.add(txtdescricao);
		p2.add(lbcod);
		p2.add(txtqtd);
		p2.add(txtcod);
		fundo.add(p2);
	}

	private void p1() {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(60, 0, 300, 200);
		p1.setBackground(new Color(226, 230, 235));
		lbcliente.setBounds(20,60, 90, 30);
		txtCliente.setBounds(120, 60, 150, 30);
		txtCliente.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if (txtCliente.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campos Vazios!");
					}
					else{
						
						ArrayList<String> listar = new ArrayList<String>();
						listar = cliente.especifico(Integer.parseInt(txtCliente.getText()));
						beancli.setCod(Integer.parseInt(txtCliente.getText()));
						if(listar.isEmpty()){
							JOptionPane.showMessageDialog(null, "Não encontrado");				
						}else{
							txtCliente.setText(listar.get(1));
						}
						
					}
					
				}
				
			}
		});
		lbusuario.setBounds(20, 140, 90, 30);
		txtUsuario.setBounds(120, 140, 150, 30);
		txtUsuario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if (txtUsuario.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Campos Vazios!");
					}
					else{
						
						ArrayList<String> listar = new ArrayList<String>();
						listar = usuario.especifico(Integer.parseInt(txtUsuario.getText()));
						beanuser.setCoduser(Integer.parseInt(txtUsuario.getText()));
						if(listar.isEmpty()){
							JOptionPane.showMessageDialog(null, "Não encontrado");				
						}else{
							txtUsuario.setText(listar.get(1));
						}
						
					}
					if (lbnnstatus.getText().equals("")){
						lbnnstatus.setText(Integer.toString(servico.listarCont())); 
						lbnstatus.setText("Orçamento");
						
					}
					
					
				}
				
			}
		});
		
		p1.add(lbcliente);
		p1.add(txtCliente);
		p1.add(lbusuario);
		p1.add(txtUsuario);
		fundo.add(p1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsair){
			tela.dispose();
		}
		else if (e.getSource() == btnSalvar){
			servico.salvar(beancli.getCod(),beanuser.getCoduser());
			tela.dispose();
			JOptionPane.showMessageDialog(null, "Orçamento salvo com sucesso");
		}
		else if (e.getSource()== btnfinalizar){
			int pagamento = Integer.parseInt(JOptionPane.showInputDialog("Forma de pagamento? (1-dinheiro, 2-Cartao Credito, 3-Cartao Debito)"));
			int confirmapg = Integer.parseInt(JOptionPane.showInputDialog("Foi pago? (1 - Sim, 2 - Não)"));
			servico.finalizar(beancli.getCod(),beanuser.getCoduser(),pagamento,confirmapg);
			tela.dispose();
			JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso");
		}
	}

}
