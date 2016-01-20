package controlador;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.bean.UsuarioBean;
import model.dao.UsuarioDao;
import view.roow.GerarPDF;
import view.roow.RoowPrincipal;
import view.usuario.CadastraUsuario;
import view.usuario.Loga;
import view.usuario.Principal;

public class Usuario extends UsuarioBean{


	UsuarioDao dao = new UsuarioDao();
	static Loga loga = new Loga();
	
	
	public static void main(String[] args) {
		
		loga.telaLogin();
	}

	public void logar(String nome, String senha) {
		
		if (nome.equals("") || senha.equals("")){
			loga.activa(0);
			JOptionPane.showMessageDialog(null, "Campos Vazios!");
		}
		else{
			
			this.setLoginuser(nome);
			this.setSenhauser(senha);
			boolean login = dao.logar(this);
			
			if(login == true){
				RoowPrincipal principal = new RoowPrincipal();
				principal.criaTela();
			}else{
				JOptionPane.showMessageDialog(null, "Senha ou Login invalido!!");
			}
			
		}
	}

	public void irCadastro() {
		CadastraUsuario tela = new CadastraUsuario();
		tela.criaTela();
		
	}

	public void listar() {
		// select *  from usuario
		List<UsuarioBean> lista = dao.listar(this);
		
		// criando caixa de dialogo com tabela 
		String[] coluna = {"Id", "Nome", "Login"};
		DefaultTableModel modelo = new DefaultTableModel(coluna,0);
		
		// populando tabela
		for(UsuarioBean teste : lista){
			modelo.addRow(new Object[]{teste.getCoduser(),teste.getNomeuser(),teste.getLoginuser()});
		}
		JTable tabela = new JTable(modelo);
				
		// ciando tabela rolagem
		JScrollPane rolagem = new JScrollPane();
		rolagem.setViewportView(tabela);
		//tela
		JPanel panel = new JPanel(new GridLayout());
		panel.add(rolagem);
		JOptionPane.showMessageDialog(null, panel);
		
	}

	public ArrayList<String> especifico(int cod) {
		// Select usuario = id
		this.setCoduser(cod);
		return dao.selectId(this);
		
	}

	public void alterar(String nome, String login, String senha, int cod) {
		// Update usuario
		this.setCoduser(cod);
		this.setNomeuser(nome);
		this.setLoginuser(login);
		this.setSenhauser(senha);
		
		dao.update(this);
	}

	public void salvar(String nome, String login, String senha) {
		// Insert usuario
		this.setNomeuser(nome);
		this.setLoginuser(login);
		this.setSenhauser(senha);
		
		dao.insert(this);
	}

	public void excluir(int cod) {
		this.setCoduser(cod);
		dao.delete(this);
	}

	public void geraPDF() throws IOException {
		int linha = dao.contLinha(this);
		String[][] lista = dao.listarString(linha);
		String[] titulo ={"Cod", "Nome","login"};
		GerarPDF g = new GerarPDF();
		String nome = "usuario";
		
		g.GerarRelPdf(linha, lista, titulo, nome);
	}

}
