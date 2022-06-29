package PRIMER_ENTREGA;

import java.util.ArrayList;
import java.util.Iterator;

public class Libro {

	private String titulo;
	private String autor;
	private String paginas;
	private ArrayList<String> generos;
	
	private Libro libMayor;
	private Libro libMenor;
	
	public Libro (String ti, String au, String pa, ArrayList<String> ge) {
		this.autor = au;
		this.titulo = ti;
		this.paginas = pa;
		this.generos = ge;
		this.libMayor = null;
		this.libMenor = null;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getPaginas() {
		return paginas;
	}
	
	public Libro getLibMayor() {
		return libMayor;
	}

	public void setLibMayor(Libro libMayor) {
		this.libMayor = libMayor;
	}

	public Libro getLibMenor() {
		return libMenor;
	}

	public void setLibMenor(Libro libMenor) {
		this.libMenor = libMenor;
	}

	public Iterator<String> getIteratorGeneros() {
		Iterator<String> iterador = this.generos.iterator();
		return iterador;
	}
	
	public String toString () {
		return titulo + "," + autor + "," + paginas + "," + generos;
	}
	
}
