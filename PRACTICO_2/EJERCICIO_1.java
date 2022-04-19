package PRACTICO_2;

public class EJERCICIO_1 {
	
	public static void fillArray (int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}
	
	public static void printArray (int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length-1) {
				System.out.print(arr[i]);
			}
			else {
				System.out.print(arr[i] + " - ");	
			}
		}
	}

	public static Boolean isOrdered (int[] arr, int pos) {
		
		if (pos < arr.length-1 && pos >= 0) {
			if (arr[pos] < arr[pos+1]) {
				isOrdered(arr, pos-1);
			}	
		}
		if (pos+1 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
