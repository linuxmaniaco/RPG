package Entities;

import java.util.Random;

public class Barbaro extends Aldeao{
	private Integer estamina;
	private Integer forca;
	private Integer resistencia;
	
	public Barbaro() {
		super();
	}

	public Barbaro(Integer vida, Arma arma, Integer estamina, Integer forca, Integer resistencia) {
		super(vida, arma);
		this.estamina = estamina;
		this.forca = forca;
		this.resistencia = resistencia;
	}

	public Integer getEstamina() {
		return estamina;
	}

	public void setEstamina(Integer estamina) {
		this.estamina = estamina;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}
		
	public Integer getResistencia() {
		return resistencia;
	}

	public void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

	@Override
	public Integer ataque() {
		Integer ataque = getArma().danoArma() + forca;
		return ataque;
	}
	
	
	public void defesa(Integer dano) {
		
		Integer defesa = dano - resistencia;
		if(defesa < 0) {
			defesa = 0;
			System.out.println("DEFENDEU");
		}
		
		 		
		Integer danoTotal = this.getVida() - defesa;
		this.setVida(danoTotal);
			
			
			System.out.println("BarbaroAbsorve:  " + resistencia);
			System.out.println("DanoSofridoBarbaro: " + defesa);
		}
		

	@Override
	public String toString() {
		return "Barbaro ["+ " vida=" + super.getVida() + ", estamina=" + estamina + ", forca=" + forca + ", resistencia=" + resistencia + ", Ataque=" +ataque() + " e usa uma " + super.getArma().getTipoArma() + "]";
	}
	
	
	
}
