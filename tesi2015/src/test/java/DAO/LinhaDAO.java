package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Linha;

public class LinhaDAO extends MasterDAO{

	//	inserir Linha
	public void inserirLinha(Linha linha){
		inserirObjeto(linha);
	}

	//	atualizar Linha
	public void atualizarLinha(Linha linha){
		atualizarObjeto(linha);
	}

	//	deletar linha
	public void deletarLinha(Linha linha){
		deletarObjeto(linha);
	}

	//	buscar linha por ID
	public Linha buscarLinha(int idLinha){
		return buscarObjeto(Linha.class, idLinha);
	}

	//	busca todas as linhas
	public List<Linha> buscarTodasLinhas(){
		return buscarLista("from Linha");
	}

	//	listar linha por descrição
	public List<Linha> listarLinhas(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Linha lin where lin.descricao like :lindesc");
		qr.setParameter("lindesc","%"+str+"%");
		List<Linha> listaLinha = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaLinha;
	}

}
