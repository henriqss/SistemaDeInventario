package com.sistemaDeInventario.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class produtoController {

	@Autowired
	private produtoService ProdutoService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@Validated @RequestBody produtoRequest Produto) {
		return ProdutoService.save(Produto);
	}

	@GetMapping("/getByOrderByDataTombamento")
	public List<produto> getByOrderByDataTombamento() {
		return ProdutoService.getByOrderByDataTombamento();
	}

	@GetMapping("/getdByNomeProduto")
	public List<produto> getdByNomeProduto(@Param("nomeProduto") String nomeProduto ) {
		return ProdutoService.getdByNomeProduto(nomeProduto);
	}

	@GetMapping("/getdByLote")
	public List<produto> getdByLote(
			@Param("lote") String lote) {
		return ProdutoService.getdByLote( lote);
	}

	@GetMapping("/getdByRegistroTombamento")
	public List<produto> getdByRegistroTombamento( @Param("registroTombamento") String registroTombamento) {
		return ProdutoService.getdByRegistroTombamento(registroTombamento);
	}
}
