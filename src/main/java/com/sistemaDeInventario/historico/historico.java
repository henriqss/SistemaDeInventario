package com.sistemaDeInventario.historico;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sistemaDeInventario.produto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class historico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8503894414992684959L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "Campo destino Inválido")
	@Column(name = "destino")
	private String destino;

	@NotBlank(message = "Campo observacao Inválido")
	@Column(name = "observacao")
	private String observacao;

	@NotNull(message = "Campo emUso Inválido")
	@Column(name = "em_uso")
	private Boolean emUso;

	@NotNull(message = "Campo dataMovimento Não pode ser nulo")
	@Column(name = "data_movimento")
	private LocalDateTime dataMovimento;

	@JoinColumn(name = "produto", referencedColumnName = "id")
	@OneToOne
	private produto produto;

}
