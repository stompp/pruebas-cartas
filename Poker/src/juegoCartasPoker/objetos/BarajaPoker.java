package juegoCartasPoker.objetos;

import java.util.ArrayList;

import juegoCartasPoker.JuegoPoker;
import juegocartas.objetos.Baraja;
import juegocartas.objetos.Carta;

public class BarajaPoker extends Baraja {
	


	public BarajaPoker() {	
		super(JuegoPoker.soporte);
	}
	
	@Override
	public void iniciarBaraja(){
		baraja = new ArrayList<Carta>();
		for(int n = 0 ; n < variables.totalCartas() ; n++ ){
			baraja.add(new CartaPoker(variables.numeroPorNumeroG(n),variables.paloPorNumeroG(n)));
		}
	}

	@Override
	public CartaPoker sacarCartaSuperior() {
		// TODO Auto-generated method stub
		return (CartaPoker)super.sacarCartaSuperior();
	}

}
