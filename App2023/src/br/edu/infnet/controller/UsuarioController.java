package br.edu.infnet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Usuario;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"));
		usuario.setCaracteristicas(request.getParameterValues("caracteristicas"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setSetor(request.getParameter("setor"));
		usuario.setTipo(request.getParameter("tipo"));
		usuario.setIdade(Integer.valueOf(request.getParameter("idade")));
		usuario.setSalario(Float.valueOf(request.getParameter("salario")));

		System.out.println("Usuário: " + usuario);
		
		request.getRequestDispatcher("confirmacao.html").forward(request, response);
	}
}