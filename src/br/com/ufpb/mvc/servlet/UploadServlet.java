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
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String operacao = "";
	public static String caminhoImagem;
	public static String caminhoVideo;
	public static String caminhoSom;

	/**
	 * lida com upload de arquivo
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
		String caminhoAtual = "/home/lucy/Dropbox/workspace/Sisalfa/WebContent";

		String appPath = caminhoAtual + File.separator + "uploads";
		String savePath = "";
		String pasta = "";
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.ufpb.mvc.logica." + parametro;
		// constructs path of the directory to save uploaded file
		if (request.getParameter("nome") == null) {
			savePath = appPath + File.separator + "desafios" + File.separator + request.getParameter("palavra");
			pasta = "uploads" + File.separator + "desafios";
			operacao = "desafio";
		} else {
			savePath = appPath + File.separator + "contextos" + File.separator + request.getParameter("nome");
			pasta = "uploads" + File.separator + "contextos";
			operacao = "contexto";
		}
		/** Cria uma pasta caso ela não exista */
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		try {
			// Imagem
			Part arquivoImagem = request.getPart("fileImagem");
			if (request.getParameter("nome") == null) {
				caminhoImagem = pasta + File.separator + request.getParameter("palavra") + File.separator
						+ extractFileName(arquivoImagem);
			} else {
				caminhoImagem = pasta + File.separator + request.getParameter("nome") + File.separator
						+ extractFileName(arquivoImagem);
			}

			arquivoImagem.write(savePath + File.separator + extractFileName(arquivoImagem));

			// Som
			Part arquivoSom = request.getPart("fileSom");
			caminhoSom = savePath + File.separator + extractFileName(arquivoSom);
			arquivoSom.write(caminhoSom);

			// Video
			Part arquivoVideo = request.getPart("fileVideo");
			caminhoVideo = savePath + File.separator + extractFileName(arquivoVideo);
			arquivoVideo.write(caminhoVideo);

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

	/**
	 * Extrair nome de arquivo de cabeçalho HTTP content-disposition
	 */
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
