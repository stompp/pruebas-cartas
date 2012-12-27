package juegoCartasPoker.juego;

import java.util.ArrayList;

import juegoCartasPoker.objetos.CartaPoker;
import juegocartas.*;
import juegocartas.objetos.Carta;


enum EstadosJugador{
	ACTIVO,
	PASADO,
	PASANDO,
	APOSTADO,
	APOSTANDO,
	RETIRADO,
	BANCARROTA
}

enum opcionesJugador{
	PASAR,
	APOSTAR
}
public class JugadorPoker {
	
	final static int MAX_CARTAS = 2;
	ArrayList<CartaPoker> cartas = new ArrayList<CartaPoker>();
	
	float fondo;
	EstadosJugador estado = EstadosJugador.ACTIVO;
	
	public void actualizarEstado(){
		
		if(fondo == 0 ) estado = EstadosJugador.BANCARROTA;
	}
	
	public float apostar(float cantidad){
		
		if ((cantidad <= fondo) && (cantidad > 0))fondo -= cantidad;
		else {
			cantidad = fondo;
			fondo = 0.0f;
		}
		
		return cantidad;
	}
	
	public void recibirCarta(Carta carta){
		if(cartas.size()< MAX_CARTAS) cartas.add((CartaPoker) carta);
	}
	
	public ArrayList<CartaPoker> cartas(){
		return cartas;
	}
	
	
	

}
