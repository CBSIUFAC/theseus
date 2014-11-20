package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

public class MasterDAO {
	public Session getSession(){
		return HibernateUtil.getSessionFactory().openSession();
	}

	//	inserção
	public void inserirObjeto(Object obj){
		Session s = getSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
	}

	//	atualização
	public void atualizarObjeto(Object obj){
		Session s = getSession();
		s.beginTransaction();
		s.update(obj);
		s.getTransaction().commit();
		s.close();
	}

	//	exclusão
	public void deletarObjeto(Object obj){
		Session s = getSession();
		s.beginTransaction();
		s.delete(obj);
		s.getTransaction().commit();
		s.close();
	}

	//	busca objeto
	public <T extends Serializable> T buscarObjeto(Class<T> classe, int id){
		Session s = getSession();
		s.beginTransaction();
		Serializable retorno = (Serializable)s.get(classe, id);
		s.getTransaction().commit();
		s.close();
		return (T)retorno;
	}

	//	busca vários objetos (lista)
	public <T extends Serializable> List<T> buscarLista(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery(str);
		List<T> retorno = qr.list();
		s.getTransaction().commit();
		s.close();
		return retorno;
	}

}
