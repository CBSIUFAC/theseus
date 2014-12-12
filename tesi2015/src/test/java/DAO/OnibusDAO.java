package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Linha;
import entidade.Onibus;

public class OnibusDAO extends MasterDAO{

	//inserir ônibus
	public void inserirOnibus(Onibus onibus){
		inserirObjeto(onibus);
	}

	//	atualizar ônibus
	public void atualizarOnibus(Onibus onibus){
		atualizarObjeto(onibus);
	}

	//	deletar ônibus
	public void deletarOnibus(Onibus onibus){
		deletarObjeto(onibus);
	}

	//	buscar ônibus por id
	public Onibus buscarOnibus(int idOnibus){
		return buscarObjeto(Onibus.class, idOnibus);
	}
	
	public List<Onibus> buscarOnibusPorLinha(int idLinha){
		return buscarLista("from Onibus oni where oni.idLinha like "+idLinha);
	}

	// buscar lista de onibus por linha
	public List<Onibus> listarOnibus(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Onibus oni where oni.idLinha like :on");
		qr.setParameter("on","%"+str+"%");
		List<Onibus> listaOnibus = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaOnibus;
	}
}
