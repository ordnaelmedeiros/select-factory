package com.medeiros.ordnael.selectfactory;

import java.util.List;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.selectfactory.database.EntityManagerUtil;

public class App {

	public static void main(String[] args) {
		
		EntityManager em = new EntityManagerUtil().getEntityManager();
		
		
		List<?> list = 
				new SelectPessoa(em).distinct()
				.join()
					.telefone().left()//.notImplicit()
						//.tipo().equal("fixo")
					.end()
				.end()
				.where()
					//.id().equal(1l)
					.nome().contains("a")
				.end()
				.order()
					.nome(1)
				.end()
				.list(PessoaFull.class);
		
		if (list!=null) {
			list.forEach(p->{
				System.out.println(p);
			});
		} else {
			System.out.println("Lista Null");
		}
		
		/*
		System.out.println("1");
		List<Pessoa> list = 
				new SelectPessoa(em)
				.where()
					.ID().equal(1l)
				.end()
				.list(Pessoa.class);
		
		list.forEach(p->System.out.println(p.getNome()));
		
		
		System.out.println("\n2");
		list = 
				new SelectPessoa(em)
				.where()
					.ID().notEqual(2l)
					.NOME().notEqual("Leandro")
				.end()
				.list(Pessoa.class);
			
		list.forEach(p->System.out.println(p.getNome()));
		
		System.out.println("\n3");
		list = 
				new SelectPessoa(em)
				.join()
					.endereco()
					.end()
				.end()
				.where()
					//.ID().notEqual(2l)
					.NOME().notEqual("Leandro")
				.end()
				.list(Pessoa.class);
			
		list.forEach(p->System.out.println(p.getNome()));
		*/
	}
}
