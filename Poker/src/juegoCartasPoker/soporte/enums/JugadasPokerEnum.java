package juegoCartasPoker.soporte.enums;

public enum JugadasPokerEnum{			
	NULA(0),
	CARTA_MAS_ALTA(1),
	PAREJA(2),
	DOBLE_PAREJA(3),
	TRIO(4),
	ESCALERA(5),
	COLOR(6),
	FULL(7),
	POKER(8),
	ESCALERA_COLOR(9),
	ESCALERA_COLOR_REAL(10);
	
	int valor = 0;
	
	String[] cadenas = {"Nula",
			"Carta más alta",
			"Pareja",
			"Dobles Parejas ",
			"Trío",
			"Escalera",
			"Color",
			"Full",
			"Poker",
			"Escalera de color",
			"Escalera Real"};
	
	JugadasPokerEnum(int valor){this.valor = valor;}	
	public int valor(){return valor;}
	
	public String cadena(){
		return ((valor<cadenas.length) && (valor >= 0)) ? 
				cadenas[valor] : "No especificada para el valor : "+String.valueOf(valor) + " .";
	}
	
	
	
}