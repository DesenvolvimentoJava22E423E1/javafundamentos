package br.edu.infnet.app.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.app.dominio.ComissaoTecnica;
import br.edu.infnet.app.dominio.Contato;
import br.edu.infnet.app.dominio.Dirigente;
import br.edu.infnet.app.dominio.Equipe;
import br.edu.infnet.app.dominio.Jogador;
import br.edu.infnet.app.dominio.Profissional;
import br.edu.infnet.app.exceptions.ContatoInvalidoException;
import br.edu.infnet.app.exceptions.ProfissionalInvalidoException;

public class EquipeTeste {

	public static void main(String[] args) {
		
		Jogador diego = new Jogador();
		diego.setAnoNascimento(1985);
		diego.setNome("Diego");
		diego.setQtdeTituloInternacional(8);
		diego.setQtdeTituloNacional(12);
		
		Jogador maria = new Jogador();
		maria.setAnoNascimento(1990);
		maria.setNome("Maria");
		maria.setQtdeTituloInternacional(9);
		maria.setQtdeTituloNacional(11);

		Jogador ana = new Jogador();
		ana.setAnoNascimento(2000);
		ana.setNome("Ana");
		ana.setQtdeTituloInternacional(10);
		ana.setQtdeTituloNacional(13);
		
		Contato c1 = new Contato();
		c1.setEmail("elberth@gmail.com");
		c1.setTelefone("21999988888");

		Dirigente juninho = new Dirigente();
		juninho.setAnoInicio(2010);
		juninho.setContato(c1);
		juninho.setEhPresidente(false);
		juninho.setNome("Juninho");	
		
		ComissaoTecnica tite = new ComissaoTecnica();
		tite.setEhTreinador(true);
		tite.setNome("Tite");
		tite.setQtdeTitulo(9);		
		
		List<Profissional> listaProfissional = new ArrayList<Profissional>();
		listaProfissional.add(diego);
		listaProfissional.add(maria);
		listaProfissional.add(ana);
		listaProfissional.add(juninho);
		listaProfissional.add(tite);

		Contato contato = new Contato();
		contato.setEmail("srn@srn.com");
		contato.setTelefone("21777766666");

		try {
			Equipe equipe = new Equipe();
			equipe.setAnoFundacao(1895);
			equipe.setContato(contato);
			equipe.setNome("SRN");
			equipe.setProfissionais(listaProfissional);
			equipe.imprimir();
		} catch (ContatoInvalidoException | ProfissionalInvalidoException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}
}