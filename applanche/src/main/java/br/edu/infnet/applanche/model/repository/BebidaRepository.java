package br.edu.infnet.applanche.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.applanche.model.domain.Bebida;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

	@Query("from Bebida b where b.usuario.id = :userId")
	List<Bebida> obterLista(Integer userId);
}