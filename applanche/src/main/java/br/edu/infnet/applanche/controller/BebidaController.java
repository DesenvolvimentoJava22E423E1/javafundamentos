package br.edu.infnet.applanche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.applanche.model.domain.Bebida;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.BebidaService;

@Controller
public class BebidaController {
	
	@Autowired
	private BebidaService bebidaService;

	private String msg;

	@GetMapping(value = "/bebida")
	public String telaCadastro() {
		return "bebida/cadastro";
	}	

	@GetMapping(value = "/bebida/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("bebidas", bebidaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "bebida/lista";
	}
	
	@PostMapping(value = "/bebida/incluir")
	public String incluir(Bebida bebida, @SessionAttribute("usuario") Usuario usuario) {
		
		bebida.setUsuario(usuario);

		bebidaService.incluir(bebida);
		
		msg = "A inclusão da bebida "+bebida.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/bebida/lista";
	}
		
	@GetMapping(value = "/bebida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Bebida bebida = bebidaService.obterPorId(id);
		
		bebidaService.excluir(id);
		
		msg = "A exclusão da bebida "+bebida.getNome()+" foi realizada com sucesso!!!";

		return "redirect:/bebida/lista";
	}
}