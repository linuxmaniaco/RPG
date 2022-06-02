package Entities;

import java.util.Random;

public class Arma {
	private Integer danoMinimo;
	private Integer danoMaximo;
	private String tipoArma;
	
	public Arma() {
		
	}
		
	public Arma(Integer danoMinimo, Integer danoMaximo, String tipoArma) {
		this.danoMinimo = danoMinimo;
		this.danoMaximo = danoMaximo;
		this.tipoArma = tipoArma;
	}

	public Integer getDanoMinimo() {
		return danoMinimo;
	}

	public void setDanoMinimo(Integer danoMinimo) {
		this.danoMinimo = danoMinimo;
	}

	public Integer getDanoMaximo() {
		return danoMaximo;
	}

	public void setDanoMaximo(Integer danoMaximo) {
		this.danoMaximo = danoMaximo;
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public Integer danoArma() {
		Random sortDano = new Random();
		//Integer dano = sortDano.nextInt((danoMaximo - danoMinimo) + 1)+danoMinimo;
		Integer dano = sortDano.nextInt(5)+1;
		return dano;
	}

	@Override
	public String toString() {
		return "Arma [danoMinimo=" + danoMinimo + ", danoMaximo=" + danoMaximo + ", tipoArma=" + tipoArma + "]";
	}
	
	
	
}
