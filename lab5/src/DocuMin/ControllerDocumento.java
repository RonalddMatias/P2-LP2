package DocuMin;

import entities.Elemento;
import entities.Texto;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControllerDocumento {
	
	private HashMap<String, Documento> documentos;

	public ControllerDocumento() {
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
	
	// Irá retorna a quantidade de elementos cadastrados dentro de um documento.
	public int contarElementos(String titulo) {
		int cont = 0;
		if(!documentos.containsKey(titulo)){
			throw new NoSuchElementException("Documento não cadastrado");
		}
		Documento documento = documentos.get(titulo);
		for (int i = 0; i < documento.getElementos().size(); i++){
			if (documento.getElementos().get(i) != null){
				cont++;
			}
		}
		return cont;
	}
	
	// Irá retorna uma representação dos elementos que podem ter em um determinado documento.
	public String[] exibirDocumento(String titulo) {
		return null;
	}
	


	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		Documento documento = pegarResumoEspecifico(tituloDoc);
		Elemento elemento = new Texto(prioridade, valor);
		return documento.adicionaElementos(elemento);
	}

	private Documento pegarResumoEspecifico(String titulo){
		Documento documento = documentos.get(titulo);
		if(documento == null) {throw new NoSuchElementException("Elemento não encontrado");}
		return documento;
	}

	private boolean verificaTitulo(String titulo) {
		if(titulo.isEmpty() || titulo.isBlank()) {
			return true;
		}
		return false;
	}

}
