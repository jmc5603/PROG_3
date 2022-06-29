package SEGUNDA_ENTREGA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class grafoBusquedas {
	
	private HashMap<String, HashMap<String, Integer>> verticesGeneros;
	private HashMap<String, String> marcasRecorrido;
	
	public grafoBusquedas () {
		this.verticesGeneros = new HashMap<>();
		this.marcasRecorrido = new HashMap<>();
	}
	
	public Boolean isEmpty () {
		return this.verticesGeneros.isEmpty();
	}
	
	public Iterator<String> getGeneros () {
		if(this.isEmpty()) {
			System.out.println("no hay generos");
			ArrayList<String> tmp = new ArrayList<>();
			return tmp.iterator();
		}
		else {
			return this.verticesGeneros.keySet().iterator();
		}
	}
	
	public Iterator<String> getMarcas () {
		return this.marcasRecorrido.keySet().iterator();
	}
	
	public Iterator<String> getArcosGenero (String genero) {
		if (this.verticesGeneros.containsKey(genero)) {
			return this.verticesGeneros.get(genero).keySet().iterator();	
		}
		else {
			System.out.println("El genero no existe");
			ArrayList<String> tmp = new ArrayList<>();
			return tmp.iterator();
		}
	}
	
	public int cantBusquedasEntreGen (String origen, String destino) {
		if (this.verticesGeneros.get(origen).containsKey(destino)) {
			return this.verticesGeneros.get(origen).get(destino);		
		}
		else {
			System.out.println("El genero origen no tiene un arco con el genero destino");
			return -1;
		}
	}
	
	public void addGenero (String genero) {
		if (!this.verticesGeneros.containsKey(genero)) {
			HashMap<String, Integer> arcosGen = new HashMap<>();
			this.verticesGeneros.put(genero, arcosGen);
			if (!this.marcasRecorrido.containsKey(genero)) {
				this.marcasRecorrido.put(genero, "NO_RECORRIDO");
			}
		}
	}
	
	public void addArco (String origen, String destino) {
		if (!this.verticesGeneros.get(origen).containsKey(destino)) {
			this.verticesGeneros.get(origen).put(destino, 1);
		}
		else {
			int cantBusquedas = this.verticesGeneros.get(origen).get(destino);
			this.verticesGeneros.get(origen).remove(destino);
			this.verticesGeneros.get(origen).put(destino, cantBusquedas+1);
			}
	}
	
	public Iterator<String> generosMasBuscados (String genero, int cantGeneros) {
		ArrayList<String[]> listaArcos = new ArrayList<>();
		Iterator<String> iteradorArcos = this.getArcosGenero(genero);
		
		if (iteradorArcos.hasNext()) {
			while(iteradorArcos.hasNext()) {
				String generoDestino = iteradorArcos.next();
				String[] arco = new String[2];
				arco[0] = generoDestino;
				arco[1] = this.verticesGeneros.get(genero).get(generoDestino)+"";
				listaArcos.add(arco);
			}
			ArrayList<String[]> arcosOrdenados = this.ordenarArcos(listaArcos);
			ArrayList<String> generosMasBuscados = new ArrayList<>();
			for(int i = 0; i < cantGeneros; i++) {
				generosMasBuscados.add(arcosOrdenados.get(i)[0]);
			}
			return generosMasBuscados.iterator();		
		}
		else {
			System.out.println("El genero no existe o no tiene arcos con otros generos...");
			ArrayList<String> generosMasBuscados = new ArrayList<>();
			return generosMasBuscados.iterator();		
		}
		
	}
	
	public ArrayList<String[]> ordenarArcos(ArrayList<String[]> lista) {
		if (lista.size() < 1) {
			return new ArrayList<>();
		}
		ArrayList<String[]> listaOrdenada = new ArrayList<>();
		ArrayList<String[]> menores = new ArrayList<>();
		ArrayList<String[]> mayores = new ArrayList<>();
		String[] pivot = lista.get(0);
		
		for (int i = 1; i < lista.size(); i++) {
			if (Integer.parseInt(lista.get(i)[1]) < Integer.parseInt(pivot[1])) {
				menores.add(lista.get(i));
			}
			else {
				mayores.add(lista.get(i));
			}
		}
		
		listaOrdenada.addAll(ordenarArcos(mayores));
		listaOrdenada.add(pivot);
		listaOrdenada.addAll(ordenarArcos(menores));
		return listaOrdenada;
	}

	public void resetearMarcas () {
		Iterator<String> marcas = this.getMarcas();
		while (marcas.hasNext()) {
			this.marcasRecorrido.replace(marcas.next(), "NO_RECORRIDO");
		}
	}
	
	public ArrayList<String> secuenciaMasBuscada (String genero) {
		this.resetearMarcas();
		return this.SMB2(genero);
	}
	
	//DESHABILITADO POR STACKOVERFLOW
	public ArrayList<String> SMB (String genero) {
		ArrayList<String> secuencia = new ArrayList<>();
		if(this.verticesGeneros.containsKey(genero) && this.marcasRecorrido.get(genero) != "RECORRIDO") {
			Iterator<String> arcosGenero = this.getArcosGenero(genero);
			String tmpGenero = "";
			int tmpArco = 0;
			
			while (arcosGenero.hasNext()) {
				String genActual = arcosGenero.next();
				int cantBusquedaActual = this.verticesGeneros.get(genero).get(genActual);
				if (cantBusquedaActual > tmpArco) {
					tmpGenero = genActual;
					tmpArco = cantBusquedaActual;
				}
			}
			this.marcasRecorrido.replace(genero, "RECORRIDO");
			secuencia.add(genero);
			secuencia.addAll(secuenciaMasBuscada(tmpGenero));
			return secuencia;
		}
		else {
			return secuencia;
		}
	}
	
	public ArrayList<String> SMB2 (String genero) {
		ArrayList<String> secuencia = new ArrayList<>();
		if (this.verticesGeneros.containsKey(genero)) {
			String generoActual = genero;
			secuencia.add(genero);
			Iterator<String> arcosGenero = this.getArcosGenero(genero);
			
			while (arcosGenero.hasNext()) {
				Iterator<String> iteradorMasBuscado = this.generosMasBuscados(generoActual, 1);
				String generoMasBuscado = iteradorMasBuscado.next();
				if (this.marcasRecorrido.get(generoMasBuscado) != "RECORRIDO") {
					secuencia.add(generoMasBuscado);
					generoActual = generoMasBuscado;
					this.marcasRecorrido.replace(generoMasBuscado, "RECORRIDO");
					arcosGenero = this.getArcosGenero(generoMasBuscado);
				}
				else {
					break;
				}	
			}
		}		
		return secuencia;
	}
	
}
