package SEGUNDA_ENTREGA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		CSVReader reader = new CSVReader("C:\\Users\\aihac\\eclipse-workspace\\TPE_PROG3\\src\\SEGUNDA_ENTREGA\\dataset4.csv");
		grafoBusquedas grafo = reader.crearGrafo();

		//PARA OBTENER LOS GENEROS MAS BUSCADOS QUE LE SIGUEN A UN GENERO ESPECIFICO:
		Iterator<String> arcosMasBuscados = grafo.generosMasBuscados("negocios", 3);
		while (arcosMasBuscados.hasNext()) {
			String destino = arcosMasBuscados.next();
			System.out.println(destino + " - " + grafo.cantBusquedasEntreGen("negocios", destino) + " busquedas");
		}
		
		//PARA OBTENER LA SECUENCIA MAS BUSCADA A PARTIR DE UN GENERO.
		ArrayList<String> secuenciaMasBuscada = grafo.secuenciaMasBuscada("negocios");
		System.out.println(secuenciaMasBuscada);

		
		
		
	}

}
