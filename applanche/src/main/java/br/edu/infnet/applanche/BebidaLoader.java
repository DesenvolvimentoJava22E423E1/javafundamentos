package br.edu.infnet.applanche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.applanche.model.domain.Bebida;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.exceptions.TamanhoBebidaInvalidoException;
import br.edu.infnet.applanche.model.exceptions.ValorZeradoException;
import br.edu.infnet.applanche.model.service.BebidaService;

@Order(3)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario admin = new Usuario();
		admin.setId(1);
		
		try {
			Bebida bebida = new Bebida("b1caf5", "cafezin", 5, "Cooooffeeee");
			bebida.setGelada(false);
			bebida.setTamanho(500);
			bebida.setUsuario(admin);
			System.out.println(bebida);
			System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

			bebidaService.incluir(bebida);
		} catch (ValorZeradoException | TamanhoBebidaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida bebida = new Bebida("b1caf5", "cafezin", 5, "Cooooffeeee");
			bebida.setGelada(false);
			bebida.setTamanho(500);
			bebida.setUsuario(admin);
			System.out.println(bebida);
			System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

			bebidaService.incluir(bebida);
		} catch (ValorZeradoException | TamanhoBebidaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Bebida bebida = new Bebida("b1caf5", "cafezin", 5, "Cooooffeeee");
			bebida.setGelada(false);
			bebida.setTamanho(500);
			System.out.println(bebida);
			bebida.setUsuario(admin);
			System.out.println("Valor de Venda = R$" + bebida.calcularValorVenda());

			bebidaService.incluir(bebida);
		} catch (ValorZeradoException | TamanhoBebidaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Bebidas:");
		for(Bebida bebida : bebidaService.obterLista()) {
			System.out.printf("%d - %s - %s\n", 
					bebida.getId(),
					bebida.getNome(),
					bebida.getMarca()
				);
		}
	}
}