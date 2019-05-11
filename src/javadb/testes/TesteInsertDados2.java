package javadb.testes;

import javadb.dao.ClienteDao;
import javadb.modelo.Cliente;

public class TesteInsertDados2 {
	public static void main(String[] args) {
		Cliente cliente;
		ClienteDao clienteDao = null;
		
		try {
			cliente = new Cliente();
			cliente.setNome("Rafael 3");
			cliente.setEmail("rafael@email.com");
			cliente.setEndereco("Rua Santa Luzia");
			
			clienteDao = new ClienteDao();
			clienteDao.inserirCliente(cliente);
			System.out.println("Cliente inserido com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			clienteDao.fecharConexao();
		}
	}
}
