package juegoCartasPoker.soporte;

import java.util.ArrayList;
import java.util.Collections;

import juegoCartasPoker.objetos.CartaPoker;
import juegoCartasPoker.soporte.enums.JugadasPokerEnum;
import juegoCartasPoker.soporte.enums.NumerosPokerEnum;
import juegocartas.comparadores.ComparadorNumerosCartas;
import juegocartas.objetos.Carta;
import juegocartas.soporte.SoporteJuegoCartas;




 public class SoportePoker extends SoporteJuegoCartas implements CostantesPoker{
	 
	 
	public int palos(){return PALOS;}

	public int numerosPorPalo(){return NUMEROS_POR_PALO;}
	
	public int comodines(){return COMODINES;}
	
    public String cadenaNumero(int numero){return NumerosPokerEnum.textoParaElNumero(numero);}
	
	public String cadenaPalo(int palo){return cadenasPalos[palo];}
	
	public String cadenaCarta(int numero,int palo){
		if(palo!=COMODIN) return cadenaNumero(numero) + " de " + cadenaPalo(palo);
		else  return cadenaPalo(palo);
		
	}
	
	
	@Override
	public int paloPorNumeroG(int numeroG){
		if(numeroG < totalCartasBasicas()){
			return (numeroG - numeroPorNumeroG(numeroG))/numerosPorPalo();
		}else if (numeroG < totalCartas()){
			return COMODIN;
		}else return NULO;
	}

	
	@Override
	public Carta cartaPorNumeroG(int numeroG){
		if(esCarta(numeroG)){
			return  new CartaPoker(numeroPorNumeroG(numeroG), paloPorNumeroG(numeroG));
		}else return null;
		
	}
	
	// ORDEN CARTAS
	static public ArrayList<CartaPoker> ordenCiclico(ArrayList<CartaPoker> cartas)
	/**
	 * Devuelve una copia de la entrada entrada ordenada ciclicamente
	 */
	{
		
		ArrayList<CartaPoker> cp = new ArrayList<CartaPoker>();
		for (CartaPoker c : cartas) cp.add(new CartaPoker(c));
		Collections.sort(cp, new ComparadorNumerosCartas());
		
		if((cp.get(PRIMERA).numero() == NumerosPokerEnum.AS.valor()) && (cp.get(cp.size()-1).numero() == NumerosPokerEnum.REY.valor())){
			ArrayList<CartaPoker> escaleraAs = new ArrayList<CartaPoker>();
			int ant = 0;
			int dif = 1;
			int n = 0;
			while(dif <= 1){
				escaleraAs.add(cp.get(PRIMERA));
				cp.remove(PRIMERA);
				dif = cp.get(PRIMERA).numero() - ant;
				ant = cp.get(PRIMERA).numero();
				
			}
			
			for(CartaPoker c : escaleraAs){cp.add(c);}
		}

		return cp;
		
	}
	
	public static ArrayList<CartaPoker> copiar(ArrayList<CartaPoker> cartas)
	/**
	 * @return Copia de entrada
	 */
	{
		ArrayList<CartaPoker> cp = new ArrayList<CartaPoker>();
		for(CartaPoker c : cartas) cp.add(new CartaPoker(c));
		return cp;
	}
	

	public static boolean esManoSimple(ArrayList<CartaPoker> mano){return mano.size() == CARTAS_EN_MANO;}
	
	// METODOS IMPRESIÓN TEXTOS
	static public void imprimirMano(ArrayList<CartaPoker> mano){for (CartaPoker c : mano) System.out.println(c.cadena());}
	static public void imprimirMano(ArrayList<CartaPoker> mano,String nombre)
	{
		
		if(mano.size() > 0 ){
			System.out.println(nombre);
			for (CartaPoker c : mano) System.out.println("\t" + c.cadena());
			System.out.println("Fin " + nombre);
		}else{
			System.out.println("Nada en " + nombre);
		}
	}
	
	static public int cartasMinimasEnJugada(JugadasPokerEnum jugada){
		
		switch (jugada) {
			case POKER:
				return LONG_POKER;
			case TRIO:
				return LONG_TRIO;
			case PAREJA:
				return LONG_PAREJA;		
			case DOBLE_PAREJA:
				return LONG_DOBLES;		
			default:
				return CARTAS_EN_MANO;		
		}
		
	}
	






	

	
	
}
