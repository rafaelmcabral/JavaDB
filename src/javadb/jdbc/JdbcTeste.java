package javadb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTeste {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.getConnection();
		System.out.println("Conectado ao Banco de dados MariaDB local");
		conn.close();
	}
}
