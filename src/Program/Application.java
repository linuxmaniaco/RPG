package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Entities.Arma;
import Entities.Barbaro;
import Entities.Mago;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
//		System.out.println();
		// DADOS DAS ARMAS
		Arma espadaComum = new Arma();
		espadaComum.setDanoMaximo(5);
		espadaComum.setDanoMinimo(1);
		espadaComum.setTipoArma("Espada Comum");
		
		Arma cajadoComum = new Arma();
		cajadoComum.setDanoMaximo(5);
		cajadoComum.setDanoMinimo(1);
		cajadoComum.setTipoArma("Cajado Comum");
		
		// DADOS DO BARBARO
		Integer bVida = d2d20()+10;
		Integer bEstamina = d2d6();
		Integer bForca = d1d6();
		Integer bResistencia = d1d6();
		Barbaro barbaro = new Barbaro(bVida,espadaComum, bEstamina, bForca, bResistencia);
		
		// DADOS DO MAGO
		Integer mVida = d2d20()+10;
		Integer mEstamina = d2d6();
		Integer mForca = d1d6();
		Integer mResistencia = d1d6();
		Mago mago = new Mago(mVida, cajadoComum, mEstamina, mForca, mResistencia);
			
		//Scanner sc = new Scanner(System.in);
		
		System.out.println(barbaro);
		System.out.println(mago);
		System.out.println("Dano Espada do barbaro: " + espadaComum.danoArma());
		System.out.println("Dano Cajado do mago: " + cajadoComum.danoArma());
		System.out.println("\n");
		System.out.println("COMEÇOU A BATALHA");
		System.out.println("\n");
		
		
				
		
		int dadoBarbaro = d1d6()+d1d6();
		int dadoMago = d1d6();
		while(dadoBarbaro == dadoMago) {
			dadoBarbaro = d1d6();
			dadoMago = d1d6();
		}
		
		
		char batalha = 's';
		int turno = 0;
		int dano = 0;
		
		System.out.println("=-= ROLAGEM DO DADO =-=");
		System.out.println("");
		
		if(dadoBarbaro > dadoMago) {
			System.out.println("Dado do Barbaro: " + dadoBarbaro);
			System.out.println("Dado do Mago: " + dadoMago);
			System.out.println("=-= Barbaro começa =-=");
		} else { 
			System.out.println("Dado do Barbaro: " + dadoBarbaro);
			System.out.println("Dado do Mago: " + dadoMago);
			System.out.println("=-= Mago começa =-=");
		} 
		
		while (batalha == 's') {
			turno = turno + 1;
			System.out.println("");
			System.out.println("=-=-=-=-=-= Turno " + turno + "º =-=-=-=-=-=");
			Thread.sleep(0001);
			
			if(dadoBarbaro > dadoMago) {
								
				if(barbaro.getVida() > 0) {
					// ATAQUE BARBARO			
					dano = barbaro.ataque();
					System.out.println("Barbaro ataque " + dano);
					mago.defesa(dano);
						
					System.out.println("Mago agora tem " + mago.getVida() + " de vida");
					
					if(mago.getVida() <= 0) {
						batalha = 'n';
						System.out.println("Barbaro ganhou!");
					}
						
				}
				
				System.out.println("");
				
				if (mago.getVida() > 0){		
					// ATAQUE MAGO
						dano = mago.ataque();
						System.out.println("Mago ataque " + dano);
						barbaro.defesa(dano);
							
						System.out.println("Barbaro agora tem " + barbaro.getVida() + " de vida");
						
						if(barbaro.getVida() <= 0) {
							batalha = 'n';
							System.out.println("Mago ganhou!");
						}
				}
				
				
			} else {
												
				if (mago.getVida() > 0){		
					// ATAQUE MAGO
						dano = mago.ataque();
						System.out.println("Mago ataque " + dano);
						barbaro.defesa(dano);
							
						System.out.println("Barbaro agora tem " + barbaro.getVida() + " de vida");
						
						if(barbaro.getVida() <= 0) {
							batalha = 'n';
							System.out.println("Mago ganhou!");
						}
				}
				
				System.out.println("");
				
				if(barbaro.getVida() > 0) {
					// ATAQUE BARBARO			
					dano = barbaro.ataque();
					System.out.println("Barbaro ataque " + dano);
					mago.defesa(dano);
						
					System.out.println("Mago agora tem " + mago.getVida() + " de vida");
					
					if(mago.getVida() <= 0) {
						batalha = 'n';
						System.out.println("Barbaro ganhou!");
					}
				} 
			}
			
			
			
			
			
		}
		
		System.out.println("A batalha terminou no " + turno + "º turno");
		//sc.close();
	}
	
	public static Integer aleatorio() {
		
		Random aleatorio = new Random();
		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		List<Integer> lista = new ArrayList<>();
		
		for(int i=1; i<=6; i++) {
			lista1.add(d1d6());
			lista2.add(d1d6());
		}
		
		System.out.println(lista1);
		System.out.println(lista2);
		
		for(int i=1; i<=6; i++) {
			
			if (i%2 == 0) {
				lista.add(lista1.get(i-1));
			} else { 
				lista.add(lista2.get(i-1));
			}
		}
		System.out.println(lista);
		
		
		Integer result = aleatorio.nextInt(6)+1;
		Integer retorna = lista.get(result-1);
		
				
		return retorna;	
	}
	
	
	public static Integer d1d6() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(6)+1;
		return result;
	}
	
	public static Integer d2d6() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(12)+2;
		return result;
	}
	
	public static Integer d1d20() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(20)+1;
		return result;
	}
	
	public static Integer d2d20() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(40)+2;
		return result;
	}

}
