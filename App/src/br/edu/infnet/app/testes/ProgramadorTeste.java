package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Programador;

public class ProgramadorTeste {

	public static void main(String[] args) {

		Programador p1 = new Programador("Huguinho", 20);
		p1.setDevFull(false);
		p1.setLinguagem("Java");
		p1.setSalario(1000);
		p1.imprimir();

		Programador p2 = new Programador("Aninha", 40, 2000, "Delphi", true);
		p2.imprimir();
		
		System.out.println("Processo finalizado!!!");
	}
}
