package juegoCartasPoker.evaluador;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.jmx.remote.util.OrderClassLoaders;

import juegoCartasPoker.objetos.CartaPoker;
import juegoCartasPoker.soporte.CostantesPoker;
import juegoCartasPoker.soporte.SoportePoker;
import juegoCartasPoker.soporte.enums.JugadasPokerEnum;
import juegoCartasPoker.soporte.enums.NumerosPokerEnum;
import juegocartas.combinatoria.FuncionesCombinatoria;
import juegocartas.combinatoria.FuncionesCombinatoria.Combinacion;
import juegocartas.comparadores.ComparadorAs;

public final class EvaluadorManosPoker implements CostantesPoker{


	static int tamMin = CARTAS_EN_MANO;
	static int maxOffset;
	
	
	public EvaluadorManosPoker(){
		
		
	}
	
			
	static void refrescarVariables(JugadasPokerEnum jugada, int cartasEnMano){
		tamMin = SoportePoker.cartasMinimasEnJugada(jugada);			
		maxOffset = cartasEnMano - tamMin;	
	}
	
	
	static int tamMin(){return tamMin;}
	static int maxOffset(){return maxOffset;}
	static int coincidenciasNecesarias(){return tamMin() - 1;}
	

public boolean esEscaleraReal(ArrayList<CartaPoker> mano)
/**
 * Comprueba si existe escalera real
 * Comprueba si existe escalera de color
 * Después si INICIO == DIEZ && FIN == AS
 * TODO CAMBIAR OBLIGACIÓN 5 
 */
{		
	if(SoportePoker.esManoSimple(mano) && esEscaleraDeColor(mano))return diezAs(mano);
	return false;	
}

protected static boolean diezAs(ArrayList<CartaPoker> mano){
	mano = SoportePoker.ordenCiclico(mano);
	return (mano.get(PRIMERA).numero() == NumerosPokerEnum.DIEZ.valor()) && (mano.get(ULTIMA).numero() == NumerosPokerEnum.AS.valor());
}

/**
 * Comprueba si existe escalera de color
 * No comprueba tamaño
 */
public boolean esEscaleraDeColor(ArrayList<CartaPoker> mano){return (esEscaleraCiclica(mano) & esColor(mano));}


public static boolean esColor(ArrayList<CartaPoker> mano)
/**
 * Comprueba si toda la mano entrante es del mismo palo
 * No comprueba tamaño
 */
{	
	int color = mano.get(0).palo();
	for(CartaPoker c : mano){if (c.palo() != color) return false;}
	return true;				
}

public static boolean esEscaleraCiclica(ArrayList<CartaPoker> mano)
/**
 * Comprueba si existe escalera
 * No comprueba tamaño
 */
{
	ArrayList<CartaPoker> cp = SoportePoker.ordenCiclico(mano);
//	cp = ordenCiclico(cp);
	
	boolean escalera = true;
	int ini = cp.get(0).numero();
	cp.remove(0);
	int n = 0,act;
	
	
	while((n < cp.size()) && escalera){
		act = cp.get(n).numero();
		if((act == NumerosPokerEnum.AS.valor()) && (ini == NumerosPokerEnum.REY.valor())){
			ini = NumerosPokerEnum.AS.valor();
			n++;
		}else{
			if((act - ini) == 1){ini = act;n++;}
			else escalera = false;	
		}
	}	
	return escalera;		
}
/**
 * Busca ESCALERA REAL, ESCALERA COLOR, COLOR, ESCALERA
 * @param mano
 * @return
 */
public static ResultadosEvaluacionManoPoker jugadasDeManoCompleta(ArrayList<CartaPoker> mano)
/**
 * Comprueba si existe escalera real
 * Comprueba si existe escalera de color
 * Después si INICIO == DIEZ && FIN == AS
 * TODO CAMBIAR OBLIGACIÓN 5 
 */
{
	ResultadosEvaluacionManoPoker res = new ResultadosEvaluacionManoPoker();
	
	ArrayList<CartaPoker> cp = SoportePoker.ordenCiclico(mano);
	boolean color = esColor(cp);
	boolean escalera = esEscaleraCiclica(cp);
	JugadasPokerEnum jugada = JugadasPokerEnum.NULA;
	
	if(color && escalera){
		// ESCALERA REAL
		if(diezAs(cp))jugada = JugadasPokerEnum.ESCALERA_COLOR_REAL;
		// ESCALERA COLOR
		else jugada = JugadasPokerEnum.ESCALERA_COLOR;			
	}else{
		// ESCALERA
		if(escalera)jugada = JugadasPokerEnum.ESCALERA;
		// COLOR
		if(color) jugada = JugadasPokerEnum.COLOR ;
	}
	
	if(jugada != JugadasPokerEnum.NULA){
		res.sumarCoincidencia(cp,false);
		res.definirJugada(jugada);
	}else res.sumarResto(cp,false);
	
	return res;	
}

/**
 * Busca segun la jugada indicada PAREJA,DOBLES,TRIO,POKER
 * @param mano
 * @param jugada
 * @return
 */
final static ResultadosEvaluacionManoPoker buscarJugadaCombinada(ArrayList<CartaPoker> mano, JugadasPokerEnum jugada){

	refrescarVariables(jugada, mano.size());
	ResultadosEvaluacionManoPoker resultados = new ResultadosEvaluacionManoPoker();
	ArrayList<CartaPoker> cp = SoportePoker.copiar(mano);
	if(maxOffset()<0) return resultados;
			
	for(int offset = 0 ; offset <= maxOffset() ; offset++)
	{
		int aBuscar = cp.get(offset).numero();
		int iguales = 0;
		for(int n = offset+1 ; n < cp.size() ; n++) {if(cp.get(n).numero() == aBuscar) iguales++;}
		
		if(iguales == coincidenciasNecesarias()){
			for(CartaPoker c : cp){
				if(c.numero() == aBuscar) resultados.sumarCoincidencia(c,true);
				else resultados.sumarResto(c);
			}
			return resultados;		
		}
		
	}
	
		
			
	return resultados;
}
/**
 * Busca Trio o Full
 * @param mano
 * @return
 */
public static ResultadosEvaluacionManoPoker buscarFull(ArrayList<CartaPoker> mano){

	ArrayList<CartaPoker> cp = SoportePoker.copiar(mano);

	// busca Full
	ResultadosEvaluacionManoPoker rTrio = buscarJugadaCombinada(cp, JugadasPokerEnum.TRIO);
	
	if(rTrio.jugada().valor() == JugadasPokerEnum.TRIO.valor()) {
		// busca pareja en el resto
		ResultadosEvaluacionManoPoker rPareja = buscarJugadaCombinada(rTrio.resto(), JugadasPokerEnum.PAREJA);
		if(rPareja.jugada().valor() == JugadasPokerEnum.PAREJA.valor()){
			// si FULL ( > COLOR > ESCALERA > TRIO)
			ResultadosEvaluacionManoPoker rFull = new ResultadosEvaluacionManoPoker();
			rFull.sumarCoincidencia(rTrio.coincidencias(),false);
			rFull.sumarCoincidencia(rPareja.coincidencias(),false);
			rFull.definirJugada(JugadasPokerEnum.FULL);
			return rFull;
		}else return rTrio;
	}else return rTrio;
}


/**
 * Busca dobles o pareja
 * @param mano
 * @return
 */
public static ResultadosEvaluacionManoPoker buscarDobles(ArrayList<CartaPoker> mano){

	ArrayList<CartaPoker> cp = SoportePoker.copiar(mano);

	// Busca Dobles Parejas
	ResultadosEvaluacionManoPoker rPareja = buscarJugadaCombinada(cp, JugadasPokerEnum.PAREJA);

	if(rPareja.jugada().valor() == JugadasPokerEnum.PAREJA.valor()) {
		ResultadosEvaluacionManoPoker rPareja2 = buscarJugadaCombinada(rPareja.resto(), JugadasPokerEnum.PAREJA);
		if(rPareja2.jugada().valor() == JugadasPokerEnum.PAREJA.valor()){
			// DOBLES
			ResultadosEvaluacionManoPoker rDoble = new ResultadosEvaluacionManoPoker();
			rDoble.sumarCoincidencia(rPareja.coincidencias(),false);
			rDoble.sumarCoincidencia(rPareja2.coincidencias(),false);
			rDoble.sumarResto(rPareja2.resto,false);
			rDoble.definirJugada(JugadasPokerEnum.DOBLE_PAREJA);
			return rDoble;
		}
							
	}
	// PAREJA
	return rPareja;
}

public static ResultadosEvaluacionManoPoker buscarJugada(ArrayList<CartaPoker> mano){
	
	// resultados mano completa
//	ArrayList<CartaPoker> mano = copiar(manoEntrante);
	ResultadosEvaluacionManoPoker rManoCompleta = new ResultadosEvaluacionManoPoker();
	rManoCompleta = jugadasDeManoCompleta(mano);
//	System.out.println(rManoCompleta.jugada().cadena());
	// mas que POKER,ESCALERA REAL O ESCALERA DE COLOR
	int p = rManoCompleta.jugada().compareTo(JugadasPokerEnum.POKER);
	
	if(rManoCompleta.jugada().compareTo(JugadasPokerEnum.POKER) > 0)return rManoCompleta;
//	System.out.println(rManoCompleta.jugada().cadena());
	// busca POKER
	ResultadosEvaluacionManoPoker rPoker = buscarJugadaCombinada(mano, JugadasPokerEnum.POKER);
//	System.out.println(rManoCompleta.jugada().cadena());
//	System.out.println(rPoker.jugada().cadena());
	// si POKER ( > FULL > COLOR > ESCALERA)
	p = rPoker.jugada().compareTo(JugadasPokerEnum.POKER);
	
	if(rPoker.jugada().equals(JugadasPokerEnum.POKER)){return rPoker;}
	
	// busca Full
	ResultadosEvaluacionManoPoker rFull = buscarFull(mano);
	if(rFull.jugada().equals(JugadasPokerEnum.FULL)) return rFull;

	// color o escalera
//	System.out.println(rManoCompleta.jugada().compareTo(JugadasPokerEnum.TRIO));
	if(rManoCompleta.jugada().compareTo(JugadasPokerEnum.TRIO) > 0) return rManoCompleta;
	
	// trio
	if(rFull.jugada().equals(JugadasPokerEnum.TRIO)) {
		rFull.definirJugada(JugadasPokerEnum.TRIO);
		return rFull;
	}
	
	ResultadosEvaluacionManoPoker rDobles = buscarDobles(mano);
	
	if(rDobles.jugada().compareTo(JugadasPokerEnum.CARTA_MAS_ALTA) > 0) return rDobles;
	else return cartaMasAlta(mano);

}

public static ResultadosEvaluacionManoPoker cartaMasAlta(ArrayList<CartaPoker> mano){
	
	ArrayList<CartaPoker> cp = SoportePoker.ordenCiclico(mano);
	ResultadosEvaluacionManoPoker res = new ResultadosEvaluacionManoPoker();

	CartaPoker alta = Collections.max(cp,new ComparadorAs());	
	cp.remove(alta);
	res.sumarCoincidencia(alta,false);
	
	for(CartaPoker c : cp) res.sumarResto(c);
	res.definirJugada(JugadasPokerEnum.CARTA_MAS_ALTA);
	return res;
	
}


public static ResultadosEvaluacionManoPoker mejorDeDos(ResultadosEvaluacionManoPoker r1, ResultadosEvaluacionManoPoker r2){
	return r1.compararCon(r2) > 0 ? r1 : r2;
}


public ResultadosEvaluacionManoPoker mejorManoEnListaDeManos(ArrayList<ArrayList<CartaPoker>> manosPosibles){
	
	ResultadosEvaluacionManoPoker resultado = new ResultadosEvaluacionManoPoker();
	for(ArrayList<CartaPoker> mano : manosPosibles) resultado = mejorDeDos(resultado, buscarJugada(mano));
	return resultado;
}

public static ResultadosEvaluacionManoPoker mejorMano(ArrayList<CartaPoker> cartasMesa){
	
	ResultadosEvaluacionManoPoker resultado = new ResultadosEvaluacionManoPoker();	
	if(cartasMesa.size() == CARTAS_EN_MANO){return buscarJugada(cartasMesa);}
	if(cartasMesa.size() > CARTAS_EN_MANO){
		
		ArrayList<CartaPoker> manoPosible = new ArrayList<>();
		FuncionesCombinatoria combinatoria = new FuncionesCombinatoria();
		ArrayList<Combinacion> combinacionesCartas = combinatoria.combinacionesNoRepetidas(cartasMesa.size(), CARTAS_EN_MANO, null);
		
		
		for(Combinacion combinacion : combinacionesCartas){
			manoPosible.clear();
			for(Integer i : combinacion.valores()) manoPosible.add(cartasMesa.get(i.intValue()));
			resultado = mejorDeDos(resultado, buscarJugada(manoPosible));
		}
			
	}
	
	
	
	return resultado;
	

}



}
