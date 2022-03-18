package com.reguera.springvs.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbProduto")
public class Produto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@Column( nullable = false, length =255)
	private String descricao;
	
	@Column(nullable = false, length = 10)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataValidade;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Marca marca;

	

	
	
	
	
	
}
