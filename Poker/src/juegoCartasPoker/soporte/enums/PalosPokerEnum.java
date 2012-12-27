package juegoCartasPoker.soporte.enums;

public enum PalosPokerEnum {

		CORAZONES(0),
		DIAMANTES(1),
		PICAS(2),
		TREBOLES(3);
		
		int valor = 0;
		final static String[] cadenas = new String[]{
			"Corazones",
			"Diamantes",
			"Picas",
			"Tréboles",
			"Comodín"
		};	
			
		PalosPokerEnum(int valor){this.valor = valor;}	
		public int valor(){return valor;}
		
		public String cadena(){
			return ((valor<cadenas.length) && (valor >= 0)) ? 
					cadenas[valor] : "Palo no especificado para el valor : "+String.valueOf(valor) + " .";
		}
		
		
	}

