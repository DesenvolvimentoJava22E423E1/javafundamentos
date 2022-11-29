package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.ComissaoTecnica;

public class ComissaoTecnicaTeste {

	public static void main(String[] args) {

		ComissaoTecnica ct1 = new ComissaoTecnica();
		ct1.setEhTreinador(true);
		ct1.setNome("Tite");
		ct1.setQtdeTitulo(9);
		ct1.imprimir();
	}
}
