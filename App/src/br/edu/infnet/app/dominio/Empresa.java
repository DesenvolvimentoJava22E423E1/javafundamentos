package br.edu.infnet.app.dominio;

import br.edu.infnet.app.exceptions.FaturamentoInvalidoException;
import br.edu.infnet.app.exceptions.NomeIncompletoException;

public class Empresa {

	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private float faturamento;
	private Funcionario[] funcionarios;

	@Override
	public String toString() {
		return nome + ";" + sobrenome + ";" + ultimoNome + ";" + faturamento;
	}
	
	private float calcularFolhaSalarial() {
		float folhaSalarial = 0;
		if(funcionarios != null) {
			for(Funcionario func : funcionarios) {
				folhaSalarial = folhaSalarial + func.calcularSalarioLiquido();
			}
		}
		return folhaSalarial;
	}
	
	private void impressaoFuncionarios() {
		if(funcionarios != null) {
			System.out.println("Funcionários:");
	
			for (Funcionario funcionario : funcionarios) {
				System.out.printf("%s - %d - %.2f\n", 
							funcionario.getNome(),
							funcionario.getIdade(),
							funcionario.getSalario()
						);
			}
		}
	}
	
	private int calcularQtdeFuncionarios() {
		return funcionarios != null ? funcionarios.length : 0;
	}
	
	public void imprimir() throws NomeIncompletoException {
		System.out.println("Empresa: " + getNome());
		
		System.out.println("Qtde Funcionários: " + calcularQtdeFuncionarios());

		System.out.println("Folha salarial: R$" + calcularFolhaSalarial());
		
		impressaoFuncionarios();
	}

	public String getNome() throws NomeIncompletoException {
		
		if(nome == null || sobrenome == null || ultimoNome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ultimoNome.toUpperCase().charAt(0));
		sb.append(".");
		sb.append(",");
		sb.append(" ");
		sb.append(nome.toUpperCase());
		sb.append(" ");
		sb.append(sobrenome.toLowerCase());
		sb.append(".");
		
		return sb.toString();
	}
	
	public void setNome(String nome) throws NomeIncompletoException {
		
		if(nome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto");
		}
		
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");
		
		if(posInicial < 0 || posFinal < 0) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' está incorreto");
		}

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial, posFinal).trim();
		this.ultimoNome = nome.substring(posFinal).trim();
	}	
	public void setFaturamento(float faturamento) throws FaturamentoInvalidoException {
		
		if(faturamento < 0) {
			throw new FaturamentoInvalidoException("O valor do faturamento precisa positivo");
		}
		
		this.faturamento = faturamento;
	}
	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
}