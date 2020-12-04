package com.sistemaDeInventario.historico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico")
public class historicoController {

	@Autowired
	private historicoService HistoricoService;

	@GetMapping("/getProdutoIdOrderByDataMovimento")
	public List<historico> getProdutoIdOrderByDataMovimento(@RequestParam("id") Integer id) {
		return HistoricoService.getProdutoIdOrderByDataMovimento(id);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@Validated @RequestBody historicoRequest Historico) {
		return HistoricoService.save(Historico);
	}

}
