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
		// DADOS DAS ARMAS (CRIA O OBJETO E ATRIBUI O VALOR DO DANO MINIMO E MAXIMO A ELE.)
		Arma espadaComum = new Arma();
		espadaComum.setDanoMaximo(5);
		espadaComum.setDanoMinimo(1);
		espadaComum.setTipoArma("Espada Comum");
		
		Arma cajadoComum = new Arma();
		cajadoComum.setDanoMaximo(5);
		cajadoComum.setDanoMinimo(1);
		cajadoComum.setTipoArma("Cajado Comum");
		
		// DADOS DO BARBARO 
		// D2D20, D1D6 ETC.. SAO FUN�OES CRIADAS DEPOIS DA LINHA 170 PARA SIMULAR JOGADA DE DADOS.
		// ATRIBUINDO AS VARIAVES OS RESULTADOS DOS RESPECTIVOS DADOS 
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
			
		Scanner sc = new Scanner(System.in);
		
		//INICIO DA BATALHA
		System.out.println(barbaro);
		System.out.println(mago);
		System.out.println("Dano Espada do barbaro: " + espadaComum.danoArma());
		System.out.println("Dano Cajado do mago: " + cajadoComum.danoArma());
		System.out.println("\n");
		System.out.println("COME�OU A BATALHA");
		System.out.println("\n");
		
		
				
		// AS PROXIMAS 6 LINHAS � PARA DECIDIR QUEM INICIA A BATALHA PELO RESULTADO MAIOR NO DADO
		int dadoBarbaro = d1d6();
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
		
		// INFORMA QUEM COME�ARA A BATALHA
		if(dadoBarbaro > dadoMago) {
			System.out.println("Dado do Barbaro: " + dadoBarbaro);
			System.out.println("Dado do Mago: " + dadoMago);
			System.out.println("=-= Barbaro come�a =-=");
		} else { 
			System.out.println("Dado do Barbaro: " + dadoBarbaro);
			System.out.println("Dado do Mago: " + dadoMago);
			System.out.println("=-= Mago come�a =-=");
		} 
		
		// LA�O ONDE A BATALHA ACONTECE AT� QUE UM VEN�A.
		while (batalha == 's') {
			
			turno = turno + 1;
			System.out.println("");
			System.out.println("=-=-=-=-=-= Turno " + turno + "� =-=-=-=-=-=");
//			Thread.sleep(4500);
			
			// IF QUE INICIA A BATALHA COM O BARBARO 
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
				
			// ELSE PARA INICIAR COM O MAGO CASO O IF DO BARBARO FALHE. 	
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
			
			if(batalha == 's') {
				System.out.println("\n Precione enter para o pr�ximo round");
				sc.nextLine();
			}
			
			
		}			
		System.out.println("A batalha terminou no " + turno + "� turno");
		sc.close();
	}
	
	// DAQUI PARA BAIXO S�O FUN�OES QUE SIMULA DADOS
	// A FUN��O aleatorio() � UMA TENTATIVA DE AUMENTAR A ELEATORIEDADE DO DADO. � UM D6
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
	
	// DADO 1D6
	public static Integer d1d6() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(6)+1;
		return result;
	}
	
	// DADO 2D6
	public static Integer d2d6() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(12)+2;
		return result;
	}
	
	// DADO 1D20
	public static Integer d1d20() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(20)+1;
		return result;
	}
	
	// DADO 2D20
	public static Integer d2d20() {
		Random sortDado = new Random();
		Integer result = sortDado.nextInt(40)+2;
		return result;
	}

}
