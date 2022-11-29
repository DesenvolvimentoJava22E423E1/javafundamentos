package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Contato;
import br.edu.infnet.app.dominio.Dirigente;

public class DirigenteTeste {

	public static void main(String[] args) {
		
		Contato c1 = new Contato();
		c1.setEmail("elberth@gmail.com");
		c1.setTelefone("21999988888");

		Dirigente d1 = new Dirigente();
		d1.setAnoInicio(2010);
		d1.setContato(c1);
		d1.setEhPresidente(false);
		d1.setNome("Juninho");
		d1.imprimir();
	}
}
