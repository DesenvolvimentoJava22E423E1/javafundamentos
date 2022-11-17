package br.edu.infnet.app.testes;

public class StringTeste {

	public static void main(String[] args) {
		
		String nome = "Elberth Lins Costa de Moraes";
		
		System.out.println("Nome: " + nome);
		
		System.out.println("CharAt [" + nome.charAt(8) + "]");
		
		String nomeUp = nome.toUpperCase();		
		System.out.println("Nome: " + nome);
		System.out.println("NomeUp: " + nomeUp);

		String nomeLow = nome.toLowerCase();		
		System.out.println("Nome: " + nome);
		System.out.println("NomeLow: " + nomeLow);
		
		if(nome.equalsIgnoreCase(nomeUp)) {
			System.out.println("Nomes Iguals!");
		} else {
			System.out.println("Nomes Diferentes!");
		}
		
		System.out.println("Primeira ocorrência da letra e: " + nome.indexOf("e")); 
		System.out.println("Última ocorrência da letra e: " + nome.lastIndexOf("e"));
		System.out.println("Exibir a posição do espaço: " + nome.indexOf(" "));
		
		System.out.println("Substring com início 5: " + nome.substring(5));
		
		System.out.println("Substring Elberth: " + nome.substring(0,nome.lastIndexOf(" ")));
				
		String nomeErrado = " Elberth ";
		String sobrenomeErrado = " Moraes ";
		
		String nomeCompletoErrado = nomeErrado.trim() + " " + sobrenomeErrado.trim();
		
		System.out.println("Nome Errado: [" + nomeErrado + "]");
		System.out.println("Sobrenome Errado: [" + sobrenomeErrado + "]");		
		System.out.println("Nome Completo Errado: [" + nomeCompletoErrado + "]");

		System.out.println("Fim do Teste!!!");
	}
}

