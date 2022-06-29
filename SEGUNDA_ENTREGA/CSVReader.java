package SEGUNDA_ENTREGA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	private String csvFile;
	private String line;
	private String cvsSplitBy;
	
	public CSVReader (String path) {
		this.csvFile = path;
		this.line = "";
		this.cvsSplitBy = ",";
	}
	
	
	
	public grafoBusquedas crearGrafo() {
		grafoBusquedas nuevoGrafo = new grafoBusquedas();		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);

                for (int i = 0; i < items.length; i++) {
                	nuevoGrafo.addGenero(items[i]);
                	if (i+1 < items.length) {
                		nuevoGrafo.addArco(items[i], items[i+1]);
                	}
                }

            }
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		return nuevoGrafo;
	}
 
}


