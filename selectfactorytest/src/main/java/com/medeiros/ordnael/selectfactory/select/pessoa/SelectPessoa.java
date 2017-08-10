package com.medeiros.ordnael.selectfactory.select.pessoa;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.selectfactory.select.JoinTable;
import com.medeiros.ordnael.selectfactory.select.SelectField;
import com.medeiros.ordnael.selectfactory.select.SelectTable;
import com.medeiros.ordnael.selectfactory.select.endereco.SelectEndereco;

public class SelectPessoa extends SelectTable {

	public static SelectField<Long> ID = new SelectField<Long>("id");
	public static SelectField<String> NOME = new SelectField<String>("nome");
	
	public SelectPessoa(EntityManager em, SelectField<?> ...campos) {
		super(em, campos);
	}

	public SelectPessoa addJoinEndereco(SelectField<?> ...campos) {
		SelectEndereco sEndereco = new SelectEndereco(this.getEm(), campos);
		JoinTable joinTable = new JoinTable(sEndereco, " join endereco on endereco.pessoaId = pessoa.id ");
		this.addJoin(joinTable);
		return this;
	}
	
	public SelectPessoa addLeftJoinEndereco(SelectField<?> ...campos) {
		SelectEndereco sEndereco = new SelectEndereco(this.getEm(), campos);
		JoinTable joinTable = new JoinTable(sEndereco, " left join endereco on endereco.pessoaId = pessoa.id ");
		this.addJoin(joinTable);
		return this;
	}
	
	@Override
	public String getTableName() {
		return "pessoa";
	}
	
}
