package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dominio.Pessoa;
import daoUtil.ConnectionFactory;

public class PessoaDao {

	private Statement statement;
	private PreparedStatement preparedStatement;
	private Connection con = null;

	public PessoaDao() {
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
	
	public List<Pessoa> listarPessoas() throws SQLException{
		List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
		ResultSet res = null;
		String sqlListar = "SELECT * FROM EVENTO";
		try {
			preparedStatement = con.prepareStatement(sqlListar);
			res = preparedStatement.executeQuery();
			while (res.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setId(res.getInt("id"));
				pessoa.setNome(res.getString("nome"));
				pessoa.setCPF(res.getString("CPF"));
				pessoa.setEndereco(res.getString("CPF"));
				pessoa.setTelefone(res.getString("telefone"));
				pessoa.setEmail(res.getString("email"));
				pessoa.setSenha(res.getString("senha"));

				listaDePessoas.add(pessoa);
			}


		}catch (SQLException e){
			System.out.println("Erro na consulta1:" + e.getMessage());
		}
		return listaDePessoas;
	}
}
