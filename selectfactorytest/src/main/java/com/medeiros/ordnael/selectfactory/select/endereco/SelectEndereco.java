package com.medeiros.ordnael.selectfactory.select.endereco;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.selectfactory.select.SelectField;
import com.medeiros.ordnael.selectfactory.select.SelectTable;

public class SelectEndereco extends SelectTable {

	public static SelectField<Long> ID = new SelectField<Long>("id");
	public static SelectField<Long> PESSOA = new SelectField<Long>("pessoaId");
	public static SelectField<String> BAIRRO = new SelectField<String>("bairro");
	public static SelectField<String> RUA = new SelectField<String>("rua");
	public static SelectField<String> NUMERO = new SelectField<String>("numero");
	
	public SelectEndereco(EntityManager em, SelectField<?> ...campos) {
		super(em, campos);
	}

	@Override
	public String getTableName() {
		return "endereco";
	}
	
}
