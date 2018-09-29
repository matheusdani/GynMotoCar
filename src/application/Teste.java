package application;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import modelo.dominio.Usuario;
import visao.controle.AnuncioControle;

public class Teste {

	public static void main(String[] args) throws HeadlessException, ParseException {
		// TODO Auto-generated method stub
	testarAnuncio();
	}
	public static void testarAnuncio() throws HeadlessException, ParseException {
		AnuncioControle controle = new AnuncioControle();
		Usuario usuario = new Usuario();
		usuario.setLogin("login");
		usuario.setSenha("senha");
		usuario.setId(1);
		//controle.listarEventos();
		//controle.solicitarEvento(usuario);
		//controle.participarEvento(usuario);
		
	} 
}
