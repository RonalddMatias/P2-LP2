package DocuMin;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControllerDocumento {
	
	private HashMap<String, Documento> documentos;

	public ControllerDocumento(HashMap<String, Documento> documentos) {
		this.documentos = new HashMap<>();
	}
	
	public boolean criarDocumento(String titulo){
		if(documentos.containsKey(titulo)) {
			return false;
		}
		
		if(verificaTitulo(titulo)) {
			return false;
		}
		
		documentos.put(titulo, new Documento(titulo));
		return true;
	}
	
	

	public boolean criarDocumento(String titulo, int qtdMaxima) {
		if(documentos.containsKey(titulo)) {
			return false;
		}
		
		if(qtdMaxima <= 0) {
			throw new IllegalArgumentException();
		}
		
		if(verificaTitulo(titulo)) {
			return false;
		}

		documentos.put(titulo, new Documento(titulo, qtdMaxima));
		return true;
	}
	
	public void removerDocumento(String titulo) {
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException("Documento não cadastrado!");
		}
		documentos.remove(titulo);
	}
	
	// Irá retorna a quantidade de elementos cadastrados dentro de um sistema.
	public int contarElementos(String titulo) {
		return 0;
	}
	
	// Irá retorna uma representação dos elementos que podem ter em um determinado documento.
	public String[] exibirDocumento(String titulo) {
		return null;
	}
	
	private boolean verificaTitulo(String titulo) {
		if(titulo.isEmpty() || titulo.isBlank()) {
			return true;
		}
		return false;
	}

}
