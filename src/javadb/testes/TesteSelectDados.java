package javadb.testes;

import java.util.List;

import javadb.dao.ClienteDao;
import javadb.modelo.Cliente;

public class TesteSelectDados {
	public static void main(String[] args) {
		List<Cliente> clientes;
		ClienteDao clienteDao = null;
		
		try {
			clienteDao = new ClienteDao();
			clientes = clienteDao.getClientes();
					
			//for (int i = 0;i < clientes.size();i++) {
			for (Cliente cliente : clientes) {
				System.out.println("ID: " + cliente.getId());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("E-mail: " + cliente.getEmail());
				System.out.println("Endereco: " + cliente.getEndereco());
				System.out.println("---------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			clienteDao.fecharConexao();
		}
	}
}
