package com.medeiros.ordnael.selectfactory.database.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoaId", nullable=false, foreignKey=@ForeignKey(name="fk_telefone_pessoa"))
	private Pessoa pessoa;
	
	@Column(length=200)
	private String tipo;
	
	@Column(length=200)
	private String numero;
	
}