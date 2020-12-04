package com.sistemaDeInventario.produto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class produtoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665763671138708260L;

	private Integer id;

	@NotBlank(message = "Campo nomeProduto Inválido")
	private String nomeProduto;

	@NotNull(message = "Campo dataTombamento Não pode ser nulo")
	private LocalDateTime dataTombamento;

	@NotBlank(message = "Campo lote Inválido")
	private String lote;

	@NotBlank(message = "Campo registroTombamento Inválido")
	private String registroTombamento;

	public produto produtoRequest() {
		return new produto(id, nomeProduto, dataTombamento, lote, registroTombamento);
	}

}
