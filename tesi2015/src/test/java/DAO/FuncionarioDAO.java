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

	//	buscar Funcionário
	public Funcionario buscarFuncionario(int idFuncionario){
		return buscarObjeto(Funcionario.class, idFuncionario);
	}

	//	buscar Funcionários por Nome
	public List<Serializable> buscarFuncionarios(String nome){
		return buscarLista("from Funcionario f where f.nome like :"+nome+";");
	}
	
	public List<Funcionario> listarFuncionario(){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Funcionario f");
		List<Funcionario> listarFuncionario = qr.list();
		s.close();
		return listarFuncionario;
	}

}
