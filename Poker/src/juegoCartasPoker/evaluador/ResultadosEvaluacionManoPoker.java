package juegoCartasPoker.evaluador;

import java.util.ArrayList;
import java.util.Collections;

import juegoCartasPoker.objetos.CartaPoker;
import juegoCartasPoker.soporte.SoportePoker;
import juegoCartasPoker.soporte.enums.JugadasPokerEnum;
import juegoCartasPoker.soporte.enums.NumerosPokerEnum;
import juegocartas.comparadores.ComparadorAs;

public class ResultadosEvaluacionManoPoker {
	
	ArrayList<CartaPoker> coincidencias = new ArrayList<>();
	ArrayList<CartaPoker> resto = new ArrayList<>();
	JugadasPokerEnum jugada = JugadasPokerEnum.NULA;	
	public ResultadosEvaluacionManoPoker() {

	
	}

	public void sumarCoincidencia(CartaPoker c, boolean autoDefinir){
		coincidencias.add(c);
		if(autoDefinir)autoDefinirJugada();
	}

	public void sumarCoincidencia(ArrayList<CartaPoker> cartas, boolean autoDefinir){
		for(CartaPoker c : cartas) coincidencias.add(c);
		if(autoDefinir)autoDefinirJugada();
		
	}
	
	public void sumarResto(CartaPoker c){resto.add(c);}
	public void sumarResto(ArrayList<CartaPoker> cartas, boolean autoDefinir){
		for(CartaPoker c : cartas) resto.add(c);
		if(autoDefinir)autoDefinirJugada();
	}
	
	
	
	public void autoDefinirJugada(){ 
		switch (coincidencias.size()) {
			case 4:
				definirJugada(JugadasPokerEnum.POKER);
				break;
			case 3:
				definirJugada(JugadasPokerEnum.TRIO);
				break;
			case 2:
				definirJugada(JugadasPokerEnum.PAREJA);
				break;
			case 1:
				definirJugada(JugadasPokerEnum.CARTA_MAS_ALTA);
				break;
			default:
				definirJugada(JugadasPokerEnum.NULA);
			break;
		}
	}
	
	public void definirJugada(JugadasPokerEnum jugada){ this.jugada = jugada;}
	public JugadasPokerEnum jugada(){ return jugada;}
	public int valorSimplejugada(){ return jugada.valor();}
	public String textoJugada(){ return jugada.cadena();}
	public ArrayList<CartaPoker> coincidencias(){return coincidencias;}
//	public ArrayList<CartaPoker> resto(){return (ArrayList<CartaPoker>) resto.clone();}
	public ArrayList<CartaPoker> resto(){return resto;}
	
	

	/**
	 * COINCIDENCIAS GUARDA
	 * MANO COMPLETA ORDENADA EN CASO DE 
	 * 		ESCALERA REAL, ESCALERA COLOR, COLOR, ESCALERA
	 */
	
	public CartaPoker cartaMasAlta() throws NullPointerException{
		
		switch (jugada()) {
		case POKER:
		case TRIO:
		case DOBLE_PAREJA:
		case PAREJA:
			return Collections.max(resto(),new ComparadorAs());
		case CARTA_MAS_ALTA:
			ArrayList<CartaPoker> c = new ArrayList<>();
			for(CartaPoker k : coincidencias) c.add(new CartaPoker(k));
			for(CartaPoker k : resto) c.add(new CartaPoker(k));
			return Collections.max(c,new ComparadorAs());
		default:
			throw new NullPointerException();
			
		}
		
	}
	
	public int jugadaAl(){
		
		switch (jugada()) {
		case POKER:
		case TRIO:
		case DOBLE_PAREJA:
		case PAREJA:
			return esAs(cartaMasAlta().numero());
		case CARTA_MAS_ALTA:
			return esAs(cartaMasAlta().numero());			
		default:
			return -1;
		}
		
	}
	
	
	
	public int trioDe(){
		
		switch (jugada()) {
		
			case TRIO:
			case FULL:		
				return esAs(coincidencias().get(0).numero());
			default:
				return -1;
		}
		
	}
	
	public int parejaDe()
	/**
	 * Devuelve de que es la pareja cuando la jugada es 
	 * PAREJA o FULL
	 * Para DOBLES devuelve el número más alto 
	 */
	{		
		
		switch (jugada()) {
		
		
			case PAREJA:
				return esAs(coincidencias().get(0).numero());
			case DOBLE_PAREJA:
				return esAs(Collections.max(coincidencias, new ComparadorAs()).numero());
			case FULL:		
				return esAs(coincidencias().get(3).numero());
			default:
				return -1;
		}
		
	}
	
