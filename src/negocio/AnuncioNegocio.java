package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.AnuncioDao;
import modelo.dominio.Anuncio;


public class AnuncioNegocio {
	
	AnuncioDao anuncioDao = new AnuncioDao();
	
	 public String salvar(Anuncio anuncio) throws SQLException {
	    	
	  
	        String salvo = "falha!";
	        StringBuilder sb = new StringBuilder();
	        
//	        cpfValido = validaCPF(adm.getCpf());
//	        if (!cpfValido) {
//	            sb.append("cpf inválido. \n");
//	        }
	
	        if (sb.toString().isEmpty()) {
	          salvo = anuncioDao.salvar(anuncio);
	        } else {
	            sb.append(salvo);
	            return sb.toString();
	        }
	        sb.append(salvo);
	        return sb.toString();
 	
	    }
	 
	 public List<Anuncio> listarAnuncio() throws SQLException{
	        List<Anuncio> anuncio = new ArrayList<Anuncio>();
	        anuncio = anuncioDao.listarAnuncio();
	        return anuncio;
	 }
	 

}
