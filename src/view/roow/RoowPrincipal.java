package view.roow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.roow.GerarPDF;
import controlador.Cliente;
import controlador.Produto;
import controlador.Servico;
import controlador.Usuario;
import model.bean.UsuarioBean;
import view.usuario.Principal;

public class RoowPrincipal  extends JPanel implements ActionListener{

	private static final long serialVersionUID = 2618262055978279234L;
	
	public int op = 0;
	Object valor;
	UsuarioBean usuario = new UsuarioBean();
	
	JFrame tela = new JFrame("SistLavanderia");
		
	JPanel panelprincipal = new JPanel();
	
	JTable tabelaServico = new JTable();
	
	JMenu menuUser = new JMenu("Nome usuario");

	JButton btnservico = new JButton("Pedido"),
			btncliente = new JButton("Cliente"),
			btnTabela = new JButton("Produto"),
			novoCliente = new JButton("Novo Cliente"),
			pesquisaCliente = new JButton("Pesquisa"),
			btnrelatorio = new JButton("Relatório"),
			novoProduto = new JButton("Novo Produto"),
			pesquisaProduto = new JButton("Pesquisa"),
			geraServico = new JButton("Criar / Orcamento servico"),
			pesquisaServico = new JButton("Pesquisa");
	
	public void criaTela(){
		// janela
		tela.setUndecorated(true);
		tela.setLayout(null);
		tela.setSize(800, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tela.setBackground(Color.WHITE);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		
		menuTop(usuario);
		menuLat();
		tela.repaint();
	}
	
	public void menuLat(){
		JPanel menuLateral = new JPanel();
		
		menuLateral.setSize(130,560);
		menuLateral.setLocation(0,40);
		menuLateral.setBackground(new Color(226, 230, 235));
		menuLateral.setLayout(null);
		
		
		btnservico.setBounds(0, 2, 130, 60);
		btnservico.setBackground(new Color(226, 230, 235));
		//teste
				
		btncliente.setBounds(0, 65, 130, 60);
		btncliente.setBackground(new Color(226, 230, 235));
		btnTabela.setBounds(0, 127, 130, 60);
		btnTabela.setBackground(new Color(226, 230, 235));
		btnrelatorio.setBounds(0, 189, 130, 60);
		btnrelatorio.setBackground(new Color(226, 230, 235));
		
		btnservico.addActionListener(this);
		btncliente.addActionListener(this);
		btnTabela.addActionListener(this);
		btnrelatorio.addActionListener(this);
		
		
		menuLateral.add(btnrelatorio);
		menuLateral.add(btnTabela);
		menuLateral.add(btncliente);
		menuLateral.add(btnservico);
		menuLateral.repaint();
		tela.add(menuLateral);
	}
	
	public void menuTop(UsuarioBean usuer){				
		//menulav
		JPanel menunav = new JPanel();
		menunav.setSize(800,40);
		menunav.setLocation(0, 0);
		menunav.setLayout(null);
		menunav.setBackground(new Color(24, 94, 148));
		
		// icon sair
		JLabel lbsair = new JLabel();
		lbsair.setIcon(new ImageIcon("src/close.png"));
		lbsair.setSize(40,40);
		lbsair.setLocation(760, 0);
		lbsair.addMouseListener(new MouseListener() {
					
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
						
		}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getSource().equals(lbsair)){
							System.exit(0);
							
						}
					}
				});
		// icon minizar
		JLabel lbminizar = new JLabel();
		lbminizar.setIcon(new ImageIcon("src/minimize.png"));
		lbminizar.setSize(40,40);
		lbminizar.setLocation(720, 0);
		lbminizar.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getSource().equals(lbminizar)){
							tela.setExtendedState(JFrame.ICONIFIED);;
						}
						
					}
				});
		//menu usuario
		JLabel lbusuario = new JLabel();
		lbusuario.setFont(new Font("src/Comfortaa-bold.ttf",Font.HANGING_BASELINE, 14));
		lbusuario.setForeground(Color.white);
		lbusuario.setBounds(10, 10, 200, 20);
		lbusuario.setText("Empresar fulano - Fernando");
		lbusuario.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal tela = new Principal();
				tela.criaTela();
				
			}
		});
		
		menunav.add(lbusuario);
		menunav.add(lbminizar);
		menunav.add(lbsair);
		menunav.repaint();
		tela.add(menunav);
	}

		@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnservico)){
			op=1;
			this.trocacorpo(op);
		}
		if(e.getSource().equals(btncliente)){
			op=2;
			this.trocacorpo(op);
		}
		if(e.getSource().equals(btnTabela)){
			op=3;
			this.trocacorpo(op);
		}
		if(e.getSource().equals(btnrelatorio)){
			op=4;
			this.trocacorpo(op);
		}
		if(e.getSource().equals(novoCliente)){
			CadastroCliente cliente = new CadastroCliente();
			cliente.criaTela();
		}
		if(e.getSource().equals(novoProduto)){
			CadastroProduto produto = new CadastroProduto();
			produto.criaTela();
		}
		if (e.getSource().equals(geraServico)){
			GerarServico servico = new GerarServico();
			servico.criaTela();
		}
		
		
	}

	private void trocacorpo(int op) {
		if(op == 1){
			String[] coluna = {"Nº Roow", "Nome Cliente", "Status", "Total"};
			Servico servico = new Servico();
			DefaultTableModel model = servico.listar();
			panelServico(coluna,model);
		}else if(op == 2){
			String[] coluna = {"Cod ","Nome","Sobrenome","Email"};
			Cliente cliente = new Cliente();
			DefaultTableModel model = cliente.listar();
			panelCliente(coluna, model);
		}else if(op == 3){
			String[] coluna = {"Cod. produto","Produto", "Valor"};
			Produto produto = new Produto();
			DefaultTableModel model = produto.listar();
			panelProdutos(coluna,model);
		}else if(op == 4){
			panelRelatorio();
		}
	}

	private void panelRelatorio() {
		
		panelprincipal.removeAll();
		
		panelprincipal.setBounds(135, 45, 660, 550);
		panelprincipal.setLayout(null);
		panelprincipal.setBackground(Color.white);
		
		//adicionando componentes
		JButton rCliente = new JButton("Relatorio Cliente"),
				rProduto = new JButton("Relatorio Produto"),
				rFaturamento = new JButton("Relatorio Faturamento"),
				rServico = new JButton("Relatorio Serviço");
		
		rCliente.setBounds(20, 20, 220, 30);
		rCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				try {
					usuario.geraPDF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rServico.setBounds(20, 60, 220, 30);
		rServico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Servico servico = new Servico();
				try {
					servico.geraPDF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rProduto.setBounds(20, 100, 220, 30);
		rCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				try {
					cliente.geraPDF();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		rFaturamento.setBounds(20, 140, 220, 30);
		rFaturamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Servico cliente = new Servico();
				try {
					cliente.geraPDFfau();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			}
		});
		
		panelprincipal.add(rFaturamento);
		panelprincipal.add(rProduto);
		panelprincipal.add(rCliente);
		panelprincipal.add(rServico);
		panelprincipal.repaint();
		tela.add(panelprincipal);
	}
	
	
	
	//Funcionando
	
	private void panelServico(String[] coluna, DefaultTableModel model) {
		
		panelprincipal.removeAll();
		panelprincipal.setBounds(135, 45, 660, 550);
		panelprincipal.setLayout(null);
		panelprincipal.setBackground(Color.white);
		panelprincipal.repaint();
		
		//criando tabela
		
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		tabelaServico = new JTable(modelo);
		tabelaServico = new JTable(model);
		tabelaServico.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int valor = (int) (tabelaServico.getValueAt(tabelaServico.getSelectedRow(), 0));
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja Cancelar esta venda","Cancelar Serviço",JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_NO_OPTION){
					Servico servico = new Servico();
					servico.excluir(valor);
				}
			}
		});
		
		
		JScrollPane rolagem = new JScrollPane(tabelaServico);
		rolagem.setBounds(20, 60, 635, 400);
		//adicionando componentes
				
		geraServico.setBounds(20, 20, 220, 30);
		geraServico.addActionListener(this);
		JTextField campoPesquisa = new JTextField();
		campoPesquisa.setText("Nome ou Nº servico");
		campoPesquisa.setBounds(370, 20, 150, 30);
		pesquisaServico.setBounds(525, 20, 130, 30);
		
		panelprincipal.add(rolagem);
		panelprincipal.add(pesquisaServico);
		panelprincipal.add(campoPesquisa);
		panelprincipal.add(geraServico);
		tela.add(panelprincipal);
	}
	
	private void panelProdutos(String[] coluna, DefaultTableModel model) {
		
		panelprincipal.removeAll();
		panelprincipal.setBounds(135, 45, 660, 550);
		panelprincipal.setLayout(null);
		panelprincipal.setBackground(Color.white);
		panelprincipal.repaint();
		//criando tabela
		
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		JTable tabelaServico = new JTable(modelo);
		tabelaServico = new JTable(model);
		JScrollPane rolagem = new JScrollPane(tabelaServico);
		rolagem.setBounds(20, 60, 635, 400);
		//add componentes
				
		novoProduto.setBounds(20, 20, 220, 30);
		JTextField campoPesquisa = new JTextField();
		campoPesquisa.setText("Nome");
		campoPesquisa.setBounds(370, 20, 150, 30);
		pesquisaProduto.setBounds(525, 20, 130, 30);
		novoProduto.addActionListener(this);
		pesquisaProduto.addActionListener(this);
		
		panelprincipal.add(rolagem);
		panelprincipal.add(pesquisaProduto);
		panelprincipal.add(campoPesquisa);
		panelprincipal.add(novoProduto);
		tela.add(panelprincipal);
	}
	
	private void panelCliente(String[] coluna, DefaultTableModel model) {
		
		panelprincipal.removeAll();
		panelprincipal.setBounds(135, 45, 660, 550);
		panelprincipal.setLayout(null);
		panelprincipal.setBackground(Color.white);
		panelprincipal.repaint();
		
		//criando tabela
		
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		JTable tabelaServico = new JTable(modelo);
		tabelaServico = new JTable(model);
		JScrollPane rolagem = new JScrollPane(tabelaServico);
		rolagem.setBounds(20, 60, 635, 400);
		//adicionando componentes
		
		panelprincipal.add(rolagem);
		novoCliente.addActionListener(this);
		
		novoCliente.setBounds(20, 20, 220, 30);
		JTextField campoPesquisa = new JTextField();
		campoPesquisa.setText("Nome");
		campoPesquisa.setBounds(370, 20, 150, 30);
		pesquisaCliente.setBounds(525, 20, 130, 30);
		
		//panelprincipal.add(rolagem);
		panelprincipal.add(pesquisaCliente);
		panelprincipal.add(campoPesquisa);
		panelprincipal.add(novoCliente);
		tela.add(panelprincipal);
	}
	
	
}
