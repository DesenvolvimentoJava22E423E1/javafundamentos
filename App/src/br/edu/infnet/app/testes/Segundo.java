package br.edu.infnet.app.testes;

import java.util.Scanner;

public class Segundo {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Informe o seu nome: ");
		String nome = in.next();		
		System.out.print("Informe o seu idade: ");
		int idade = in.nextInt();		
		System.out.print("Informe o seu salario: ");
		float salario = in.nextFloat();		
		
		System.out.println(nome + " - " + idade + " - " + salario);
				
		System.out.println("#foreach");
		for(String n : args){
			System.out.println(n);
		}

		System.out.println("#for tradicional");
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i]);
		}
		
		System.out.println("#while");
		int a = 0;
		while(a < args.length){
			System.out.println(args[a]);			
			a++;
		}
		
		System.out.println("#dowhile");
		int b = 0;
		do {
			System.out.println(args[b]);			
			b++;
		}while(b < args.length);
		
		in.close();
	}
}