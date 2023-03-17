package br.edu.infnet.applanche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.applanche.model.domain.Pedido;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.PedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	private String msg;

	@GetMapping(value = "/pedido")
	public String telaCadastro() {
		return "pedido/cadastro";
	}	

	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("pedidos", pedidoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "pedido/lista";
	}
	
	@PostMapping(value = "/pedido/incluir")
	public String incluir(Pedido pedido, @SessionAttribute("usuario") Usuario usuario) {
		
		pedido.setUsuario(usuario);

		pedidoService.incluir(pedido);
		
		msg = "A inclusão do pedido "+pedido.getDescricao()+" foi realizada com sucesso!!!";
		
		return "redirect:/pedido/lista";
	}
		
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Pedido pedido = pedidoService.obterPorId(id);
		
		pedidoService.excluir(id);
		
		msg = "A exclusão do pedido "+pedido.getDescricao()+" foi realizada com sucesso!!!";

		return "redirect:/pedido/lista";
	}
}