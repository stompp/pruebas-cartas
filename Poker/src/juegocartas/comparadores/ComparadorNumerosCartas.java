package juegocartas.comparadores;

import java.util.Comparator;

import juegocartas.objetos.Carta;



public class ComparadorNumerosCartas implements Comparator {


	final static int MAYOR = 1;
	final static int MENOR = -1;
	final static int IGUAL = 0;
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(((Carta) o1).numero() < ((Carta) o2).numero()) return MENOR;
		if(((Carta) o1).numero() > ((Carta) o2).numero()) return MAYOR;
		return IGUAL;

	}


}
