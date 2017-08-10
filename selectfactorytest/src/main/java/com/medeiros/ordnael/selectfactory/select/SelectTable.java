package com.medeiros.ordnael.selectfactory.select;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class SelectTable {

	private EntityManager em;
	private SelectField<?>[] campos;
	private WhereField<?>[] wheres;
	private List<JoinTable> joins = new ArrayList<>();
	
	public abstract String getTableName();
	
	public SelectField<?>[] getCampos() {
		return campos;
	}
	
	public SelectTable(EntityManager em, SelectField<?> ...campos) {
		this.setEm(em);
		this.campos = campos;
	}
	

	public SelectTable where(WhereField<?> ...wheres) {
		this.wheres = wheres;
		return this;
	}
	
	public SelectTable addJoin(JoinTable joinTable) {
		this.joins.add(joinTable);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> list(Class<E> classe) throws Exception {
	
		String sql = " select ";
		
		boolean first = true;
		
		for (SelectField<?> field : campos) {
			if (first) {
				first = false;
			} else {
				sql += ", ";
			}
			sql += this.getTableName()+"."+field.getNome();
			if (field.getAlias()!=null) {
				sql += " as " + field.getAlias();
			}
		}
		
		if (this.joins.size()>0) {
			for (JoinTable join : this.joins) {
				for (SelectField<?> field : join.getTable().getCampos()) {
					if (first) {
						first = false;
					} else {
						sql += ", ";
					}
					sql += join.getTable().getTableName()+"."+field.getNome();
					if (field.getAlias()!=null) {
						sql += " as " + field.getAlias();
					}
				}
			}
		}
		
		sql += " from " + this.getTableName();
		
		if (this.joins.size()>0) {
			for (JoinTable join : this.joins) {
				sql += join.getJoinString();
			}
		}
		
		if (this.wheres!=null && this.wheres.length>0) {
			boolean fWhere = true;
			for (WhereField<?> where : wheres) {
				if (fWhere) {
					fWhere = false;
					sql += " where ";
				} else {
					sql += " and ";
				}
				sql += where.getField().getNome() + where.getComparador() + "'"+where.getValor()+"'";
			}
			
		}
		
		Query query = getEm().createNativeQuery(sql);
		List<Object[]> list = query.getResultList();
		
		List<E> listE = new ArrayList<E>();
		
		for (Object[] objects : list) {
			E obj = classe.newInstance();
			int index = 0;
			for (SelectField<?> campo : campos) {
				if (objects[index]!=null) {
					String nome = campo.getNome();
					if (campo.getAlias()!=null) {
						nome = campo.getAlias();
					}
					Field field = obj.getClass().getDeclaredField(nome);
					field.setAccessible(true);
					if (!field.getType().equals(objects[index].getClass())) {
						if (field.getType().equals(Long.class)) {
							field.set(obj, Long.valueOf(objects[index].toString()));
						}
					} else {
						field.set(obj, objects[index]);
					}
				}
				index++;
				
			}
			if (this.joins.size()>0) {
				for (JoinTable join : this.joins) {
					for (SelectField<?> campo : join.getTable().getCampos()) {
						if (objects[index]!=null) {
							String nome = campo.getNome();
							if (campo.getAlias()!=null) {
								nome = campo.getAlias();
							}
							Field field = obj.getClass().getDeclaredField(nome);
							field.setAccessible(true);
							if (!field.getType().equals(objects[index].getClass())) {
								if (field.getType().equals(Long.class)) {
									field.set(obj, Long.valueOf(objects[index].toString()));
								}
							} else {
								field.set(obj, objects[index]);
							}
						}
						index++;
					}
				}
			}
			listE.add(obj);
		}
		
		return listE;
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
