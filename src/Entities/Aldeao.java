// Classe abstrata base para outros guerreiros.

package Entities;

public abstract class Aldeao {
	private Integer vida;
	private Arma arma;

	public Aldeao() {
		
	}

	public Aldeao(Integer vida, Arma arma) {
		this.vida = vida;
		this.arma = arma;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public abstract Integer ataque();
	

	
		
}
