package PRIMER_ENTREGA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CSVwritter {
	
	private Biblioteca biblioteca;
	private String genero;
	
	public CSVwritter (Biblioteca bib, String genero) {
		this.biblioteca = bib;
		this.genero = genero;
	}

	public void imprimirResultados () {
		BufferedWriter bw = null;
		try {
			File file = new File("C:\\Users\\aihac\\eclipse-workspace\\TPE_PROG3\\src\\TPE_PROG3\\salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			Iterator<Libro> iteradorLibros = this.biblioteca.getLibrosPorGeneros(this.genero);
			
			while (iteradorLibros.hasNext()) {
				Libro lib = iteradorLibros.next();
				String contenidoLinea = lib.toString();
				bw.write(contenidoLinea);
				bw.newLine();
			}
			
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		finally {
			try {
				if (bw != null)
					bw.close();
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
	}

}

