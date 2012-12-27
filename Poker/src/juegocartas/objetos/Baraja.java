package juegocartas.objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import juegocartas.soporte.SoporteJuegoCartas;



public class Baraja {
	
	
	protected ArrayList<Carta> baraja;
	protected SoporteJuegoCartas variables;
	
//	public Baraja(int palosTotal,int cartasPorPalo,int comodinesTotal) {
//		
//		this.palosTotal = palosTotal;
//		this.cartasPorPalo = cartasPorPalo;
//		this.comodinesTotal = comodinesTotal;	
//		iniciarBaraja();
//				
//	} 
	
	public Baraja(SoporteJuegoCartas variables) {
		
		this.variables = variables;
		
		iniciarBaraja();
				
	} 
	

	

	/**
	 * Funciones básicas baraja
	 */
	public ArrayList<Carta> baraja(){return baraja;}
	protected int cartasInicialesEnBaraja(){return variables.totalCartas();}
	public void barajar(){Collections.shuffle(baraja);}	
	public int cartasEnBaraja(){return baraja.size();}
	public boolean quedanCartas(){
		if(cartasEnBaraja()>0) return true;
		else return false;
	}
	public Carta sacarCartaSuperior(){
		if(quedanCartas()){
			Carta c = baraja.get(0);
			baraja.remove(0);
			return c;
		}else{
			return null;
		}
		
	}
	public Carta sacarCartaInferior(){
		if(quedanCartas()){
			Carta c = baraja.get(baraja.size()-1);
			baraja.remove(baraja.size()-1);
			return c;
		}else return null;		
	}
	
	
	/**
	 * Impresión Datos
	 */
	
	public void imprimir(){
		int n = 0;	
		for(Carta c : baraja()){
			System.out.print(n);
			System.out.print(" ");
			System.out.println(c.cadena());
			n++;
		}
	}
	
	public void imprimir(int numeroG){
		int n = 0;	
		for(Carta c : baraja()){
			System.out.print(n);
			System.out.print(" ");
			System.out.println(c.cadena());
			n++;
		}
	}
	
	
	/**
	 * Metodos a sobrescribir
	 */
	
	
	public void iniciarBaraja(){}
	
	
	

	
	
	

}
