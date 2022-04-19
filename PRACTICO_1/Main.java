package PRACTICO_1;

public class Main {

	public static void main(String[] args) {

		
		Pila pila1 = new Pila();
		
		pila1.push(1);
		pila1.push(2);
		pila1.push(3);
		pila1.push(4);
		pila1.push(5);
		
		//System.out.println(pila.estaVacio());
		//System.out.println(pila.getPrimerNodo().getInfo());
		//System.out.println(pila.top());
		//System.out.println(pila.indexOf(4));
		//System.out.println(pila.obtenerTamanio());
		//System.out.println(pila.obtenerNodo(4));
		//pila.reverse();
		//System.out.println(pila.toString());
	
		Pila pila2 = new Pila();
		
		pila2.push(1);
		pila2.push(9);
		pila2.push(7);
		pila2.push(3);
		pila2.push(4);
		pila2.push(9);
		pila2.push(6);
		pila2.push(4);
		
		Pila pila3 = pila1.combine(pila2);
		System.out.println(pila3.toString());
		
		
		}
}
