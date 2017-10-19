package com.medeiros.ordnael.selectfactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SelectPessoa {

	private EntityManager em;
	private SelectPessoaWhere where;
	private SelectPessoaJoin join;
	private SelectPessoaOrder order;

	private String sqlDistinct = "";
	private String sqlWhere = "";
	private String sqlJoin = "";
	private String sqlOrder = "";
	
	public SelectPessoa(EntityManager em) {
		this.em = em;
		this.where = new SelectPessoaWhere(this);
		this.join = new SelectPessoaJoin(this);
		this.order = new SelectPessoaOrder(this);
	}

	public <T> List<T> list(Class<T> classe) {
		
		Field[] fields = classe.getDeclaredFields();
		
		String sqlFields = "*";
		String sField;
		
		for (Field field : fields) {
			Column aColumn = field.getAnnotation(Column.class);
			if (aColumn!=null) {
				sField = aColumn.name();
			} else {
				sField = field.getName();
			}
			if (sqlFields.equals("*")) {
				sqlFields = sField;
			} else {
				sqlFields += ", "+sField;
			}
		}
		
		for (String texto : orders) {
			if (texto!=null) {
				if (sqlOrder.equals("")) {
					sqlOrder = " order by " + texto;
				} else {
					sqlOrder += "," + texto;
				}
			}
		}
		
		String sql = "select "+sqlDistinct+" "+sqlFields+" from pessoa " + sqlJoin + " " + sqlWhere + " " + sqlOrder;
		
		Query query = em.createNativeQuery(sql);
		List<Object[]> list = query.getResultList();
		
		List<T> listReturn = new ArrayList<>();
		
		list.forEach(o->{
			try {
				
				T item = classe.newInstance();
				
				String ssField;
				for (int i=0; i<fields.length; i++) {
					if (o[i]!=null) {
						Column aColumn = fields[i].getAnnotation(Column.class);
						if (aColumn!=null) {
							ssField = aColumn.name();
						} else {
							ssField = fields[i].getName();
						}
						fields[i].setAccessible(true);
						if (fields[i].getType().equals(Long.class)) {
							fields[i].set(item, Long.valueOf(o[i].toString()));
						} else {
							fields[i].set(item, o[i]);
						}
					}
				}
				
				listReturn.add(item);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		
		return listReturn;
	}

	public SelectPessoaWhere where() {
		return where;
	}
	
	public void addFilter(String filter) {
		if (sqlWhere.equals("")) {
			sqlWhere = " where " + filter;
		} else {
			sqlWhere += " and " + filter;
		}
	}
	
	private String[] orders = new String[100];
	
	public void addOrder(int position, String field) {
		orders[position] = field;
	}

	public void addJoin(String sql) {
		sqlJoin += sql;
	}


	public SelectPessoaJoin join() {
		return join;
	}

	public SelectPessoa distinct() {
		sqlDistinct = "distinct";
		return this;
	}

	public SelectPessoaOrder order() {
		return order;
	}

}
