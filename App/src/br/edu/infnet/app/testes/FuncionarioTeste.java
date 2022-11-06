package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Funcionario;

public class FuncionarioTeste {

	public static void main(String[] args) {

		Funcionario f1 = new Funcionario();
		f1.idade = 44;
		f1.salario = 1000;
		f1.bonus = 200;
		f1.desconto = 300;
		f1.imprimir();

		Funcionario f2 = new Funcionario(null, 44);
		f2.salario = 1000;
		f2.bonus = 200;
		f2.desconto = 300;
		f2.imprimir();

		Funcionario f3 = new Funcionario("Elberth", 44, 1000, 200, 300);
		f3.imprimir();
	}
}