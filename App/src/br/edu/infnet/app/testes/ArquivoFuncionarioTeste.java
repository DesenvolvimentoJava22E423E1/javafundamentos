package br.edu.infnet.app.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoFuncionarioTeste {

	public static void main(String[] args) {
		
		List<String> mensagens = new ArrayList<String>();
		
		try {
			try {
				String dir = "c:/dev/";		
				String arq = "out_meusalunos.txt";
				
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);

				String linha = leitura.readLine();
				
				String[] campos = null;
				
				int qtde = 0;
				int qtdeTotal = 0;
				
				float valor = 0;
				float valorTotal = 0;
				
				while(linha != null) {
					
					campos = linha.split(";");

					try {
						qtde = Integer.valueOf(campos[0]);
						valor = Float.valueOf(campos[1]);
					} catch (Exception e) {
						
						String nome = campos[0];
						float salarioLiquido = Float.valueOf(campos[1]);
						
						mensagens.add(String.format("O funcionário %s recebe R$%.2f", nome, salarioLiquido));
						
						qtdeTotal++;
						valorTotal = valorTotal + salarioLiquido; 
					}					

					linha = leitura.readLine();
				}

				if(qtde == qtdeTotal && valor == valorTotal) {
					for(String mensagem: mensagens) {
						System.out.println(mensagem);
					}
				} else {
					System.out.println("Arquivo corrompido!!");					
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
