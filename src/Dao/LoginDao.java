package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.dominio.Usuario;
import daoUtil.ConnectionFactory;

public class LoginDao {

	private java.sql.Statement statement;
	private PreparedStatement preparedStatement;
	private Connection con = null;
	Usuario usuario = new Usuario();
	public LoginDao() {
		ConnectionFactory factory = new ConnectionFactory();
		con = factory.getConnection();
	}
	public Usuario buscarUser(String email)  {

		List<Usuario> listaUsers = new ArrayList<Usuario>();
		ResultSet res = null;

		try {
			statement = con.createStatement();
			res = statement.executeQuery("SELECT * FROM usuario");
			while (res.next()) {

				Usuario user = new Usuario();
				if(user.getLogin().equals(email)) {
					user.setId(res.getInt("id"));
					user.setLogin(res.getString("email"));
					user.setSenha(res.getString("senha"));

					usuario = user;
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro na consulta1:" + e.getMessage());
		}
		return usuario;
	}



}
