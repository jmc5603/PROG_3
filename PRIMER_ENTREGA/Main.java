package PRIMER_ENTREGA;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		CSVreader reader = new CSVreader("C:\\Users\\aihac\\eclipse-workspace\\TPE_PROG3\\src\\PRIMER_ENTREGA\\dataset1.csv");
		Biblioteca biblioteca = reader.crearBiblioteca();
		
		Iterator<Libro> getLibrosPorGenero = biblioteca.getLibrosPorGeneros("cine");
		
		while (getLibrosPorGenero.hasNext()) {
			System.out.println(getLibrosPorGenero.next().toString());
		}

	}

}
