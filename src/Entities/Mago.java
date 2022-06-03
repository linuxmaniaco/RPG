package Entities;

import java.util.Random;

public class Mago extends Aldeao{
	private Integer mana;
	private Integer inteligencia;
	private Integer resistencia;
	
	public Mago() {
		super();
	}

	public Mago(Integer vida, Arma arma, Integer mana, Integer inteligencia, Integer resistencia) {
		super(vida, arma);
		this.mana = mana;
		this.inteligencia = inteligencia;
		this.resistencia = resistencia;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public Integer getResistencia() {
		return resistencia;
	}

	public void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

//	Método que calcula o ataque.
	@Override
	public Integer ataque() {
		Integer dano = getArma().danoArma() + inteligencia;
		return dano;
	}
	
	// Método que calcula a defesa
	public void defesa(Integer dano) {
		
		Integer defesa = dano - resistencia;
		if(defesa <= 0) {
			defesa = 0;
			System.out.println("DEFENDEU");
		}
		
		
		Integer danoTotal = this.getVida() - defesa;
		this.setVida(danoTotal);
		
		
			System.out.println("MagoAbsorve:  " + resistencia );
			System.out.println("DanoSofridoMago: " + defesa);
		}

	@Override
	public String toString() {
		return "Mago ["+ " vida=" + super.getVida() + ", mana=" + mana + ", inteligencia=" + inteligencia + ", resistencia=" + resistencia + ", Ataque="+ ataque() + " e usa uma " + super.getArma().getTipoArma() +"]";
		
	}
	
	
	
}
