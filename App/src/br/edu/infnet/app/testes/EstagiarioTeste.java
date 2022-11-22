package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Estagiario;

public class EstagiarioTeste {

	public static void main(String[] args) {
				
		Estagiario e1 = new Estagiario();
		e1.setFaculdade("Computação");
		e1.setIdade(20);
		e1.setNome("Estagiario Joao");
		e1.setPeriodo(6);
		e1.setSalario(400);
		e1.imprimir();

		Estagiario e2 = new Estagiario("Estagiario Joao", 20, 400f);
		e2.setFaculdade("Computação");
		e2.setPeriodo(6);
		e2.imprimir();

		Estagiario e3 = new Estagiario("Estagiario Joao", 20, 400f, "Computação");
		e3.setPeriodo(6);
		e3.imprimir();
	}
}