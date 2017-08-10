package com.medeiros.ordnael.selectfactorycore.select;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class SelectTable<T, Y> {
	
	private EntityManager em;
	
	protected abstract Class<T> getTableClass();
	protected abstract Y getThis();
	
	private List<SelectField<?>> fields = new ArrayList<>();
	
	public SelectTable(EntityManager em) {
		this.em = em;
	}
	
	public Y addFields(SelectField<?> ...fields) {
		for (SelectField<?> selectField : fields) {
			this.fields.add(selectField);
		}
		return getThis();
	}
	
	public List<T> list() throws Exception {
		return this.list(this.getTableClass());
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> list(Class<E> classe) throws Exception {
		
		String strFields = "*";
		
		boolean first = true;
		for (SelectField<?> field : this.fields) {
			if (first) {
				strFields = field.getNome();
				first = false;
			} else {
				strFields += ", " + field.getNome();
			}
		}
		
		String sql = "select "+strFields+" from " + this.getTableClass().getSimpleName();
		
		Query query = em.createNativeQuery(sql);
		
		List<?> list1 = query.getResultList();
		
		List<E> resultList = new ArrayList<>();
		
		if (list1.size()>0) {
			
			if (list1.get(0) instanceof Object[]) {
				
				List<Object[]> list = (List<Object[]>) list1;
				
				for (Object[] objects : list) {
					
					E obj = classe.newInstance();
					int index = 0;
					
					for (SelectField<?> campo : fields) {
						
						if (objects[index]!=null) {
							String nome = campo.getNome();
							if (campo.getAlias()!=null) {
								nome = campo.getAlias();
							}
							try {
								Field field = obj.getClass().getDeclaredField(nome);
								if (field!=null) {
									field.setAccessible(true);
									if (!field.getType().equals(objects[index].getClass())) {
										if (field.getType().equals(Long.class)) {
											field.set(obj, Long.valueOf(objects[index].toString()));
										}
									} else {
										field.set(obj, objects[index]);
									}
								}
							} catch (Exception e) {
							}
							
						}
						index++;
						
					}
					
					resultList.add(obj);
					
				}
				
			} else {
				
				List<Object> list = (List<Object>) list1;
				
				for (Object objects : list) {
					
					E obj = classe.newInstance();
					
					for (SelectField<?> campo : fields) {
						
						if (objects!=null) {
							String nome = campo.getNome();
							if (campo.getAlias()!=null) {
								nome = campo.getAlias();
							}
							Field field = obj.getClass().getDeclaredField(nome);
							field.setAccessible(true);
							if (!field.getType().equals(objects.getClass())) {
								if (field.getType().equals(Long.class)) {
									field.set(obj, Long.valueOf(objects.toString()));
								}
							} else {
								field.set(obj, objects);
							}
						}
						
					}
					
					resultList.add(obj);
					
				}
				
			}
			
		}
		
		return resultList;
		
	}
	
}
