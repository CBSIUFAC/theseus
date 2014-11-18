package util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabelas {
	public static void main(String [] args){
		Configuration c = new Configuration().configure();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		SchemaExport se = new SchemaExport(c);
		se.create(true, true);
		s.getTransaction().commit();
		s.close();
	}
}