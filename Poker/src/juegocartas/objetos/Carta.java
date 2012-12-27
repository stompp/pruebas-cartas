package juegocartas.objetos;

public class Carta {

	

 	protected int numero;
 	protected int palo;
	
	public Carta (int numero, int palo){
		this.numero = numero;
		this.palo = palo;
		
	}
	
	public Carta (Carta c){
		this.numero = c.numero();
		this.palo = c.palo();
		
	}
	
	public Carta (){
		this.numero = -1;
		this.palo = -1;
		
	}

	/**
	 * Métodos sobre-escribibles
	 * @return
	 */
    public int numero(){return numero;}
    public int palo(){return palo;}
    
    public boolean mayorQue(Carta c){return(numero() > c.numero());}
    public boolean menorQue(Carta c){return(numero() < c.numero());}
    public boolean igualA(Carta c){return(numero() == c.numero());}
    
    
    /**
     * Metodos a sobrescribir
     * 
     */
	public String cadena(){return "Vacía.";};
	public int numeroG(){return -1;};



	
	

	
	
	
}
