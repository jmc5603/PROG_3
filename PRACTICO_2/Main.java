package PRACTICO_2;

public class Main {

	public static void main(String[] args) {
		
		//EJERCICIO_3.convertToDecimal(80);
		
		int[] arr = new int[8];
		arr[0] = 6;
		arr[1] = 3;
		arr[2] = 9;
		arr[3] = 2;
		arr[4] = 8;
		arr[5] = 1;
		arr[6] = 5;
		arr[7] = 7;
		
		//EJERCICIO_4.ordenamientoSeleccion(arr);
		//System.out.println(arr[2]);
		
		//EJERCICIO_4.ordenamientoBurbujeo(arr);
		
		//EJERCICIO_1.printArray(EJERCICIO_5.mergeSort(arr));
		
		//EJERCICIO_5.startQuickSort(arr);
		//EJERCICIO_1.printArray(arr);
		
		Tree nuevoArbol = new Tree(new Root(5));
		nuevoArbol.insert(0);
		nuevoArbol.insert(3);
		nuevoArbol.insert(7);
		nuevoArbol.insert(1);
		nuevoArbol.insert(9);
		
		//System.out.println(nuevoArbol.hasElement(9));
				
	}

}
