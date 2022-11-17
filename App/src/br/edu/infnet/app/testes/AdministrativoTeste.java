package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Administrativo;

public class AdministrativoTeste {

	public static void main(String[] args) {

		Administrativo a1 = new Administrativo();
		a1.setIdade(44);
		a1.setSalario(1000);
		a1.setBonus(200);
		a1.setDesconto(300);
		a1.imprimir();

		Administrativo a2 = new Administrativo(null, 44);
		a2.setSalario(1000);
		a2.setBonus(200);
		a2.setDesconto(300);
		a2.imprimir();

		Administrativo a3 = new Administrativo("Elberth", 44, 1000, 200, 300);
		a3.imprimir();
	}
}