package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Cargo;

public class CargoDAO extends MasterDAO{

	//	inserir cargo
	public void inserirCargo(Cargo cargo){
		inserirObjeto(cargo);
	}

	//	atualizar cargo
	public void atualizarCargo(Cargo cargo){
		atualizarObjeto(cargo);
	}

	//	deletar cargo
	public void deletarCargo(Cargo cargo){
		deletarObjeto(cargo);
	}
	
//	buscar cargo por id
	public Cargo buscarCargo(int idCargo){
		return buscarObjeto(Cargo.class, idCargo);
	}
	
//	buscar cargos
	public List<Cargo> buscarTodosCargos(){
		return buscarLista("from Cargo");
	}
	
//	buscar cargo(s) por string
	public List<Cargo> buscarCargos(String str){
		Session s = getSession();
		s.beginTransaction();
		Query qr = s.createQuery("from Cargo cg where cg.descricao like :cgdesc");
		qr.setParameter("cgdesc","%"+str+"%");
		List<Cargo> listaCargo = qr.list();
		s.getTransaction().commit();
		s.close();
		return listaCargo;
	}
}
