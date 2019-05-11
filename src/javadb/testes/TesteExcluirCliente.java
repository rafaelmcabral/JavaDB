package javadb.testes;

import java.util.Scanner;

import javadb.dao.ClienteDao;
import javadb.modelo.Cliente;

public class TesteExcluirCliente {
	public static void main(String[] args) {
		long numero = obterNumeroInput();
		ClienteDao clienteDao = null;
		
		try {
			clienteDao = new ClienteDao();
			Cliente cliente;
			
			cliente = clienteDao.getCliente(numero);
			
			if (cliente != null) {
				System.out.println("Excluindo cliente...");
				clienteDao.excluir(cliente);
				System.out.println("Cliente excluído com sucesso!");
			} else {
				System.out.println("Cliente não encontrado!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			clienteDao.fecharConexao();
		}
	}
	
	private static long obterNumeroInput() {
		long numero = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Informe o ID: ");
			numero = input.nextLong();
		} while (!(numero > 0));
		
		input.close();
		return numero;
	}
}
