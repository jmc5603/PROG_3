package PRACTICO_2;

public class EJERCICIO_2 {

	public int searchElement (int[] arr, int pos, int element) {
		if (arr[pos] != element) {
			return searchElement(arr, pos+1, element);
		}
		else if (pos >= arr.length) {
			return -1;
		}
		else {
			return pos;
		}
	}
	
	public int searhElementIfOrdered (int[] arr, int pos, int element) {
		if (arr[pos] < element) {
			return searhElementIfOrdered(arr, pos++, element);
		}
		else if (arr[pos] == element) {
			return pos;
		}
		else {
			return -1;
		}
	}
	
}
