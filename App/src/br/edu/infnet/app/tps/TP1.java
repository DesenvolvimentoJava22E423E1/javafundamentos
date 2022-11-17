package br.edu.infnet.app.tps;

import java.util.Scanner;

public class TP1 {

	private static String[] nomes;
	private static int[] idades;
	private static float[] salarios;
	private static float[] bonus;
	private static float[] descontos;

	private static final int TAMANHO = 4; 		

	private static void imprimir() {		
		for (int i = 0; i < TAMANHO; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}

	private static void imprimir(int indice) {
		float salarioLiquido = calcularSalarioLiquido(indice);
		
		System.out.println("<"+indice+"> " + 
							nomes[indice] + " * " + 
							idades[indice] + " * " + 
							salarioLiquido + " * " +
							obterSituacao(salarioLiquido)
							);
	}
	
	private static float calcularSalarioLiquido(int indice){
		return salarios[indice] + bonus[indice] - descontos[indice];
	}
	
	private static String obterSituacao(float sl){		
		if(sl >= 100000) {
			return "Rico";
		}		
		return "Pobre";
	}

	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		idades = new int[TAMANHO];
		salarios = new float[TAMANHO];
		bonus = new float[TAMANHO];
		descontos = new float[TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar um");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opção desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					System.out.print("Informe o seu nome: ");	
					nomes[pos] = in.next();
	
					System.out.print("Informe a sua idade: ");	
					idades[pos] = in.nextInt();
	
					System.out.print("Informe o seu salário: ");	
					salarios[pos] = in.nextFloat();
					
					System.out.print("Informe o seu bônus: ");	
					bonus[pos] = in.nextFloat();

					System.out.print("Informe o seu desconto: ");	
					descontos[pos] = in.nextFloat();
					
					imprimir(pos);

					pos++;
				} else {
					System.out.println("Impossível realizar um novo cadastramento!");
				}
				break;

			case "2":
				System.out.print("Informe o funcionário para impressão: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					imprimir(id);
				} else {
					System.out.println("O índice ["+id+"] é inválido!!!");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Saída");
				break;

			default:
				System.out.println("A opção ["+opcao+"] inválida");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
}