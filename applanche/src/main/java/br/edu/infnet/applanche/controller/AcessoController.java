package br.edu.infnet.applanche.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/login")
	public String telaLogin() {

		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email, senha);
		
		user = usuarioService.autenticar(user);

		if(user != null) {
			model.addAttribute("usuario", user);
			
			return "redirect:/home";
		}
		
		model.addAttribute("mensagem", "As credenciais para o e-mail "+ email +" estão incorretas!");

		return telaLogin();
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		
		session.removeAttribute("usuario");
		
		return "redirect:/";
	}
}