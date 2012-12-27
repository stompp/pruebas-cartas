package pruebasPoker;

import java.util.ArrayList;

import juegoCartasPoker.objetos.CartaPoker;

public class ManosFalsas {
	
	/**
	 * Manos falsas para pruebas
	 * 
	 */
	
	static public ArrayList<CartaPoker> manoFalsa(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(12,0));
		manoFalsa.add(new CartaPoker(9,2));
		manoFalsa.add(new CartaPoker(1,1));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Color(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,3));
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(1,3));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Escalera(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(0,3));
		manoFalsa.add(new CartaPoker(1,2));
		manoFalsa.add(new CartaPoker(2,0));
		manoFalsa.add(new CartaPoker(3,1));
		manoFalsa.add(new CartaPoker(4,1));
		
		return manoFalsa;			
	}
	static public ArrayList<CartaPoker> EscaleraCiclicaDesordenada(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(10,2));
		manoFalsa.add(new CartaPoker(11,0));
		manoFalsa.add(new CartaPoker(0,1));
		manoFalsa.add(new CartaPoker(1,1));
		
		return manoFalsa;			
	}
	static public ArrayList<CartaPoker> EscaleraColor(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(0,3));
		manoFalsa.add(new CartaPoker(1,3));
		manoFalsa.add(new CartaPoker(2,3));
		manoFalsa.add(new CartaPoker(3,3));
		manoFalsa.add(new CartaPoker(4,3));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> EscaleraReal(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(0,3));
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(10,3));
		manoFalsa.add(new CartaPoker(11,3));
		manoFalsa.add(new CartaPoker(12,3));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Poker(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(0,3));
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(9,2));
		manoFalsa.add(new CartaPoker(9,1));
		manoFalsa.add(new CartaPoker(9,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Full(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(5,3));
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(5,2));
		manoFalsa.add(new CartaPoker(9,1));
		manoFalsa.add(new CartaPoker(9,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Trio(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(7,2));
		manoFalsa.add(new CartaPoker(9,1));
		manoFalsa.add(new CartaPoker(9,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Dobles(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(9,1));
		manoFalsa.add(new CartaPoker(9,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> Pareja(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(9,3));
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(6,1));
		manoFalsa.add(new CartaPoker(0,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> CartaMasAlta(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(6,1));
		manoFalsa.add(new CartaPoker(3,0));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> CartasEnMesaEscalera(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(6,1));
		manoFalsa.add(new CartaPoker(3,0));
		manoFalsa.add(new CartaPoker(5,1));
		manoFalsa.add(new CartaPoker(2,1));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> CartasEnMesaCartaMasAlta(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(4,3));
		manoFalsa.add(new CartaPoker(9,1));
		manoFalsa.add(new CartaPoker(3,0));
		manoFalsa.add(new CartaPoker(6,1));
		manoFalsa.add(new CartaPoker(11,1));
		manoFalsa.add(new CartaPoker(2,1));
		
		return manoFalsa;			
	}
	
	static public ArrayList<CartaPoker> CartasEnMesaColor(){
		
		ArrayList<CartaPoker> manoFalsa = new ArrayList<CartaPoker>();
		
		manoFalsa.add(new CartaPoker(12,3));
		manoFalsa.add(new CartaPoker(0,2));
		manoFalsa.add(new CartaPoker(6,1));
		manoFalsa.add(new CartaPoker(3,1));
		manoFalsa.add(new CartaPoker(5,1));
		manoFalsa.add(new CartaPoker(11,1));
		manoFalsa.add(new CartaPoker(0,1));
		
		return manoFalsa;			
	}
	
	static public ArrayList<ArrayList<CartaPoker>> todas(){
		
		ArrayList<ArrayList<CartaPoker>> todas = new ArrayList<ArrayList<CartaPoker>>();
		
		ArrayList<CartaPoker> color =  Color();
		todas.add(color);
		ArrayList<CartaPoker> escalera  = Escalera();
		todas.add(escalera);
		ArrayList<CartaPoker> escaleraCiclicaDesordenada  = EscaleraCiclicaDesordenada();
		todas.add(escaleraCiclicaDesordenada);
		ArrayList<CartaPoker> escaleraColor  = EscaleraColor();
		todas.add(escaleraColor);
		ArrayList<CartaPoker> escaleraReal = EscaleraReal();
		todas.add(escaleraReal);
		ArrayList<CartaPoker> poker = Poker();
		todas.add(poker);
		ArrayList<CartaPoker> full = Full();
		todas.add(full);
		ArrayList<CartaPoker> trio = Trio();
		todas.add(trio);
		ArrayList<CartaPoker> dobles =  Dobles();
		todas.add(dobles);
		ArrayList<CartaPoker> pareja = Pareja();
		todas.add(pareja);
		ArrayList<CartaPoker> manoFalsa = manoFalsa();
		todas.add(manoFalsa);
			
		
		
	

		
		return todas;			
	}


}
