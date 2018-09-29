package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoUtil.ConnectionFactory;
import modelo.dominio.Anuncio;

public class BuscarDao {
	
	private PreparedStatement preparedStatement;
	private Connection con = null;

	public BuscarDao() {
		ConnectionFactory factory = new ConnectionFactory();
		con = factory.getConnection();
	}

	public String Buscar(Anuncio anuncio) throws SQLException {
		
		String salvo = "";
		String sqlBuscar = "Select GynMotoCar.anuncio("
				+ "id, nome, email, cpf, telefone, endereco"
				+ "values("
				+ "?,?,?,?,?,?)";

		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(sqlBuscar);
			preparedStatement.setInt(1, anuncio.getId());
			preparedStatement.setString(3, anuncio.getDescricao());
			preparedStatement.setString(4, anuncio.getMensagem());
			preparedStatement.setDouble(5, anuncio.getValor());;
		

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

	
	public List<Anuncio> listarAnuncios() throws SQLException{
		List<Anuncio> listaDeAnuncios = new ArrayList<Anuncio>();
		ResultSet res = null;
		String sqlListar = "SELECT * FROM ANUNCIO";
		try {
		    preparedStatement = con.prepareStatement(sqlListar);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				
				Anuncio anuncio = new Anuncio();
				anuncio.setId(res.getInt("id"));
				anuncio.setDescricao(res.getString("Descrição"));
				anuncio.setMensagem(res.getString("Mensagem"));
				anuncio.setValor(res.getDouble("Valor"));
	
				listaDeAnuncios.add(anuncio);
			}
	
	
		}catch (SQLException e){
			System.out.println("Erro na consulta1:" + e.getMessage());
		}		
		return listaDeAnuncios;
	}
}
