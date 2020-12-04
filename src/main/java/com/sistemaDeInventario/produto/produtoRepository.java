package com.sistemaDeInventario.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produtoRepository extends JpaRepository<produto, Integer> {

	List<produto> findByOrderByDataTombamento();

	List<produto> findByNomeProdutoLikeIgnoreCase(String nomeProduto);

	List<produto> findByLoteLikeIgnoreCase(String lote);

	List<produto> findByRegistroTombamentoLikeIgnoreCase(String registroTombamento);

}
