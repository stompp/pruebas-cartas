package juegocartas.comparadores;

import java.util.Comparator;

import juegoCartasPoker.objetos.CartaPoker;
import juegocartas.objetos.Carta;

public class ComparadorAs implements Comparator {

		final static int MAYOR = 1;
		final static int MENOR = -1;
		final static int IGUAL = 0;
		final static int AS = 0;
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
		
			if((o1.getClass() == Carta.class)){
				return Cartas((Carta)o1,(Carta)o2);	
			}
			
			return Cartas((CartaPoker)o1,(CartaPoker)o2);	
			
//			if(((Carta) o1).numero() < ((Carta) o2).numero()) {
//				
//				if(((Carta) o1).numero() == AS) return MAYOR;
//				return MENOR;
//			}
//			if(((Carta) o1).numero() > ((Carta) o2).numero()) {
//				if(((Carta) o2).numero() == AS) return MENOR;
//				return MAYOR;
//			}
//			return IGUAL;
			
		}
		
		int Cartas(Carta o1, Carta o2) {
			// TODO Auto-generated method stub
		
				if( o1.numero() <  o2.numero()) {
					if( o1.numero() == AS) return MAYOR;
					return MENOR;
				}
				if( o1.numero() > ( o2).numero()) {
					if(o2.numero() == AS) return MENOR;
					return MAYOR;
				}
				return IGUAL;
			}
		int Cartas(CartaPoker o1, CartaPoker o2) {
			// TODO Auto-generated method stub
		
				if( o1.numero() <  o2.numero()) {
					if( o1.numero() == AS) return MAYOR;
					return MENOR;
				}
				if( o1.numero() > ( o2).numero()) {
					if(o2.numero() == AS) return MENOR;
					return MAYOR;
				}
				return IGUAL;
			}
		


	}

