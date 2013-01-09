package pruebas;


import juegoCartasPoker.evaluador.EvaluadorManosPoker;
import juegoCartasPoker.evaluador.ResultadosEvaluacionManoPoker;
import juegoCartasPoker.objetos.BarajaPoker;
import juegoCartasPoker.soporte.SoportePoker;
import juegocartas.ManosFalsas;


public class Start extends SoportePoker {

	
	public static void imprimir(String texto){
		System.out.println(texto);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		BarajaPoker barajaPoker = new BarajaPoker();
		barajaPoker.barajar();
//		CartaPoker carta1 = new CartaPoker();
//		for(int c = 1; c <13 ; c++) carta1 = new CartaPoker((CartaPoker) barajaPoker.sacarCartaInferior());
////		System.out.println(carta1.cadena());
//		FuncionesCombinatoria combinatoria = new FuncionesCombinatoria();
//		combinatoria.pruebaCombinaciones(9, 5);
		
		ResultadosEvaluacionManoPoker r3 = EvaluadorManosPoker.mejorMano(ManosFalsas.CartasEnMesaEscalera());
		r3.imprimirInformeCompleto();
//		combinatoria.pruebaCombinaciones(8, 5);

		
		
		
	}
	

}
