package br.com.ufpb.mvc.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.ufpb.dao.ContextoDAO;
import br.com.ufpb.dao.DesafioDAO;
import br.com.ufpb.mvc.logica.Logica;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String operacao;
	public static String caminhoImagem,caminhoVideo,caminhoSom;
	
	// METODO PARA UPLOAD DE ARQUIVOS
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath,pasta;

		String uploadPath = "/home/lucy/Dropbox/workspace/Sisalfa/WebContent/uploads";
		String nomeDaClasse = "br.com.ufpb.mvc.logica." + request.getParameter("logica");
		
		// VERIFICAÇÃO SE A OPERACAO É CONTEXTO OU DESAFIO
		
		if (request.getParameter("nome") == null) {
			//PASTA PARA GRAVAÇÃO NO DISCO
			savePath = uploadPath + File.separator + "desafios" + File.separator + request.getParameter("palavra");
			
			//PASTA PARA GRAVAÇÃO NO BANCO DE DADOS
			pasta = "uploads" + File.separator + "desafios" +File.separator + request.getParameter("palavra");
			operacao = "desafio";
		}else{
			//PASTA PARA GRAVACAO NO DISCO
			savePath = uploadPath + File.separator + "contextos" + File.separator + request.getParameter("nome");
			
			//PASTA PARA GRAVAÇÃO NO BANCO DE DADOS
			pasta = "uploads" + File.separator + "contextos"+ File.separator + request.getParameter("nome");
			operacao = "contexto";
		}
		
		// Cria uma pasta caso ela não exista 
		
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		// PROCESSAMENTO
		
		try {
			// =============== IMAGEM ======================
			
			Part arquivoImagem = request.getPart("fileImagem");
			
			caminhoImagem = pasta + File.separator + extractFileName(arquivoImagem);
			
			arquivoImagem.write(savePath+File.separator + extractFileName(arquivoImagem));

			// ================= SOM =========================
			
			Part arquivoSom = request.getPart("fileSom");
			
			caminhoSom = pasta + File.separator + extractFileName(arquivoSom);
			
			arquivoSom.write(savePath+File.separator+extractFileName(arquivoSom));	

			// ================VIDEO ==========================
			
			Part arquivoVideo = request.getPart("fileVideo");
			
			caminhoVideo = pasta + File.separator + extractFileName(arquivoVideo);
			
			arquivoVideo.write(savePath+File.separator+extractFileName(arquivoVideo));

			// INSERINDO OS DADOS NO BANCO DE DADOS
			
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/404.html");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.html");
		rd.forward(request, response);
	}


	// EXTRAÇÃO E MODIFICAÇÃO DO NOME DO ARQUIVO 
	
	private String extractFileName(Part part) {
		String nome = "";
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				if (operacao.equals("contexto")) {
					ContextoDAO dao = new ContextoDAO();
					long id = dao.retornaIdContexto();
					nome = id + s.substring(s.indexOf("."), s.length() - 1);
				} else {
					DesafioDAO dao = new DesafioDAO();
					long id = dao.retornaIdDesafio();
					nome = id + s.substring(s.indexOf("."), s.length() - 1);
				}
			}
		}
		return nome;
	}
}
