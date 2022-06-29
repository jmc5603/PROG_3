package PRIMER_ENTREGA;

import java.util.Iterator;

public class Biblioteca {

	IndiceGeneros IndiceGeneros;
		
	public Biblioteca () {
		this.IndiceGeneros = new IndiceGeneros();
	}
	
	public void addLibro (Libro lib) {
		this.IndiceGeneros.addLibro(lib);
	}
	
	public Iterator<Libro> getLibrosPorGeneros (String genero) {
		Iterator<Libro> Libros = this.IndiceGeneros.getLibrosPorGenero(genero);
		return Libros;
	}	
	
	public String prueba () {
		return this.IndiceGeneros.prueba();
	}
	
}
