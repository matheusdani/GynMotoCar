package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoUtil.ConnectionFactory;
import modelo.dominio.Anuncio;
import modelo.dominio.Veiculos;

public class AnuncioDao {

		private PreparedStatement preparedStatement;
		private Connection con = null;
		
		Veiculos veiculo = new Veiculos();

		public AnuncioDao() {
			ConnectionFactory factory = new ConnectionFactory();
			con = factory.getConnection();
		}

		public String salvar(Anuncio anuncio) throws SQLException {
			
			String salvo = "";
			String sqlAnuncio = "INSERT INTO GynMotoCar.anuncio("
					+ "id, descricao, modelo, marca, tipo, potencia, valor,"
					+ "combustivel, ano, cor, mensagem"
					+ "values("
					+ "?,?,?,?,?,?,?,?,?,?,?,?)";

			try {
				con.setAutoCommit(false);
				preparedStatement = con.prepareStatement(sqlAnuncio);
				preparedStatement.setInt(1, anuncio.getId());
				preparedStatement.setString(2, anuncio.getDescricao());
				preparedStatement.setDouble(7, anuncio.getValor());
				
				preparedStatement.setString(3, veiculo.getModelo());
				preparedStatement.setString(4, veiculo.getMarca());
				preparedStatement.setString(5, veiculo.getTipo());
				preparedStatement.setString(6, veiculo.getPotencia());
				preparedStatement.setString(8, veiculo.getCombustivel());
				preparedStatement.setString(9, veiculo.getAno());
				preparedStatement.setString(10, veiculo.getCor());
				preparedStatement.setString(11, anuncio.getMensagem());
			

				preparedStatement.executeUpdate();

				//Grava as informações se caso de problema os dados não são gravados
				con.commit();
				salvo = "salvo";

			} catch (SQLException e) {
				if (con != null) {
					try {
						System.err.print("Rollback efetuado na transação" + e.getMessage());
						con.rollback();
					} catch (SQLException e2) {
						System.err.print("Erro na transação!" + e2);
						salvo = "\"Erro na transação!\"+e2";
					}
				}
			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				con.setAutoCommit(true);
			}

			return salvo;
		}
		
		public List<Anuncio> listarAnuncio() throws SQLException{
			List<Anuncio> listaDeAnuncios = new ArrayList<Anuncio>();
			ResultSet res = null;
			String sqlListar = "SELECT * FROM ANUNCIO";
			try {
				preparedStatement = con.prepareStatement(sqlListar);
				res = preparedStatement.executeQuery();
				while (res.next()) {
					
					Anuncio anuncio = new Anuncio();
					Veiculos veiculo = new Veiculos();
					
					anuncio.setId(res.getInt("id"));
					anuncio.setDescricao(res.getString("Descrição"));
					anuncio.setValor(res.getDouble("Valor"));
					
					veiculo.setModelo(res.getString("Modelo"));
					veiculo.setMarca(res.getString("Marca"));
					veiculo.setTipo(res.getString("Tipo"));
					veiculo.setPotencia(res.getString("Potencia"));
					veiculo.setCombustivel(res.getString("Combustível"));
					veiculo.setAno(res.getString("Ano"));
					veiculo.setCor(res.getString("Cor"));
					anuncio.setMensagem(res.getString("Mensagem"));

					listaDeAnuncios.add(anuncio);
				}


			}catch (SQLException e){
				System.out.println("Erro na consulta1:" + e.getMessage());
			}
			return listaDeAnuncios;
		}
}


