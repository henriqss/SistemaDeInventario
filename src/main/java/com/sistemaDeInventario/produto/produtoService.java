package com.sistemaDeInventario.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class produtoService {

	@Autowired
	private produtoRepository ProdutoRepository;

	public ResponseEntity<String> save(produtoRequest produto) {
		try {
			ProdutoRepository.save(produto.produtoRequest());
			return new ResponseEntity<>("Produto Cadastrado Com Sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public List<produto> getByOrderByDataTombamento() {
		return ProdutoRepository.findByOrderByDataTombamento();
	}

	public List<produto> getdByNomeProduto(String nomeProduto) {
		return ProdutoRepository.findByNomeProdutoLikeIgnoreCase(nomeProduto);
	}

	public List<produto> getdByLote(String lote) {
		return ProdutoRepository.findByLoteLikeIgnoreCase(lote);
	}

	public List<produto> getdByRegistroTombamento(String registroTombamento) {
		return ProdutoRepository.findByRegistroTombamentoLikeIgnoreCase(registroTombamento);
	}

}