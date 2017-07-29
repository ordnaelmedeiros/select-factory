package com.medeiros.ordnael.selectfactory.database;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.medeiros.ordnael.selectfactory.database.entitys.Endereco;
import com.medeiros.ordnael.selectfactory.database.entitys.Pessoa;


public class EntityManagerUtil {

	private static SessionFactory sessions = null;
	
	static {
		
		Configuration cfg = new Configuration()
			    
				.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
				
				.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
				.setProperty("hibernate.connection.username", "postgres")
				.setProperty("hibernate.connection.password", "ids0207")
				.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/selectfactory")
				
				.setProperty("hibernate.c3p0.min_size", "5")
				.setProperty("hibernate.c3p0.max_size", "20")
				.setProperty("hibernate.c3p0.timeout", "1800")
				.setProperty("hibernate.c3p0.max_statements", "50")
				
				//.setProperty("org.hibernate.envers.default_schema", "public")
				.setProperty("org.hibernate.envers.audit_table_suffix", "_aud")
				
				.setProperty("hibernate.hbm2ddl.auto", "update")
				.setProperty("hibernate.format_sql", "true")
				.setProperty("hibernate.show_sql", "false");
		
		cfg.addAnnotatedClass(Pessoa.class);
		cfg.addAnnotatedClass(Endereco.class);
		
		sessions = cfg.buildSessionFactory();
		
	}

	public EntityManager getEntityManager() {
		return sessions.createEntityManager();
	}
	
}