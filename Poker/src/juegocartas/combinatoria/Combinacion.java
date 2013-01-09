package juegocartas.combinatoria;

import java.util.ArrayList;


public class Combinacion{
	
	int M;
	int MAX;
	int orden;
	ArrayList<Integer> valores = new ArrayList<Integer>();
	

	public Combinacion(int M,int inicial) {
		this.M = M;
		this.orden = 1;
		valores.add(new Integer(inicial));	
	}
	
	public Combinacion() {
	}
	
	
	
	public Combinacion(Combinacion c) {
		copiar(c);
	}
	
	public int M(){return this.M;}
	public int orden(){return this.orden;}
	public ArrayList<Integer> valores(){return valores;}
	
	public int ultimo(){
		if(valores.size()>0)return valores.get(valores.size()-1).intValue();
		else return M();
	}
	
	public boolean tieneSiguiente(){
		return (ultimo()<(M-1));
	}
	public void introducirNuevo(int indice){
		valores.add(new Integer(indice));
		orden++;
		
	}
	
	public void copiar(Combinacion c){
		
		this.M = c.M();
		this.orden = c.orden();
		valores.clear();
		for(Integer i : c.valores)valores.add(new Integer(i));
	}
}