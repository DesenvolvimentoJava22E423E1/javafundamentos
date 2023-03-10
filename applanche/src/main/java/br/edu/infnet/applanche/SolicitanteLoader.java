package br.edu.infnet.applanche;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.applanche.model.domain.Solicitante;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.SolicitanteService;

@Order(2)
@Component
public class SolicitanteLoader implements ApplicationRunner {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "solicitantes.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String[] campos = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					Solicitante solicitante = new Solicitante(
							campos[0], 
							campos[1], 
							campos[2]
						);
					solicitante.setUsuario(usuario);
					
					solicitanteService.incluir(solicitante);

					System.out.println("A inclusão do solicitante "+solicitante.getNome()+" foi realizada com sucesso!!!");

					linha = leitura.readLine();
				}

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
