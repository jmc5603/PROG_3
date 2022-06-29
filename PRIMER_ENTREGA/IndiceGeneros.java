package PRIMER_ENTREGA;

import java.util.ArrayList;
import java.util.Iterator;

public class IndiceGeneros {
	
	private Genero generoRaiz;
	
	public IndiceGeneros () {
		this.generoRaiz = null;
	}
	
	public String prueba () {
		return this.generoRaiz.getGenero();
	}
	
	public void addGenero (Genero genero) {
		if (this.generoRaiz == null) {
			this.generoRaiz = genero;
		}
		else {
			addGenero(this.generoRaiz, genero);
		}
	}
	public void addGenero (Genero posActual, Genero genero) {
		Genero actual = posActual;
		
		if (actual.getGenero() != genero.getGenero()) {
			if (genero.getGenero().compareTo(actual.getGenero()) == 1) {
				if (actual.getGenMayor() != null) {
					addGenero(actual.getGenMayor(), genero);		
				}
				else {
					actual.setGenMayor(genero);
				}
			}
			if (genero.getGenero().compareTo(actual.getGenero()) == -1) {
				if (actual.getGenMenor() != null) {
					addGenero(actual.getGenMenor(), genero);		
				}
				else {
					actual.setGenMenor(genero);
				}
			}
		}
	}
	
	public void addLibro (Libro lib) {
		Iterator<String> generos = lib.getIteratorGeneros();
		
		while (generos.hasNext()) {
			String actual = generos.next();
			if (this.exist(actual)) {
				//
				Genero generoExistente = this.getGenero(actual);
				generoExistente.addLibro(lib);
				//
			}
			else {
				Genero newGenero = new Genero(actual);
				newGenero.addLibro(lib);
				this.addGenero(newGenero);
			}
		}
	}
	
	public Boolean exist (String genero) {
		return this.exist(generoRaiz, genero);
	}
	public Boolean exist (Genero posActual, String genero) {
		if (posActual != null) {
			if (posActual.getGenero() != genero) {
				if (genero.compareTo(posActual.getGenero()) == 1) {
					return exist(posActual.getGenMayor(), genero);
				}
				if (genero.compareTo(posActual.getGenero()) == -1) {
					return exist(posActual.getGenMenor(), genero);
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}		
		}
		else {
			return false;
		}
	}
	
	public Genero getGenero (String genero) {
		return this.getGenero(generoRaiz, genero);
	}
	public Genero getGenero (Genero posActual, String genero) {
		if (posActual != null) {
			if (posActual.getGenero() != genero) {
				if (genero.compareTo(posActual.getGenero()) == 1) {
					return getGenero(posActual.getGenMayor(), genero);
				}
				if (genero.compareTo(posActual.getGenero()) == -1) {
					return getGenero(posActual.getGenMenor(), genero);
				}
				else {
					return posActual;
				}
			}
			else {
				return posActual;
			}	
		}
		else {
			return null;
		}
	}
	
	public Iterator<Libro> getLibrosPorGenero (String genero) {
		if (this.getGenero(genero) != null) {
			return this.getGenero(genero).getLibros().iterator();			
		}
		else {
			ArrayList<Libro> tmp = new ArrayList<>();
			return tmp.iterator();
		}
	}

}
