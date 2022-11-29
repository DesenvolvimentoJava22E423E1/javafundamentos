package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Contato;

public class ContatoTeste {

	public static void main(String[] args) {

		Contato c1 = new Contato();
		c1.setEmail("elberth@gmail.com");
		c1.setTelefone("21999988888");
		c1.imprimir();
	}
}
