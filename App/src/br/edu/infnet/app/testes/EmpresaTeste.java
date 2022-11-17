package br.edu.infnet.app.testes;

import br.edu.infnet.app.dominio.Administrativo;
import br.edu.infnet.app.dominio.Empresa;
import br.edu.infnet.app.dominio.Funcionario;
import br.edu.infnet.app.dominio.Programador;

public class EmpresaTeste {

	public static void main(String[] args) {
		
		Administrativo a1 = new Administrativo();
		a1.setIdade(44);
		a1.setSalario(1000);
		a1.setBonus(200);
		a1.setDesconto(300);
		
		Programador p1 = new Programador("Huguinho", 20);
		p1.setDevFull(false);
		p1.setLinguagem("Java");
		p1.setSalario(1000);

		Administrativo a3 = new Administrativo("Elberth", 44, 1000, 200, 300);
		
		Programador p2 = new Programador("Aninha", 40, 2000, "Delphi", true);
		
		Funcionario[] empresaFuncs = new Funcionario[4];
		
		empresaFuncs[0] = a1;
		empresaFuncs[1] = p1;
		empresaFuncs[2] = a3;
		empresaFuncs[3] = p2;
		
		Empresa empresaElberth = new Empresa();
		empresaElberth.setNome("empresa elberth moraes");
		empresaElberth.setFuncionarios(empresaFuncs);
		empresaElberth.imprimir();
		
		Empresa infnet = new Empresa();
		infnet.setNome("instituto infnet java");
		infnet.imprimir();
	}
}
