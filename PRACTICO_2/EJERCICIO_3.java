package PRACTICO_2;

public class EJERCICIO_3 {
	

	public static void convertToDecimal(int number) {
		if (number != 1) {
			convertToDecimal(number/2);
			System.out.print(number%2);
		}
		else {
			System.out.print(1);
		}
	}
	
	
}
