package br.edu.infnet.app.testes;

import java.util.Scanner;

public class Terceiro {

	private static String[] nomes;
	private static int[] idades;
	private static float[] salarios;

	private static final int TAMANHO = 5;		
		
	private static void imprimir() {		
		for (int i = 0; i < TAMANHO; i++) {
			if(nomes[i] != null) {
				System.out.println("- " + nomes[i] + " - " + idades[i] + " - " + salarios[i]);
			}
		}
	}

	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		idades = new int[TAMANHO];
		salarios = new float[TAMANHO];

		int qtde = Integer.valueOf(args[0]);
				
		Scanner in = new Scanner(System.in);

		if(qtde <= TAMANHO) {
			for (int i = 0; i < qtde; i++) {
				System.out.print("Informe o seu nome: ");	
				nomes[i] = in.next();

				System.out.print("Informe a sua idade: ");	
				idades[i] = in.nextInt();

				System.out.print("Informe o seu salario: ");	
				salarios[i] = in.nextFloat();
			}

			imprimir();
		} else {
			System.out.println("Impossível realizar o cadastramento!!!");
		}
				
		in.close();
	}
}