package juegocartas.soporte;



  public abstract class SoporteJuegoCartas implements EsqueletoVariablesJuegoCartas{

	
	
	
	
	/**
	 * Metodos a sobrescribir
	 */
//	public int palos(){return 0;}
//	public int numerosPorPalo(){return 0;}
//	public int comodines(){return 0;}
//    public String cadenaNumero(int numero){return null;}
//	public String cadenaPalo(int palo){return null;}
//	public String cadenaCarta(int numero,int palo){return null;}
//	public int paloPorNumeroG(int numeroG){return 0;}
//	public Carta cartaPorNumeroG(int numeroG){return null;}
	
	
	
	/**
	 * Metodos
	 */
	public int totalCartasBasicas(){return palos()*numerosPorPalo();}
	public int totalCartas(){return totalCartasBasicas() + comodines();}
	
	public int numeroPorNumeroG(int numeroG){
		if(numeroG < totalCartasBasicas()){
			return numeroG%numerosPorPalo();
		}else return numeroG - totalCartasBasicas();
	}
	
	public boolean esCarta(int numeroG){return (numeroG > 0) && (numeroG < totalCartas());}
	
	public SoporteJuegoCartas obtener() {return this;}

		
}
