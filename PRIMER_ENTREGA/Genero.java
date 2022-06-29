package PRIMER_ENTREGA;

import java.util.ArrayList;

public class Genero {
	
	private String genero;
	private Genero genMenor;
	private Genero genMayor;
	private Libro libroRaiz;
	
	public Genero (String nombre) {
		this.genero = nombre;
		this.genMenor = null;
		this.genMayor = null;
		this.libroRaiz = null;
	}

	public Genero getGenMenor() {
		return genMenor;
	}

	public void setGenMenor(Genero genMenor) {
		this.genMenor = genMenor;
	}

	public Genero getGenMayor() {
		return genMayor;
	}

	public void setGenMayor(Genero genMayor) {
		this.genMayor = genMayor;
	}

	public String getGenero() {
		return genero;
	}
	
	public void addLibro (Libro lib) {
		if (this.libroRaiz == null) {
			this.libroRaiz = lib;
		}
		else {
			addLibro (this.libroRaiz, lib);
		}
	}
	public void addLibro (Libro posActual, Libro lib) {
		Libro actual = posActual;
		
		if (actual.getTitulo() != lib.getTitulo()) {
			if (genero.compareTo(actual.getTitulo()) == 1) {
				if (actual.getLibMayor() != null) {
					addLibro(actual.getLibMayor(), lib);		
				}
				else {
					actual.setLibMayor(lib);
				}
			}
			if (lib.getTitulo().compareTo(actual.getTitulo()) == -1) {
				if (actual.getLibMenor() != null) {
					addLibro(actual.getLibMenor(), lib);		
				}
				else {
					actual.setLibMenor(lib);
				}
			}
		}
	}
	
	public ArrayList<Libro> getLibros () {
		ArrayList<Libro> libros = new ArrayList<>();
		libros.addAll(getLibros(this.libroRaiz));
		return libros;
	}
	public ArrayList<Libro> getLibros (Libro posActual) {
		ArrayList<Libro> libros = new ArrayList<>();
		libros.add(posActual);
		
		if (posActual.getLibMayor() != null) {
			libros.addAll(getLibros(posActual.getLibMayor()));
		}
		if (posActual.getLibMenor() != null) {
			libros.addAll(getLibros(posActual.getLibMenor()));
		}
		return libros;
	}

}
