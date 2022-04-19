package PRACTICO_2;

public class EJERCICIO_5 {
	
	/* El metodo de ordenamiento tipo Merge lo que hace es dividir el arreglo lo maximo posible.
	 * luego de dividirlo lo mas que puede, va uniendo los mini arreglos siempre ordenandolos, asi obtener
	 * un arreglo mas grande ordenado. 
	 */

	public static int[] mergeSort (int[] arr) {
		
		// si el arreglo que tenemos no es divisible, lo devolvemos como esta.
		if (arr.length <= 1) {
			return arr;
		}
		// empieza el procedimiento de dividir el arreglo en dos mas chicos.
		else {
			// se instancian las divisiones. el tamanio que tendran dependeran del tamanio de su arreglo padre.
			int[] izq;
			int[] der;
			
			izq = new int[arr.length / 2];
			
			// en el caso de que el tamanio del arreglo padre sea impar, siempre uno de los hijos sera mas grande que el otro.
			if (arr.length % 2 == 0) {
				der = new int[arr.length / 2];
			}
			else {
				der = new int[arr.length / 2 + 1];
			}
			
			// se empiezan a rellenar los mini arreglos con el contenido del arreglo padre.
			int index;
			for (index = 0; index < izq.length; index++) {
				izq[index] = arr[index];
			}
			for (int i = 0; i < der.length; i++) {
				der[i] = arr[index];
				index++;
			}
			
			// entra en recursividad para poder ordenarlo completamente. se divide lo mas que se pueda y se van ordenando.
			// el metodo merge se encarga de unir los dos miniarreglos YA ORDENADOS.
			return merge(mergeSort(izq), mergeSort(der));
		}
	}
	
	public static int[] merge (int[] izq, int[] der) {
		// guardamos las posiciones de los miniarreglos para recorrerlos.
		int indexIzq = 0;
		int indexDer = 0;
		// creamos un arreglo que combinara los dos anteriores. su tamanio es la suma del tamanio de los dos.
		int[] merged = new int[izq.length + der.length];
		
		for (int i = 0; i < merged.length; i++) {
			// si uno es mas chico que el otro, se almacena el chico en el nuevo arreglo.
			if (izq[indexIzq] < der[indexDer]) {
				merged[i] = izq[indexIzq];
				indexIzq++;
			}
			else {
				merged[i] = der[indexDer];
				indexDer++;
			}
			//en el caso de que uno de los dos miniarreglos se haya agotado, se vuelcan directamente los restantes del otro arreglo.
			if (indexIzq == izq.length) {
				i++;
				for (indexDer = indexDer; indexDer < der.length; indexDer++ ) {
					merged[i] = der[indexDer];
					i++;
				}
			}
			// lo mismo si le pasa al otro miniarreglo.
			else if (indexDer == der.length) {
				i++;
				for (indexIzq = indexIzq; indexIzq < izq.length; indexIzq++) {
					merged[i] = izq[indexIzq];
					i++;
				}
			}
		}
		// devolvemos el arreglo ya combinado y ordenado.
		return merged;
	}
	
	
	public static void startQuickSort (int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int extremo1, int extremo2) {
		
		int inicio = extremo1;
		int fin = extremo2;
		int pivote = arr[inicio];
		int aux;
		
		while (inicio < fin) {
			while (arr[inicio] <= pivote && inicio < fin) {
				inicio++;
			}
			while (arr[fin] > pivote) {
				fin--;
			}
			if (inicio < fin) {
				aux = arr[inicio];
				arr[inicio] = arr[fin];
				arr[fin] = aux;
			}
		}
		
		arr[extremo1] = arr[fin];
		arr[fin] = pivote;
		
		if (extremo1 < fin-1) {
			quickSort(arr, extremo1, fin-1);
		}
		if (fin+1 < extremo2) {
			quickSort(arr, fin+1, extremo2);
		}
	}
}
