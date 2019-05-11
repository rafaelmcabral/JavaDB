package javadb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.jdbc.ConnectionFactory;
import javadb.modelo.Cliente;

public class ClienteDao {
	
	private Connection conn;
	
	public ClienteDao() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void inserirCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO CLIENTES (nome, email, endereco) VALUES (?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.execute();		
			stmt.close();	
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			this.conn.close();
		}
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM CLIENTES");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong(1));
				cliente.setNome(rs.getString(2));
				cliente.setEmail(rs.getString(3));
				cliente.setEndereco(rs.getString(4));
				
				clientes.add(cliente);
			}
			
			stmt.close();
			rs.close();
			
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public Cliente getCliente(long id) {
		Cliente cliente = null;
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM CLIENTES WHERE ID = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong(1));
				cliente.setNome(rs.getString(2));
				cliente.setEmail(rs.getString(3));
				cliente.setEndereco(rs.getString(4));
			}
					
			stmt.close();
			rs.close();
			
			return cliente;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void editar(Cliente cliente) {
		String sql = "UPDATE CLIENTES SET NOME = ?, EMAIL = ?, ENDERECO = ? WHERE ID = ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getId());

			stmt.execute();		
			stmt.close();	
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);                                                                                                                                                             
		}
	}
	
	public void excluir(Cliente cliente) {
		String sql = "DELETE FROM CLIENTES WHERE ID = ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setLong(1, cliente.getId());
			stmt.execute();		
			stmt.close();			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void fecharConexao() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
