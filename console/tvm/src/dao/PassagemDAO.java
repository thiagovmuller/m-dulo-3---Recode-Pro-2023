package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Passagem;

public class PassagemDAO {
	
	//CADASTRAR
		public boolean cadastrar(Passagem passagem) throws Exception {
			String query = "insert into passagem (ciaAerea,origem,destino,valor) values (?,?,?,?)";
			PreparedStatement ps = null;
			Connection c = null;

			try {
				c = ConnectionFactory.criarConexao();
				ps = c.prepareStatement(query);
				ps.setString(1, passagem.getCiaAerea());
				ps.setString(2, passagem.getOrigem());
				ps.setString(3, passagem.getDestino());
				ps.setFloat(4, passagem.getValor());
				boolean result = ps.execute();

				if (result == true) {
					System.out.println("Passagem cadastrada com sucesso");
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
		//CONSULTAR
		public List<Passagem> consultar() {
			List<Passagem> passagem = new ArrayList<Passagem>();
			String query = "select * from passagem";
			PreparedStatement ps = null;
			Connection c = null;
			ResultSet rset = null;
			
			try {
				c = ConnectionFactory.criarConexao();
				ps = c.prepareStatement(query);
				rset = ps.executeQuery();
				
				while (rset.next()) {
					Passagem Passagem = new Passagem();
					
					Passagem.setIdPassagem(rset.getInt("idPassagem"));
					Passagem.setCiaAerea(rset.getString("ciaAerea"));
					Passagem.setOrigem(rset.getString("origem"));
					Passagem.setDestino(rset.getString("destino"));
					Passagem.setValor(rset.getFloat("valor"));
					
					passagem.add(Passagem);
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
			return passagem;
			
		}
		
		//CONSULTAR POR ID
		public Passagem consultarId(int idPassagem) {
			Passagem passagem = new Passagem();
			String query = "select * from passagem WHERE idPassagem = ?";
			
			PreparedStatement ps = null;
			Connection c = null;
			ResultSet rset = null;
			
			try {
				c = ConnectionFactory.criarConexao();
				ps = c.prepareStatement(query);
				ps.setInt(1, idPassagem);
				rset = ps.executeQuery();
				rset.next();
				passagem.setIdPassagem(rset.getInt("idPassagem"));
				passagem.setCiaAerea(rset.getString("ciaAerea"));
				passagem.setOrigem(rset.getString("origem"));
				passagem.setDestino(rset.getString("destino"));
				passagem.setValor(rset.getFloat("valor"));
				
			
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
		
			return passagem;
	}
		
		//ATUALIZAR
		public void atualizar(Passagem passagem) {
			String query= "UPDATE passagem SET ciaAerea = ?, origem = ?, destino = ?, valor = ? WHERE idPassagem = ?";
			
			PreparedStatement ps = null;
			Connection c = null;
			ResultSet rset = null;
			
			try {
				c = ConnectionFactory.criarConexao();
				ps = c.prepareStatement(query);
				ps.setString(1, passagem.getCiaAerea());
				ps.setString(2, passagem.getOrigem());
				ps.setString(3, passagem.getDestino());;
				ps.setFloat(4, passagem.getValor());
				ps.setInt(5, passagem.getIdPassagem());
				
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
		public void deletar(int idPassagem) {
			String query = "DELETE FROM passagem WHERE idPassagem = ?";
			
			Connection c = null;
			PreparedStatement ps = null;
			
			try {
				c = ConnectionFactory.criarConexao();
				ps = c.prepareStatement(query);
				ps.setInt(1, idPassagem);
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
		
		


