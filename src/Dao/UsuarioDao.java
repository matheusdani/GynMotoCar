package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.dominio.Pessoa;
import daoUtil.ConnectionFactory;

public class UsuarioDao {

	private Statement statement;
	private PreparedStatement preparedStatement;
	private Connection con = null;

	public UsuarioDao() {
		ConnectionFactory factory = new ConnectionFactory();
		con = factory.getConnection();
	}

	public String Cadastrar(Pessoa pessoa) throws SQLException {
		
		String salvo = "";
		String sqlCadPessoa = "INSERT INTO GynMotoCar.pessoa("
				+ "id, nome, email, cpf, telefone, endereco"
				+ "values("
				+ "?,?,?,?,?,?)";

		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(sqlCadPessoa);
			preparedStatement.setInt(1, pessoa.getId());
			preparedStatement.setString(3, pessoa.getNome());
			preparedStatement.setString(4, pessoa.getEmail());
			preparedStatement.setString(5, pessoa.getCPF());
			preparedStatement.setString(6, pessoa.getTelefone());
			preparedStatement.setString(6, pessoa.getEndereco());
		

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

	public List<Evento> listarEventos() throws SQLException{
		List<Evento> listaDeEventos = new ArrayList<Evento>();
		ResultSet res = null;
		String sqlListar = "SELECT * FROM EVENTO";
		try {
			preparedStatement = con.prepareStatement(sqlListar);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				Evento evento = new Evento();
				evento.setId(res.getInt("id"));
				evento.setNome(res.getString("nome"));
				evento.setDataEvento(res.getDate("dataEvento"));
				evento.setStatus(res.getString("statusEvento"));
				evento.setVagas(res.getInt("vagas"));
				evento.setValorIngresso(res.getDouble("valorIngresso"));
				evento.setLocal(res.getString("localEvento"));
				evento.setCategoria(res.getString("categoria"));

				listaDeEventos.add(evento);
			}


		}catch (SQLException e){
			System.out.println("Erro na consulta1:" + e.getMessage());
		}
		return listaDeEventos;
	}

}


}
