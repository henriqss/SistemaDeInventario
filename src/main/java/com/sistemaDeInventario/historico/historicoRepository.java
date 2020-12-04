package com.sistemaDeInventario.historico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface historicoRepository extends JpaRepository<historico, Integer> {

	List<historico> findByProdutoIdOrderByDataMovimentoDesc(Integer id);

}
