package br.edu.infnet.app.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.app.dominio.ComissaoTecnica;
import br.edu.infnet.app.dominio.Contato;
import br.edu.infnet.app.dominio.Dirigente;
import br.edu.infnet.app.dominio.Equipe;
import br.edu.infnet.app.dominio.Jogador;
import br.edu.infnet.app.dominio.Profissional;
import br.edu.infnet.app.exceptions.ContatoInvalidoException;
import br.edu.infnet.app.exceptions.JogadorInvalidoException;
import br.edu.infnet.app.exceptions.ProfissionalInvalidoException;

public class EquipeTeste {

	public static void main(String[] args) {
		
		String dir = "c:/dev/";
		String arq = "minhasequipes.txt";
		
		try {
			FileReader fileR = new FileReader(dir+arq);
			BufferedReader leitura = new BufferedReader(fileR);
			
			FileWriter fileW = new FileWriter(dir+"out_"+arq);
			BufferedWriter escrita = new BufferedWriter(fileW);
			
			String linha = leitura.readLine();
			
			String campos[] = null;
			Equipe equipe = null;
			List<Profissional> listaProfissional = null;

			while(linha != null) {
				
				campos = linha.split(";");
				
				switch (campos[0].toUpperCase()) {
				case "E":
					listaProfissional = new ArrayList<Profissional>();

					Contato contatoEquipe = new Contato();
					contatoEquipe.setEmail(campos[3]);
					contatoEquipe.setTelefone(campos[4]);

					equipe = new Equipe();
					equipe.setAnoFundacao(Integer.valueOf(campos[2]));
					equipe.setContato(contatoEquipe);
					equipe.setNome(campos[1]);
					equipe.setProfissionais(listaProfissional);

					break;

				case "J":
					Jogador jogador = new Jogador();
					jogador.setAnoNascimento(Integer.valueOf(campos[2]));
					jogador.setNome(campos[1]);
					jogador.setQtdeTituloInternacional(Integer.valueOf(campos[4]));
					jogador.setQtdeTituloNacional(Integer.valueOf(campos[3]));

					listaProfissional.add(jogador);
					
					break;

				case "T":
					ComissaoTecnica comissao = new ComissaoTecnica();
					comissao.setEhTreinador(Boolean.valueOf(campos[2]));
					comissao.setNome(campos[1]);
					comissao.setQtdeTitulo(Integer.valueOf(campos[3]));

					listaProfissional.add(comissao);
					break;

				case "D":
					Contato contatoDirigente = new Contato();
					contatoDirigente.setEmail(campos[3]);
					contatoDirigente.setTelefone(campos[4]);

					Dirigente dirigente = new Dirigente();
					dirigente.setAnoInicio(Integer.valueOf(campos[2]));
					dirigente.setContato(contatoDirigente);
					dirigente.setEhPresidente(Boolean.valueOf(campos[5]));
					dirigente.setNome(campos[1]);	

					listaProfissional.add(dirigente);
					break;

				default:
					System.out.println("Tipo inexistente!!!");
					break;
				}
				
				linha = leitura.readLine();
			}
			
			try {
				equipe.imprimir();
				
				escrita.write(equipe.obterLinhaGravacao());
				
			} catch (ContatoInvalidoException | ProfissionalInvalidoException | JogadorInvalidoException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}
			
			leitura.close();
			fileR.close();			
			escrita.close();
			fileW.close();
		} catch (IOException e1) {
			System.out.println("[ERRO-FILE] " + e1.getMessage());
		}
	}
}