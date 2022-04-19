package PRACTICO_1;

import java.util.List;

public class ListaVinculada implements Iterable<Integer> {
	
	/* Nuestra nueva lista vinculada se basa principalmente en su primer nodo. Con las referencias del mismo (en atributos) 
	 * podemos ubicar al resto de ellos. 
	 * La desventaja es que necesitamos recorrerlos a todos para poder encontrar a uno en especifico*/

	protected Nodo primer_nodo;
	
	/* para facilitar algunas operaciones. decidimos crear un "atajo" en forma de atributo de clase para ubicar al ultimo
	 * nodo de la lista */
	protected Nodo ultimo_nodo;
	
	/* Para conocer el tamanio de la lista sin necesidad de recorrer nodo por nodo (lo que tiene una alta complejidad comp.),
	 * declaramos un atributo de clase el cual aumenta por cada nodo nuevo*/
	
	protected int size;
	
	public ListaVinculada() {
		this.primer_nodo = null;
		this.ultimo_nodo = null;
		this.size = 0;
	}
	
	public Nodo getPrimerNodo () {
		return this.primer_nodo;
	}
	public void setPrimerNodo (Nodo nodo) {
		this.primer_nodo = nodo;
	}
	
	public Nodo getUltimoNodo () {
		return this.ultimo_nodo;
	}
	public void setUltimoNodo (Nodo nodo) {
		this.ultimo_nodo = nodo;
	}
	
	public int size () {
		return this.size;
	}
	
	public void addfirst (int info) {
		/* como no se trata de realizar corrimientos, solo hay que establecer al nuevo nodo como el primero en el atributo
		 de la lista, y establecer al anterior "primer nodo" en la referencia del nuevo */
		
		Nodo nodoTemp = new Nodo (info, this.primer_nodo, null);
		
		/* si queremos tener una variable para conocer el ultimo nodo de la lista, que mejor que saberlo desde el principio.
		 * si se agrega un nodo teniendo la lista totalmente vacia, sabremos que ese elemento en algun momento pasara
		 * a ser el ultimo inevitablemente */
		
		if (this.size() == 0) {
			this.setPrimerNodo(nodoTemp);
			this.setUltimoNodo(nodoTemp);
			this.size++;		
		}
		else {
			/* establecemos al elemento entrante como la referencia de nodo anterior al antiguo primer elemento*/
			this.getPrimerNodo().setAnterior(nodoTemp);
			/* cambiamos variable del primer nodo */
			this.setPrimerNodo(nodoTemp);
			/* al agregar un nodo, quiere decir que debemos llevar la cuenta al dia del tamanio de la lista */
			this.size++;		
		}
		
	}
	
	public int extractFirst () {
		/* ahora queremos obtener el contenido del "primer nodo" y luego eliminarlo. solo tenemos que quitar su referencia.
		 * luego el garbage collector se encargará de eliminarlo (porque aquel nodo no se puede acceder de ninguna forma)*/
		
		Nodo nodoTemp = new Nodo (this.primer_nodo.getInfo(), this.primer_nodo.getSiguiente(), this.primer_nodo.getAnterior());
		this.setPrimerNodo(nodoTemp.getSiguiente());
		this.size--;
		return nodoTemp.getInfo();
	}
	
	public Boolean estaVacio () {
		if (this.size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int obtenerNodo (int indice) {
		/* Para encontrar un determinado nodo, debemos recorrer siempre apartir del primero de estos, 
		 * y utilizar sus referencias para encontrar el resto */
		
		Nodo nodoObtenido = this.primer_nodo;
		
		for (int i = 0; i < indice; i++) {
			nodoObtenido = nodoObtenido.getSiguiente();
		}
		
		return nodoObtenido.getInfo();
	}
	
	public String toString () {
		Nodo nodoActual = this.primer_nodo;
		String resultado = "";
		
		for (int i = 0; i < this.size; i++) {
			resultado += nodoActual.getInfo() + " - ";
			nodoActual = nodoActual.getSiguiente();
		}
		return resultado;
	}
	
	public int indexOf (int info) {
		int posActual = 0;
		Nodo nodoActual = this.getPrimerNodo();
		
		while (nodoActual.getInfo() != info && posActual < this.size) {
			posActual++;
			nodoActual = nodoActual.getSiguiente();
		}
		if (posActual >= this.size) {
			return -1;
		}
		
		return posActual;
	}
	
	public ListaVinculada combine (ListaVinculada otherList) {
		ListaVinculada combinedList = new ListaVinculada();
		Iterador primerIterador = this.iterator();
		
		while (primerIterador.hasNext()) {
			int primerNodoActual = primerIterador.next();
			Iterador segundoIterador = otherList.iterator();
			while (segundoIterador.hasNext()) {
				int segundoNodoActual = segundoIterador.next();	
				if (primerNodoActual == segundoNodoActual) {
					combinedList.addfirst(segundoNodoActual);
				}
			}
		}
		return combinedList;
	}
	
	public ListaVinculada combineIfOrdered (ListaVinculada otherList) {
		ListaVinculada combinedList = new ListaVinculada();
		Iterador primerIterador = this.iterator();
		Iterador segundoIterador = this.iterator();
		
		if (primerIterador.get() > segundoIterador.get()) {
			segundoIterador.next();
		}
		else if (primerIterador.get() < segundoIterador.get()) {
			primerIterador.next();
		}
		else {
			combinedList.addfirst(segundoIterador.get());
		}
		
		return combinedList;
		
	}
	
	public ListaVinculada uncombinedList (ListaVinculada otherList) {
		/* el mismo metodo que la combinedList pero en vez de == va un != */
		return null;
	}

	@Override
	public Iterador iterator() {
		return new Iterador (this.getPrimerNodo());
	}

	
}
