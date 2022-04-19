package PRACTICO_1;

import java.util.Iterator;

public class Iterador implements Iterator<Integer> {
	
	private Nodo cursor;
	
	public Iterador (Nodo nodo) {
		this.cursor = nodo;
	}

	public boolean hasNext() {
		return this.cursor != null;
	}

	public Integer next() {
		int info = cursor.getInfo();
		cursor = cursor.getSiguiente();
		return info;
	}
	
	public Integer get() {
		return this.cursor.getInfo();
	}





}
