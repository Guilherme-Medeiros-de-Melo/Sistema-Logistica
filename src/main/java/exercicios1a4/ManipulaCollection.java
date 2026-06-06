package exercicios1a4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManipulaCollection {
	public static List<Integer> filtrarOrdenar(List<Integer> numeros) {
	    List<Integer> resultado = new ArrayList<>();
	    processarRecursivo(numeros, 0, resultado);
	    Collections.sort(resultado);
	    return resultado;
	}
	
	private static void processarRecursivo(List<Integer> numeros,
	                                       int indice,
	                                       List<Integer> resultado) {
	
	    if (indice >= numeros.size()) {
	        return;
	    }
	
	    Integer numero = numeros.get(indice);
	
	    if (numero > 5 && !resultado.contains(numero)) {
	        resultado.add(numero);
	    }
	
	    processarRecursivo(numeros, indice + 1, resultado);
	}
}
