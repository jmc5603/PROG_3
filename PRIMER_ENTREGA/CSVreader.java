package PRIMER_ENTREGA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
	
public class CSVreader {
	
	private String csvFile;
	private String line;
	private String csvSplitBy;
	
	//C:\\Users\\aihac\\eclipse-workspace\\TPE_PROG3\\src\\TPE_PROG3\\dataset4.csv
	public CSVreader(String path) {
		this.csvFile = path;
		this.line = "";
		this.csvSplitBy = ",";
	}

	public Biblioteca crearBiblioteca () {
		Biblioteca biblioteca = new Biblioteca();
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
            while ((line = br.readLine()) != null) {
            	String[] items = line.split(csvSplitBy);
            	String[] arrayGeneros = items[3].split(" ");
            	ArrayList<String> listaGeneros = new ArrayList<>();
            	
            	for (int i = 0; i < arrayGeneros.length; i++) {
            		listaGeneros.add(arrayGeneros[i]);
            	}
            	
            	Libro newLibro = new Libro(items[0], items[1], items[2], listaGeneros);
            	biblioteca.addLibro(newLibro);
            }   
            
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		return biblioteca;
	}
	   
	
	
}
