package br.edu.infnet.applanche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.applanche.model.domain.Solicitante;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.SolicitanteService;

@Controller
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	private String msg;

	@GetMapping(value = "/solicitante")
	public String telaCadastro() {
		return "solicitante/cadastro";
	}	

	@GetMapping(value = "/solicitante/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("solicitantes", solicitanteService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "solicitante/lista";
	}

	@PostMapping(value = "/solicitante/incluir")
	public String incluir(Solicitante solicitante, @SessionAttribute("usuario") Usuario usuario) {
		
		solicitante.setUsuario(usuario);

		solicitanteService.incluir(solicitante);
		
		msg = "A inclusão do solicitante "+solicitante.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/solicitante/lista";
	}
		
	@GetMapping(value = "/solicitante/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		solicitanteService.excluir(id);
		
		msg = "A exclusão do solicitante ("+id+") foi realizada com sucesso!!!";

		return "redirect:/solicitante/lista";
	}
}