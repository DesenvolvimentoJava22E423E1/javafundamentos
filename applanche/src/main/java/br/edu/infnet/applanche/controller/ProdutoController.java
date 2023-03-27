package br.edu.infnet.applanche.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.applanche.model.domain.Produto;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	private String msg;

	@GetMapping(value = "/produto/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("produtos", produtoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "produto/lista";
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Produto produto = produtoService.obterPorId(id);
		
		try {
			produtoService.excluir(id);
			
			msg = "A exclusão do produto "+produto.getNome()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do produto "+produto.getNome()+"!!!";
		}
		
		return "redirect:/produto/lista";
	}
}