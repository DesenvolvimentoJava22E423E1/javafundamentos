package br.edu.infnet.app.tps;

import br.edu.infnet.app.dominio.Calculadora;

public class PBTP2 {

	public static void main(String[] args) {
		
		float num1 = 20;
		float num2 = 10;
		float result = 0;
		
		Calculadora calc = new Calculadora();
		calc.setNum1(num1);
		calc.setNum2(num2);
		
		result = calc.somar();		
		System.out.println("Soma = " + result);		

		result = calc.subtrair();		
		System.out.println("Subtra��o = " + result);		

		result = calc.multiplicar();		
		System.out.println("Multiplica��o = " + result);		

		result = calc.dividir();		
		System.out.println("Divis�o = " + result);		

		//TODO Atuar na cria��o do m�todo calcular
		//result = calc.calcular();		
		//System.out.println("Divis�o = " + result);		
	}
}