package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {

	//CADASTRAR
	public boolean cadastrar(Cliente cliente) throws Exception {
		String query = "insert into cliente (nome,cpf,dataNasc,telefone) values (?,?,?,?)";
		PreparedStatement ps = null;
		Connection c = null;

		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setDate(3, new Date(cliente.getDataNasc().getTime()));
			ps.setString(4, cliente.getTelefone());

			boolean result = ps.execute();

			if (result == true) {
				System.out.println("Cliente cadastrado com sucesso");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//CONSULTAR
	public List<Cliente> consultar() {
		List<Cliente> cliente = new ArrayList<Cliente>();
		String query = "select * from cliente";
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			rset = ps.executeQuery();
			
			while (rset.next()) {
				Cliente Cliente = new Cliente();
				
				Cliente.setIdCliente(rset.getInt("idCliente"));
				Cliente.setNome(rset.getString("nome"));
				Cliente.setCpf(rset.getString("cpf"));
				Cliente.setDataNasc(rset.getDate("dataNasc"));
				Cliente.setTelefone(rset.getString("telefone"));
				
				cliente.add(Cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
		
	}
	
	//CONSULTAR POR ID
	public Cliente consultarId(int idCliente) {
		Cliente cliente = new Cliente();
		String query = "select * from cliente WHERE idCliente = ?";
		
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			ps.setInt(1, idCliente);
			rset = ps.executeQuery();
			rset.next();
			cliente.setIdCliente(rset.getInt("idCliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setDataNasc(rset.getDate("dataNasc"));
			cliente.setTelefone(rset.getString("telefone"));
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return cliente;
}
	
	
	//ATUALIZAR
	public void atualizar(Cliente cliente) {
		String query= "UPDATE cliente SET nome = ?, cpf = ?, dataNasc = ?, telefone = ? WHERE idCliente = ?";
		
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setDate(3, new Date(cliente.getDataNasc().getTime()));;
			ps.setString(4, cliente.getTelefone());
			ps.setInt(5, cliente.getIdCliente());
			
			ps.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	

	//DELETAR
	public void deletar(int idCliente) {
		String query = "DELETE FROM cliente WHERE idCliente = ?";
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			ps.setInt(1, idCliente);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	}

