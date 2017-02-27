package br.com.ufpb.modelo;

import java.io.File;
import java.io.IOException;

public class Teste {
	public static String caminhoAtual;
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		caminhoAtual = file.getCanonicalPath();
		
	}

}
