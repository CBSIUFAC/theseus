package util;

import java.util.List;

import DAO.FuncionarioDAO;
import entidade.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		
		Funcionario f = new Funcionario();
		
//		f.setCpf("123456789");
//		f.setEndereco("rua de house");
//		f.setNome("joao sem nome");
//		f.setRg("321654");
				
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//		funcionarioDAO.inserirFuncionario(f);
		
//		f = funcionarioDAO.buscarFuncionario(3);
//		funcionarioDAO.deletarFuncionario(f);

		String str = "j";
		List<Funcionario> funcionarios = funcionarioDAO.listarFuncionario(str);
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
		
		System.out.println(funcionarioDAO.buscarFuncionario(1).getNome());
		
	}

}
