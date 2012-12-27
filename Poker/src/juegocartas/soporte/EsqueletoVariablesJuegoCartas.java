package juegocartas.soporte;

import juegocartas.objetos.Carta;

public interface EsqueletoVariablesJuegoCartas {
	
	public int palos();
	public int numerosPorPalo();
	public int comodines();
    public String cadenaNumero(int numero);
	public String cadenaPalo(int palo);
	public String cadenaCarta(int numero,int palo);
	public int paloPorNumeroG(int numeroG);
	public Carta cartaPorNumeroG(int numeroG);
	
	public int totalCartasBasicas();
	public int totalCartas();
	
	public int numeroPorNumeroG(int numeroG);
	
	boolean esCarta(int numeroG);
	



}
