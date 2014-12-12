package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Funcionario;

public class FuncionarioDAO extends MasterDAO{

	//	inserir funcionário
	public void inserirFuncionario(Funcionario funcionario){
		inserirObjeto(funcionario);
	}

	//	atualizar funcionário
	public void atualizarFuncionario(Funcionario funcionario){
		atualizarObjeto(funcionario);
	}

	//	deletar funcionário
	public void deletarFuncionario(Funcionario funcionario){
		deletarObjeto(funcionario);
	}

	//	buscar funcionário
	public Funcionario buscarFuncionario(int idFuncionario){
		return buscarObjeto(Funcionario.class, idFuncionario);
	}

	//	buscar funcionários por Nome
	public List<Serializable> buscarFuncionarios(String nome){
		return buscarLista("from Funcionario f where f.nome like :"+nome+";");
	}

	//	listar funcionarios
	public List<Funcionario> listarFuncionario(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Funcionario f where f.nome like :func");
		qr.setParameter("func","%"+str+"%");
		List<Funcionario> listaFuncionario = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaFuncionario;
	}

}
