package com.sistemaDeInventario.historico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class historicoService {

	@Autowired
	historicoRepository HistoricoRepository;

	public List<historico> getProdutoIdOrderByDataMovimento(Integer id) {
		return HistoricoRepository.findByProdutoIdOrderByDataMovimentoDesc(id);
	}

	public ResponseEntity<String> save(historicoRequest historico) {
		try {
			HistoricoRepository.save(historico.historicoRequest());
			return new ResponseEntity<>("Produto Cadastrado Com Sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}