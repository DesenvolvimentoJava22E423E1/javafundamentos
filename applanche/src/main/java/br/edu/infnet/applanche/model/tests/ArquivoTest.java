package br.edu.infnet.applanche.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.applanche.model.domain.Bebida;
import br.edu.infnet.applanche.model.domain.Pedido;
import br.edu.infnet.applanche.model.domain.Produto;
import br.edu.infnet.applanche.model.domain.Solicitante;
import br.edu.infnet.applanche.model.exceptions.PedidoSemProdutoException;
import br.edu.infnet.applanche.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.applanche.model.exceptions.SolicitanteInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;

public class ArquivoTest {

	public static void main(String[] args) {
		
		try {
			String arq = "pedidos.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();			
				String[] campos = null;
				
				List<Produto> produtos = new ArrayList<Produto>();
				Pedido pedido = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "P":					
						try {						
							pedido = new Pedido(new Solicitante(campos[5], campos[3], campos[4]), produtos);
							pedido.setDescricao(campos[1]);
							pedido.setWeb(Boolean.valueOf(campos[2]));
						} catch (SolicitanteInvalidoException | PedidoSemSolicitanteException | PedidoSemProdutoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "B":					
						try {
							Bebida bebida = new Bebida(campos[1], campos[2], Float.valueOf(campos[3]), campos[5]);
							bebida.setGelada(Boolean.valueOf(campos[4]));
							bebida.setTamanho(Integer.valueOf(campos[6]));

							produtos.add(bebida);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}

						break;
					case "C":					
						break;
					case "S":					
						break;

					default:
						System.out.println("Registro inválido!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(pedido.obterLinha());
				
				escrita.close();
				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}		
	}
}