package br.edu.infnet.app.testes; 

public class Primeiro {
	
	private static String nome = "Sr";
	private static String sobrenome;
	private static int idade;
	private static float salario;
	private static boolean javaDev;
	private static int meses;
	
	private static boolean validar(int quantidade){		
		return quantidade == 6;
	}
	
	private static int calcularAnoNascimento(int aIdade){
		return 2022 - aIdade;
	}
	
	private static float calcularSalarioTotal(float oSalario, int osMeses){
		return oSalario * osMeses;
	}

	private static String obterSituacao(int aIdade){
		return aIdade < 50 ? "iniciante" : "veterano";
	}
	
	private static String obterStatus(float oSalarioTotal){
		if(oSalarioTotal > 10000){
			return "estavel";
		}
		return "instavel";
	}
	
	private static void tratarParametros(String[] argumento){
		nome = argumento[0];
		sobrenome = argumento[1];
		idade = Integer.valueOf(argumento[2]);
		salario = Float.valueOf(argumento[3]);
		javaDev = Boolean.valueOf(argumento[4]);
		meses = Integer.valueOf(argumento[5]);
	}
	
	private static void imprimir(){
		
		int anoNascimento = calcularAnoNascimento(idade);		
		float salarioTotal = calcularSalarioTotal(salario, meses);
		String situacao = obterSituacao(idade);
		String status = obterStatus(salarioTotal);		
		
		System.out.println("Nome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("Salario: " + salario);
		System.out.println("Dev: " + javaDev);
		System.out.println("Ano Nascimento: " + anoNascimento);
		System.out.println("Salario Total: " + salarioTotal);
		System.out.println("Situacao: " + situacao);
		System.out.println("Status: " + status);
	}

	public static void main(String[] args){
		int qtde = args.length;

		boolean validado = validar(qtde);

		if(validado){
			tratarParametros(args);
			
			imprimir();
		} else {
			System.out.println(nome + ", impossivel exibir o relatorio: " + qtde + "!");
		}
	}	
}