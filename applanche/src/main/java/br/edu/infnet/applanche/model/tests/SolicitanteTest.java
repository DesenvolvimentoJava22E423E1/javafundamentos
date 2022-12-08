package br.edu.infnet.applanche.model.tests;

import br.edu.infnet.applanche.model.domain.Solicitante;
import br.edu.infnet.applanche.model.exceptions.SolicitanteInvalidoException;

public class SolicitanteTest {

	public static void main(String[] args) {

		try {
			Solicitante s1 = new Solicitante("huguinho", "12312312312", "hugo@hugo.com");
			System.out.println(s1);
		} catch (SolicitanteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Solicitante s2 = new Solicitante(null, "12312312312", "ze@ze.com");
			System.out.println(s2);
		} catch (SolicitanteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Solicitante s3 = new Solicitante("luizinho", null, "luiz@luiz.com");
			System.out.println(s3);
		} catch (SolicitanteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Solicitante s3 = new Solicitante("luizinho", "12312312312", null);
			System.out.println(s3);
		} catch (SolicitanteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}