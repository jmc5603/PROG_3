package PRACTICO_1;

public class Nodo {
	
	/* Los nodos representan cada uno de las casillas de una lista. Como están todos dispersos entre sí
	 * (y no continuos en la memoría de nuestro sistema), debemos crear en cada uno una referencia al proximo nodo, y así
	 * relacionarlos como elementos de una misma lista. Por eso se la llama lista vinculada */
	
	/* el contenido de la casilla/nodo */
	private int info;
	
	/* su referencia al proximo y anterior nodo */
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo (int info, Nodo sig, Nodo ant) {
		this.setInfo(info);
		this.setSiguiente(sig);
		this.setAnterior(ant);
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
	
}
