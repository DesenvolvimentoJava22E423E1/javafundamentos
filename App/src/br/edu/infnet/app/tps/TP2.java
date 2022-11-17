package br.edu.infnet.app.tps;

import java.util.Scanner;

import br.edu.infnet.app.auxiliar.Constante;
import br.edu.infnet.app.dominio.Administrativo;
import br.edu.infnet.app.dominio.Funcionario;
import br.edu.infnet.app.dominio.Programador;

public class TP2 {

	private static Funcionario[] funcionarios;

	private static void imprimir() {		
		for (int i = 0; i < Constante.TAMANHO; i++) {
			if(funcionarios[i] != null) {
				funcionarios[i].imprimir();
			}
		}
	}

	public static void main(String[] args) {

		funcionarios = new Funcionario[Constante.TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Cadastrar Administrativo");
			System.out.println("[2] Cadastrar Programador");
			System.out.println("[3] Consultar Funcion�rio");
			System.out.println("[4] Consultar todos");
			System.out.println("[5] Sair");
			
			System.out.print("Informe a op��o desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < Constante.TAMANHO) {
					
					Administrativo adm = new Administrativo();
					
					System.out.print("Informe o seu nome: ");	
					adm.setNome(in.next());
	
					System.out.print("Informe a sua idade: ");	
					adm.setIdade(in.nextInt());
	
					System.out.print("Informe o seu sal�rio: ");	
					adm.setSalario(in.nextFloat());
					
					System.out.print("Informe o seu b�nus: ");	
					adm.setBonus(in.nextFloat());

					System.out.print("Informe o seu desconto: ");	
					adm.setDesconto(in.nextFloat());
					
					funcionarios[pos] = adm;

					funcionarios[pos].imprimir();

					pos++;
				} else {
					System.out.println("Imposs�vel realizar um novo cadastramento!");
				}
				break;

			case "2":
				if(pos < Constante.TAMANHO) {
										
					System.out.print("Informe o seu nome: ");
					String nome = in.next();
						
					System.out.print("Informe a sua idade: ");
					int idade = in.nextInt();
										
					Programador prog = new Programador(nome, idade);
					
					System.out.print("Informe o seu sal�rio: ");	
					prog.setSalario(in.nextFloat());
					
					System.out.print("Informe se � fullstack: ");	
					prog.setDevFull(in.nextBoolean());

					System.out.print("Informe o sua linguagem principal: ");	
					prog.setLinguagem(in.next());
					
					funcionarios[pos] = prog;

					funcionarios[pos].imprimir();

					pos++;
				} else {
					System.out.println("Imposs�vel realizar um novo cadastramento!");
				}
				break;

			case "3":
				System.out.print("Informe o funcion�rio para impress�o: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					funcionarios[id].imprimir();
				} else {
					System.out.println("O �ndice ["+id+"] � inv�lido!!!");
				}
				break;

			case "4":
				imprimir();
				break;

			case "5":
				System.out.println("Sa�da");
				break;

			default:
				System.out.println("A op��o ["+opcao+"] inv�lida");
				break;
			}
		} while (!"5".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
}