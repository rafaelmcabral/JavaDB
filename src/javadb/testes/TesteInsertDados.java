package javadb.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;

public class TesteInsertDados {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.getConnection();
		
		String sql = "INSERT INTO CLIENTES (nome, email, endereco) VALUES (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "Rafael");
		stmt.setString(2, "rafael@email.com");
		stmt.setString(3, "Rua Santa Luzia");
		
		stmt.execute();
		
		System.out.println("Inserido com sucesso!");
		
		conn.close();
	}
}
