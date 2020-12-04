package com.sistemaDeInventario.historico;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sistemaDeInventario.produto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class historicoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7158247152632102670L;

	private Integer id;

	@NotBlank(message = "Campo obsedestinorvacao Inválido")
	private String destino;

	@NotBlank(message = "Campo observacao Inválido")
	private String observacao;

	@NotNull(message = "Campo emUso Inválido")
	private Boolean emUso;

	@NotNull(message = "Campo dataMovimento Não pode ser nulo")
	private LocalDateTime dataMovimento;

	private produto produto;

	public historico historicoRequest() {
		return new historico(id, destino, observacao, emUso, dataMovimento, produto);
	}
}
