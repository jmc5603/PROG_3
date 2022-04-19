package PRACTICO_1;

public class Pila {
	
	private ListaVinculada lista;

	public Pila() {
		this.lista = new ListaVinculada();
	}
	public Pila(ListaVinculada lista) {
		this.lista = lista;
	}
	
	public ListaVinculada getLista () {
		return this.lista;
	}
	public void setLista (ListaVinculada lista) {
		this.lista = lista;
	}
	
	public void push (int info) {
		lista.addfirst(info);
	}
	
	public Pila combine (Pila other) {
		Pila pilaCombinada = new Pila(this.getLista().combine(other.getLista()));
		return pilaCombinada;
	}

	public int pop () {
		Nodo anteUltimoNodo = lista.getPrimerNodo().getAnterior();
		int infoUltimo = lista.getUltimoNodo().getInfo();
		anteUltimoNodo.setSiguiente(null);
		lista.size--;
		return infoUltimo;
	}
	
	public int top () {
		return lista.getUltimoNodo().getInfo();
	}
	
	public void reverse () {
		ListaVinculada tmp = new ListaVinculada();
		while (!lista.estaVacio()) {
			tmp.addfirst(lista.extractFirst());
		}
		lista = tmp; 
	}
	
	public String toString() {
		return lista.toString();
	}
	
	
}
