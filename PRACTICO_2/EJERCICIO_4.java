package PRACTICO_2;

public class EJERCICIO_4 {

	public static void ordenamientoSeleccion (int[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			int minimo = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minimo]) {
					minimo = j;
				}
			}
			int aux = arr[i];
			arr[i] = arr[minimo];
			arr[minimo] = aux;
		}
	}
	
	public static void ordenamientoBurbujeo (int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int aux = arr[i];
					arr[i] = arr[j];
					arr[j] = aux;
				}
			}
		}
	}
	
}
