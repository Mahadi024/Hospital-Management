package model;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DoctorSessionFactory {

	public DoctorSessionFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Session getSession()
	{
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();       
		Metadata metadata =new MetadataSources(standardRegistry).getMetadataBuilder().build();  
		return metadata.getSessionFactoryBuilder().build().openSession();
	}

}
