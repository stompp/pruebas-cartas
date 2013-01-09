package juegoCartasPoker.objetos;

import juegoCartasPoker.JuegoPoker;
import juegoCartasPoker.soporte.CostantesPoker;
import juegocartas.objetos.Carta;

public class CartaPoker extends Carta{
	
	public CartaPoker (int numero, int palo){
		super(numero, palo);
	}
	public CartaPoker (Carta carta){
		super(carta);
	}
	public CartaPoker (){
		super();
	}
	
	
	public String cadena(){return JuegoPoker.soporte.cadenaCarta(numero(), palo());}
   	
	@Override
	public int numeroG(){return palo*CostantesPoker.NUMEROS_POR_PALO + numero;}
}