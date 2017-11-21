package Modelo.dominio;

public class Moto extends Veiculos {
	
	public int id;
	public String tipoMoto;
	public String modelo;
	public String potencia;
	public int id_veiculo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoMoto() {
		return tipoMoto;
	}
	public void setTipoMoto(String tipoMoto) {
		this.tipoMoto = tipoMoto;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	
	
	
	
}
