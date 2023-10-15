package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Compra;
import model.Passagem;

public class CompraDAO {
	
	//COMPRAR
	public boolean comprar(Compra compra) throws Exception {
		String query = "insert into compra (idCliente, idPassagem, formaPgto, valorTotal) values (?,?,?,?)";
		PreparedStatement ps = null;
		Connection c = null;

		try {
			c = ConnectionFactory.criarConexao();
			ps = c.prepareStatement(query);
			ps.setInt(1, compra.getIdCliente());
			ps.setInt(2, compra.getIdPassagem());
			ps.setString(3, compra.getFormaPgto());
			ps.setFloat(4, compra.getValorTotal());
			boolean result = ps.execute();

			if (result == true) {
				System.out.println("Compra realizada com sucesso");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//CONSULTAR
			public List<Compra> consultar() {
				List<Compra> compra = new ArrayList<Compra>();
				String query = "select * from compra";
				PreparedStatement ps = null;
				Connection c = null;
				ResultSet rset = null;
				
				try {
					c = ConnectionFactory.criarConexao();
					ps = c.prepareStatement(query);
					rset = ps.executeQuery();
					
					while (rset.next()) {
						Compra Compra = new Compra();
						
						Compra.setIdCompra(rset.getInt("idCompra"));
						Compra.setIdCliente(rset.getInt("idCliente"));
						Compra.setIdPassagem(rset.getInt("idPassagem"));
						Compra.setFormaPgto(rset.getString("formaPgto"));
						Compra.setValorTotal(rset.getFloat("valorTotal"));
						
						compra.add(Compra);
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
				return compra;
				
			}
			
			//CONSULTAR POR ID
			public Compra consultarId(int idCompra) {
				Compra compra = new Compra();
				String query = "select * from compra WHERE idCompra = ?";
				
				PreparedStatement ps = null;
				Connection c = null;
				ResultSet rset = null;
				
				try {
					c = ConnectionFactory.criarConexao();
					ps = c.prepareStatement(query);
					ps.setInt(1, idCompra);
					rset = ps.executeQuery();
					rset.next();
					compra.setIdCompra(rset.getInt("idCompra"));
					compra.setIdCliente(rset.getInt("idCliente"));
					compra.setIdPassagem(rset.getInt("idPassagem"));
					compra.setFormaPgto(rset.getString("formaPgto"));
					compra.setValorTotal(rset.getFloat("valorTotal"));
					
				
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
			
				return compra;
		}
			
			//ATUALIZAR
			public void atualizar(Compra compra) {
				String query= "UPDATE compra SET idCliente = ?, idPassagem = ?, formaPgto = ?, valorTotal = ? WHERE idCompra = ?";
				
				PreparedStatement ps = null;
				Connection c = null;
				ResultSet rset = null;
				
				try {
					c = ConnectionFactory.criarConexao();
					ps = c.prepareStatement(query);
					ps.setInt(1, compra.getIdCliente());
					ps.setInt(2, compra.getIdPassagem());
					ps.setString(3, compra.getFormaPgto());;
					ps.setFloat(4, compra.getValorTotal());
					ps.setInt(5, compra.getIdCompra());
					
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
			public void cancelar(int idCompra) {
				String query = "DELETE FROM compra WHERE idCompra = ?";
				
				Connection c = null;
				PreparedStatement ps = null;
				
				try {
					c = ConnectionFactory.criarConexao();
					ps = c.prepareStatement(query);
					ps.setInt(1, idCompra);
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
