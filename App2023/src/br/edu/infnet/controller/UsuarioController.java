package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.repository.UsuarioRepository;

public class UsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public UsuarioController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario(
								request.getParameter("nome"), 
								request.getParameter("email"),
								request.getParameter("senha")
							);
		usuario.setCaracteristicas(request.getParameterValues("caracteristicas"));
		usuario.setSetor(request.getParameter("setor"));
		usuario.setTipo(request.getParameter("tipo"));
		usuario.setIdade(Integer.valueOf(request.getParameter("idade")));
		usuario.setSalario(Float.valueOf(request.getParameter("salario")));

		UsuarioRepository.incluir(usuario);
		
		List<Usuario> lista = UsuarioRepository.obterLista();
		
		System.out.println("Quantidade de usuários = " + lista.size());

		for(Usuario user : lista) {
			System.out.println("A inclusão do usuário "+user.getNome()+" foi realizada com sucesso!");
		}
		
		request.getRequestDispatcher("lista.html").forward(request, response);
	}
}