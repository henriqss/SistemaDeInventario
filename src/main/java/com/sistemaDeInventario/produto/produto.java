package com.sistemaDeInventario.produto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3582052777985159071L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Column(name = "nome_produto")
	private String nomeProduto;

	@NotNull
	@Column(name = "data_tombamento")
	private LocalDateTime dataTombamento;

	@NotNull
	@Column(name = "lote")
	private String lote;

	@NotNull
	@Column(name = "registro_tombamento", unique = true)
	private String registroTombamento;

}
