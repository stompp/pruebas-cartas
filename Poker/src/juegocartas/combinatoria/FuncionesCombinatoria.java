package juegocartas.combinatoria;

import java.util.ArrayList;

public class FuncionesCombinatoria {

	
	public long factorial(long N){	
		long fact = 1;
		for(int n = (int) N ; n > 1 ; n--) fact *=n;
		return fact;
	}
	
	public int factorial(int N){	
		int fact = 1;
		for(int n =  N ; n > 1 ; n--) fact *=n;
		return fact;
	}
	
	
	public void pruebaFactorial(){
		
		for(int n = 0 ; n <= 20; n++){
			System.out.println("Factorial de " + String.valueOf(n) + " = " + String.valueOf(factorial((long)n)) );
		}
	}
	
	public int numeroCombinatorio(int m,int n){
		// (m)Grupos de N elementos de M(m n)
		// (n)
		
		long subconjuntos = factorial(m)/factorial(n);
		subconjuntos /= factorial(m-n);
		return (int) subconjuntos;
	}
	
	public void pruebaCombinatoria(int m){
		
		for(int n = 1 ; n <= m; n++){
			System.out.println("Combinaciones de " + String.valueOf(n) + " de " + String.valueOf(m)+ " = " + String.valueOf(numeroCombinatorio(m, n)) );
		}
	}
	
	public ArrayList<Combinacion> combinacionesNoRepetidas(int M, int orden,ArrayList<Combinacion> previas){
		/**
		 * @param M tamaño del conjunto
		 * @param orden tamaño de subconjunto
		 * @param previas Combinaciones de orden anterior para el cálculo del siguiente
		 */
		
		if(previas == null){
			
			ArrayList<Combinacion> combinaciones = new ArrayList<Combinacion>();
			for(int i = 0 ; i < M ; i++) combinaciones.add(new Combinacion(M, i));
			for(int o = 1; o< orden;o++ ){
				ArrayList<Combinacion> aux = combinacionesNoRepetidas(M, o, combinaciones);
				combinaciones.clear();
				for(Combinacion c : aux){combinaciones.add(new Combinacion(c));}	
			}
			return combinaciones;
			
		}else{
		
			ArrayList<Combinacion> combinaciones = new ArrayList<Combinacion>();
			
			
			for(Combinacion c : previas){
				Combinacion aux1 = new Combinacion(); 
				aux1.copiar(c);
				int n = aux1.ultimo();
			
				while(aux1.tieneSiguiente()){
					Combinacion aux2 = new Combinacion(); 
					aux2.copiar(c);
					n++;
					aux2.introducirNuevo(n);
					combinaciones.add(aux2);
					aux1.copiar(aux2);
				}
			}
			
			return combinaciones;
				
			
			
		}
		
		
		
		
	}
	
	public void pruebaCombinaciones(int M, int orden){
		
		ArrayList<Combinacion> res = new ArrayList<Combinacion>();
		res = combinacionesNoRepetidas(M, orden, null);
		System.out.println("Combinaciones esperadas : " + String.valueOf(numeroCombinatorio(M, orden)));
		imprimirCombinaciones(res);
		
	}
	
	public void imprimirCombinaciones(ArrayList<Combinacion> lista){
		
		System.out.println("Total combinaciones " + String.valueOf(lista.size()));
		int n = 0;
		for(Combinacion c : lista){
			System.out.print("Combinación " + String.valueOf(n++) + " : ");
			for(Integer i : c.valores()){
				System.out.print(i.intValue());
			}
			System.out.println();
		}
		
	}
	
	
}
