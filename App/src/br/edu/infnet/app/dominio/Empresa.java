package br.edu.infnet.app.dominio;

public class Empresa {

	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private Funcionario[] funcionarios;

	@Override
	public String toString() {
		return getNome();
		//return nome + ";" + sobrenome + ";" + ultimoNome;
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
	
	public void imprimir() {
		System.out.println("Empresa: " + this);
		
		System.out.println("Qtde Funcionários: " + calcularQtdeFuncionarios());

		System.out.println("Folha salarial: R$" + calcularFolhaSalarial());
		
		impressaoFuncionarios();
	}

	public String getNome() {

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
	public void setNome(String nome) {
		
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial, posFinal).trim();
		this.ultimoNome = nome.substring(posFinal).trim();
	}	
	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
}