	public int[] doblesDe(){
		
		int p = esAs(Collections.max(coincidencias, new ComparadorAs()).numero());
		return (jugada() == JugadasPokerEnum.DOBLE_PAREJA) ?
				new int[]{esAs(coincidencias().get(0).numero()),esAs(coincidencias().get(2).numero())} 
				: null;
		
	}
	
	public int esAs(int n){return (n == NumerosPokerEnum.AS.valor()) ? 13 : n;}
	
	public int distintivo1(){
		switch (jugada()) {
			case CARTA_MAS_ALTA:	
			case PAREJA:		
			case FULL:	
			case POKER:
			case TRIO:
				return esAs(coincidencias().get(0).numero());
			case DOBLE_PAREJA:		
			case ESCALERA:			
			case COLOR:
			case ESCALERA_COLOR:
			case ESCALERA_COLOR_REAL:
				return esAs(Collections.max(coincidencias, new ComparadorAs()).numero());
		default:
			return -1;
		}
	}
		
	public int distintivo2(){

		try {return esAs(cartaMasAlta().numero());} 
		catch (NullPointerException e) {return 13;}
	
	}
	
	public int[] distintivos(){return new int[] {jugada().valor(),distintivo1(),distintivo2()};}
	
	public ArrayList<Integer> listaDistintivos(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(int n : distintivos()) lista.add(new Integer(n));
		return lista;
	
	}
	
	
	public int compararDistintivos(ArrayList<Integer> l1,ArrayList<Integer> l2){
		
		for(int n = 0 ; n < l1.size() ; n++){
			if(l1.get(n).intValue() > l2.get(n).intValue()) return 1;
			if(l1.get(n).intValue() < l2.get(n).intValue()) return -1;
		}
		return 0;
	}
	
	public int compararCon(ResultadosEvaluacionManoPoker otra){return compararDistintivos(listaDistintivos(), otra.listaDistintivos());}
	
	public String informeJugada(){
		
		String aux =  "";
		aux += jugada().cadena();
		switch (jugada()) {
		case CARTA_MAS_ALTA:
			aux +=" : " + coincidencias.get(0).cadena();
			break;
		case PAREJA:
			aux += " de " + NumerosPokerEnum.pluralParaElNumero(parejaDe());
			break;
		case FULL:	
			aux += " de " + NumerosPokerEnum.pluralParaElNumero(trioDe()) 	
				+ "," + NumerosPokerEnum.pluralParaElNumero(parejaDe());
				
			break;
		case POKER:
			aux += " de " + NumerosPokerEnum.pluralParaElNumero(distintivo1()) 
			+ " al " + NumerosPokerEnum.textoParaElNumero(distintivo2());
			break;
		case TRIO:
			aux += " de " + NumerosPokerEnum.pluralParaElNumero(distintivo1()) 
			+ " al " + NumerosPokerEnum.textoParaElNumero(distintivo2());
			break;
		case DOBLE_PAREJA:	
			int[] d = doblesDe();
			aux += " de " + NumerosPokerEnum.pluralParaElNumero(d[0]) + " y " + NumerosPokerEnum.pluralParaElNumero(d[1])
				+ " al " + NumerosPokerEnum.textoParaElNumero(distintivo2());
			break;
		case ESCALERA:			
		case COLOR:
		case ESCALERA_COLOR:
		case ESCALERA_COLOR_REAL:
			aux += " al " + NumerosPokerEnum.textoParaElNumero(distintivo2());
			break;
		default:
			break;
	}
		return aux;
	}
	
	public void imprimirResultado()
	{ 
		System.out.println("Resultado : " + textoJugada() + ".");
		SoportePoker.imprimirMano(coincidencias, "Coincidencias");
		SoportePoker.imprimirMano(resto, "Resto");
	}	
	
	public void imprimirInformeJugada(){
		System.out.println("Inicio Informe Jugada ");
		System.out.println(informeJugada());
		System.out.println("Fin Informe Jugada");
		
	}
	
	public void imprimirInformeCompleto(){
		imprimirResultado();
//		imprimirInformeJugada();
	}
	
	public void imprimirComparacionCon(ResultadosEvaluacionManoPoker otra){
		System.out.println("Inicio Comparacion ");
		System.out.print("Resultado: ");
		System.out.println(compararCon(otra));
		System.out.println("Fin Comparacion ");
		
	}
	
}