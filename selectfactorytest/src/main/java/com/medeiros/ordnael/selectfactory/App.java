package com.medeiros.ordnael.selectfactory;

import static com.medeiros.ordnael.selectfactory.select.pessoa.SelectPessoa.ID;
import static com.medeiros.ordnael.selectfactory.select.pessoa.SelectPessoa.NOME;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Table;

import com.medeiros.ordnael.selectfactory.database.EntityManagerUtil;
import com.medeiros.ordnael.selectfactory.database.SearchClass;
import com.medeiros.ordnael.selectfactory.database.entitys.Endereco;
import com.medeiros.ordnael.selectfactory.database.entitys.Pessoa;
import com.medeiros.ordnael.selectfactory.select.endereco.SelectEndereco;
import com.medeiros.ordnael.selectfactory.select.pessoa.SelectPessoa;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Hello World!");

		try {
			
			EntityManager em = new EntityManagerUtil().getEntityManager();
			
			List<Class<?>> byAnnotation = new SearchClass("com.medeiros.ordnael.selectfactory.database.entitys").byAnnotation(Table.class);
			for (Class<?> class1 : byAnnotation) {
				System.out.println(class1.getName());
			}
			
			System.out.println("Pessoa");
			
			List<Pessoa> list = new SelectPessoa(em, ID, NOME).where(ID.ne(2l), NOME.eq("Leandro")).list(Pessoa.class);
			
			for (Pessoa pes : list) {
				System.out.println(pes.getId() + " - " + pes.getNome());
			}
			
			System.out.println("");
			System.out.println("Endereço");
			List<Endereco> listEnd = new SelectEndereco(em, SelectEndereco.ID, SelectEndereco.BAIRRO, SelectEndereco.RUA, SelectEndereco.NUMERO).list(Endereco.class);
			for (Endereco ed : listEnd) {
				System.out.println(ed.getId() + " - " + ed.getBairro()+ " - " + ed.getRua()+ " - " + ed.getNumero());
			}
			
			System.out.println("");
			System.out.println("Pessoa com Endereço");
			List<PessoaEndereco> listPesEnd = 
					new SelectPessoa(em, ID.setAlias("pessoaId"), NOME)
					.addLeftJoinEndereco(SelectEndereco.ID.setAlias("enderecoId"), SelectEndereco.BAIRRO, SelectEndereco.RUA, SelectEndereco.NUMERO)
					.list(PessoaEndereco.class);
			
			for (PessoaEndereco pesEnd : listPesEnd) {
				System.out.println(pesEnd.getId() + " - " + pesEnd.getNome() + " - " + pesEnd.getEnderecoId() + " - " + pesEnd.getBairro() + " - " + pesEnd.getRua() + " - " + pesEnd.getNumero());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Final");

	}
}