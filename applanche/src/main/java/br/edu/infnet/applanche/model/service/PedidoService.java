package br.edu.infnet.applanche.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.applanche.model.domain.Pedido;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido incluir(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Collection<Pedido> obterLista(){
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public Collection<Pedido> obterLista(Usuario usuario){
		return (Collection<Pedido>) pedidoRepository.obterLista(usuario.getId());
	}

	public Pedido obterPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
}