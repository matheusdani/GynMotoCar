package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ValidarLogin {
	
/*	  public boolean consultar(String login, String senha) {
	        boolean autenticado = false;
	        String sql;
	        try {
	            Connection conn = ConnectionMySQL.getConnection();
	            sql =( "SELECT username, senha, acesso FROM usuarios WHERE username=? and senha=?");
	            PreparedStatement ps;
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, login);
	            ps.setString(2, senha);
	            ResultSet rs;
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                String user = rs.getString("username");
	                String pass = rs.getString("senha");
	                String Acesso = rs.getString("acesso");//Aqui armazeno o acesso ("Inventario" ou "Operacao") na variável publica Acesso declarada no inicio do código
	                autenticado = true;
	            } else {
	                //JOptionPane.showMessageDialog(this, "Acesso Negado \nInforme o setor de Inventário");
	                ps.close();
	                return autenticado;
	            }
	        } catch (SQLException ex) {

	            JOptionPane.showInputDialog(this, ex);
	        }
	        return autenticado;
	    }
	 */

}
