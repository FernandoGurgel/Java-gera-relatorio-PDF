package view.roow;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.bean.ServicoBean;

public class GerarPDF {

	//CRIANDO A TABELA
	PdfPTable tabela=new PdfPTable(5);
	PdfPCell header = new PdfPCell(new Paragraph("Relatorio de Dados"));
		   
	public void GerarRelPdf(int linha, String[][] listaTudo,String[] titulo,String nome ) throws IOException{
		
		//criando um novo  documento
		Document docPdf=new Document();
		try{
			//criando uma instancia do pdf e nomeando
			PdfWriter.getInstance(docPdf, 
					new FileOutputStream(nome+".pdf"));
			//abrir o doc. PDF
			docPdf.open();
			//definir o tamanho da pagina
			docPdf.setPageSize(PageSize.A4);
			//recebendo a image
			//Image imag=Image.getInstance(img);
			//setando o tamanho da image
			//imag.scaleToFit(400,200);
			//adicionar no doc pdf
			//docPdf.add(imag);
			//adicionando o texto ao PDF
			//docPdf.add(new Paragraph(corpo));                                     
			//passa os dados para o model
			header.setColspan(5);
		    tabela.addCell(header);	
		    tabela.addCell(titulo[0]);
		    tabela.addCell(titulo[1]);
		    tabela.addCell(titulo[2]);
		    
		    for(int i=0;i<linha;i++){
			    tabela.addCell(listaTudo[i][0]);
			    tabela.addCell(listaTudo[i][1]);
			    tabela.addCell(listaTudo[i][2]);
		    }
	        //adiciona o scrol no painel
	        docPdf.add(tabela);
		}catch(DocumentException dp){
			dp.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}finally{
			docPdf.close();
			JOptionPane.showMessageDialog(null,
					"PDF Gerado!!!");
			java.awt.Desktop.getDesktop().open(new File(nome + ".pdf"));
			
		}//finally
	}

	public void GerarRelPdf(String[] coluna, DefaultTableModel modelo, String arquivo) throws IOException {
		//criando um novo  documento
		PdfPTable tabela=new PdfPTable(coluna.length);
				Document docPdf=new Document();
				
				try{
					//criando uma instancia do pdf e nomeando
					PdfWriter.getInstance(docPdf, 
							new FileOutputStream(arquivo+".pdf"));
					//abrir o doc. PDF
					docPdf.open();
					//definir o tamanho da pagina
					docPdf.setPageSize(PageSize.A4);
					//recebendo a image
					//Image imag=Image.getInstance(img);
					//setando o tamanho da image
					//imag.scaleToFit(400,200);
					//adicionar no doc pdf
					//docPdf.add(imag);                                 
					//passa os dados para o model
					header.setColspan(coluna.length);
				    tabela.addCell(header);
				    
				    for(int i = 0; i<coluna.length; i++){
				    	tabela.addCell(coluna[i]);
				    }
				    
			        //adiciona o scrol no painel
			        docPdf.add(tabela);
			      //adicionando o texto ao PDF
			        for (int i=0; i<modelo.getRowCount(); i++){
						for (int j = 0; j < modelo.getColumnCount(); j++) {
							String valor = " "+ modelo.getValueAt(i, j);
							tabela.addCell(valor);
						}	
			        }
					docPdf.add(tabela); 
				}catch(DocumentException dp){
					dp.printStackTrace();
				}catch(IOException io){
					io.printStackTrace();
				}finally{
					docPdf.close();
					JOptionPane.showMessageDialog(null,
							"PDF Gerado!!!");
					java.awt.Desktop.getDesktop().open(new File(arquivo + ".pdf"));
					
				}//finally
		
	}//metodo
}