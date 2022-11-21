package br.edu.infnet.app.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTeste {

	public static void main(String[] args) {

		try {
			try {
				String dir = "c:/dev/";		
				String arq = "meusalunos.txt";
				
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				String linha = leitura.readLine();
				
				while(linha != null) {
					System.out.println("Linha: " + linha);
					linha = leitura.readLine();
				}
								
				leitura.close();
				file.close();
			} catch (IOException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}				
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}
		
		
	}
}