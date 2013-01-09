package juegoCartasPoker.soporte.enums;

public enum NumerosPokerEnum{
	
	AS(0),
	DOS(1),
	TRES(2),
	CUATRO(3),
	CINCO(4),
	SEIS(5),
	SIETE(6),
	OCHO(7),
	NUEVE(8),
	DIEZ(9),
	JACK(10),
	REINA(11),
	REY(12);
	
	final static String[] cadenas = {"As",
			"Dos",
			"Tres",
			"Cuatro",
			"Cinco",
			"Seis",
			"Siete",
			"Ocho",
			"Nueve",
			"Diez",
			"Jack",
			"Reina",
			"Rey"
	};
	
	int valor = 0;
	
	NumerosPokerEnum(int valor){this.valor = valor;}
	
	public int valor(){return valor;}
	
	public String cadena(){return textoParaElNumero(valor);}
	
	public String cadenaPlural(){return pluralParaElNumero(valor);}
		
	static public String pluralParaElNumero(int numero){
		
			switch (numero) {
				case 0:
				case 1:
				case 2:
				case 5:
				case 12:
				return cadenas[numero]+"es";
				case 9:	return ("Dieces");
				case 13:return cadenas[0]+"es";
				default:
					return (numero<cadenas.length) ? cadenas[numero] +"s" :
							"No especificada para el valor : "+String.valueOf(numero) + " .";
			}
			

	}
	static public String textoParaElNumero(int numero){
		int n = (numero == 13) ? 0 : numero; 
		return ((n<cadenas.length) && (n>=0)) ? cadenas[n]:"No especificada para el valor : "+String.valueOf(n) + " .";		
	}
	
	static public String aloala(int numero){
		
		if(numero == REINA.valor) return " a la ";
		else return " al "; 
	}
	
}