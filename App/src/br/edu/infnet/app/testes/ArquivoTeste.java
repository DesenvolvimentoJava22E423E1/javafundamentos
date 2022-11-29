package br.edu.infnet.app.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.infnet.app.dominio.Administrativo;
import br.edu.infnet.app.dominio.Estagiario;
import br.edu.infnet.app.dominio.Programador;

public class ArquivoTeste {

	public static void main(String[] args) {
		
		try {

			try {
				String dir = "c:/dev/";		
				String arq = "meusalunos.txt";
				
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();
				
				String[] campos = null;
				
				int qtde = 0;
				float valor = 0;
				
				while(linha != null) {
					
					campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
					case "A":
						
						Administrativo a = new Administrativo();
						a.setNome(campos[1]);
						a.setIdade(Integer.valueOf(campos[2]));
						a.setSalario(Float.valueOf(campos[3]));
						a.setBonus(Float.valueOf(campos[4]));
						a.setDesconto(Float.valueOf(campos[5]));

						escrita.write(a.obterStringSalarioPorFuncionario());
						qtde++;
						valor = valor + a.calcularSalarioLiquido();

						break;

					case "E":						
						Estagiario e = new Estagiario();
						e.setFaculdade(campos[4]);
						e.setIdade(Integer.valueOf(campos[2]));
						e.setNome(campos[1]);
						e.setPeriodo(Integer.valueOf(campos[5]));
						e.setSalario(Float.valueOf(campos[3]));

						escrita.write(e.obterStringSalarioPorFuncionario());
						qtde++;
						valor = valor + e.calcularSalarioLiquido();

						break;

					case "P":						
						Programador p = new Programador(campos[1], Integer.valueOf(campos[2]));
						p.setDevFull(Boolean.valueOf(campos[5]));
						p.setLinguagem(campos[4]);
						p.setSalario(Float.valueOf(campos[3]));

						escrita.write(p.obterStringSalarioPorFuncionario());
						qtde++;
						valor = valor + p.calcularSalarioLiquido();

						break;
						
					default:
						System.out.println("Funcionário ainda não definido [" + linha + "]");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(qtde+";"+valor+"\r\n");
								
				leitura.close();
				file.close();
				
				escrita.close();
				fileW.close();
			} catch (IOException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}			
	}
}