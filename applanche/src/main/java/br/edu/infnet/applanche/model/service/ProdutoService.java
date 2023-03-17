package br.edu.infnet.applanche.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.applanche.model.domain.Produto;
import br.edu.infnet.applanche.model.domain.Usuario;
import br.edu.infnet.applanche.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public Collection<Produto> obterLista(Usuario usuario){
		return (Collection<Produto>) produtoRepository.obterLista(usuario.getId());
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
}