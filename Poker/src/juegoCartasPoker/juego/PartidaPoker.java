package juegoCartasPoker.juego;

import java.util.ArrayList;

import juegoCartasPoker.evaluador.EvaluadorManosPoker;
import juegoCartasPoker.objetos.BarajaPoker;
import juegoCartasPoker.objetos.CartaPoker;


public class PartidaPoker {
	
	// variables
	int ronda = 0;
	int jugadorDeMano = 0;
	float mayorApuesta = 0f;
	
	float apuestaMinima = 10f;
	
	// objetos
	BarajaPoker barajaPoker;
	ArrayList<CartaPoker> cartasMesa = new ArrayList<CartaPoker>();
	
	// jugadores
	ArrayList<JugadorPoker> jugadores = new ArrayList<JugadorPoker>();
	
	// evaluador de manos
	EvaluadorManosPoker evaluador = new EvaluadorManosPoker();
	
	public PartidaPoker(ArrayList<JugadorPoker> jugadores) {
		
		this.jugadores = jugadores;
		barajaPoker = new BarajaPoker();
		barajaPoker.barajar();
		
	}
	
	
	/**
	 * Para jugar.
	 * Se reparten dos cartas a cada jugador.
	 * 		- TODO :
	 * 		
	 */
	public void cicloMano(){
		
		
		
	}
	
	
	public void repartirCartas(){
		
		barajaPoker.barajar();
		// reparte dos cartas
		for(int n = 0; n < 2 ; n++){
			for(JugadorPoker jugador : jugadores){
			//TODO
				if(jugador.estado.ordinal() !=  -1)jugador.recibirCarta(barajaPoker.sacarCartaSuperior());
			}
		}
		
	}
	public void sacarCartaEnMesa(){
		
		// quemar
		CartaPoker carta = (CartaPoker) barajaPoker.sacarCartaSuperior();
		// echar en la mesa
		cartasMesa.add((CartaPoker) barajaPoker.sacarCartaSuperior());
	}
	
	

}
