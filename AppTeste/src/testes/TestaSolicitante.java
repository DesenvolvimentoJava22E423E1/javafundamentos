package testes;

import java.util.ArrayList;
import java.util.List;

public class TestaSolicitante {

	public static void main(String[] args) {
		Solicitante s1 = new Solicitante();
		s1.setNome("huguinho");		
		
		Solicitante s2 = new Solicitante();
		s1.setNome("zezinho");

		List<Solicitante> listagem = new ArrayList<Solicitante>();		
		listagem.add(s1);
		listagem.add(s2);
		
		Solicitante s3 = new Solicitante();
		s1.setNome("luizinho");
		listagem.add(s3);
		
		
		Solicitante s4 = new Solicitante();
		s1.setNome("aninha");
		listagem.add(s4);
		
		
		Solicitante s5 = new Solicitante();
		s1.setNome("paulinha");
		listagem.add(s5);

		Solicitante s6 = new Solicitante();
		s1.setNome("felipe");
		listagem.add(s6);
		
		Empresa empresa = new Empresa();		
		empresa.setNome("Empresa X");
		empresa.setSolicitantes(listagem);
		System.out.println("Empresa: " + empresa.getNome());		
		System.out.println("Solicitantes: " + empresa.getSolicitantes().size());
	}
}
