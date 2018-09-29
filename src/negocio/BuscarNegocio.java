package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.BuscarDao;
import modelo.dominio.Anuncio;

public class BuscarNegocio {
	
	BuscarDao buscarDao = new BuscarDao();
	
	 public String salvar(Anuncio anuncio) throws SQLException {
	    	
	  
	        String salvo = "falha!";
	        StringBuilder sb = new StringBuilder();
	        
//	        cpfValido = validaCPF(adm.getCpf());
//	        if (!cpfValido) {
//	            sb.append("cpf inválido. \n");
//	        }
	
	        if (sb.toString().isEmpty()) {
	          salvo = buscarDao.Buscar(anuncio);
	        } else {
	            sb.append(salvo);
	            return sb.toString();
	        }
	        sb.append(salvo);
	        return sb.toString();
	
	    }
	 
	 public List<Anuncio> listaranuncio() throws SQLException{
	        List<Anuncio> anuncio = new ArrayList<Anuncio>();
	        anuncio = buscarDao.listarAnuncios();
	        return anuncio;
	 }
}
