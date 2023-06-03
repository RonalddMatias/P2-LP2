package DocuMin;

import entities.*;

import javax.print.Doc;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControllerDocumento {
	
	private HashMap<String, Documento> documentos;
	private ControllerVisao visaoController;

	public ControllerDocumento() {
		this.documentos = new HashMap<>();@Test
    @DisplayName("Quando quero remover Documento com sucesso")
    public void testandoRemoverDocumento(){
        controllerDocumento.criarDocumento("P2");
        controllerDocumento.removerDocumento("P2");
        assertEquals(0, controllerDocumento.quantidadeDeDocumetos());
    }
	}

	public int quantidadeDeDocumetos(){
		return documentos.size();
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
		Documento documento = pegarDocumentoEspecifico(titulo);
		String[] retorno = new String[documento.quantidadeElementos()];
		for (int i = 0; i < retorno.length; i++){
			retorno[i] = documento.getElemento(i).gerarRepresentacaoCompleta();
		}
		return retorno;
	}

	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento texto = new Texto(prioridade, valor);
		return documento.adicionaElementos(texto);
	}

	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento titulo = new Titulo(prioridade,valor,nivel, linkavel);
		return documento.adicionaElementos(titulo);
	}

	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento lista = new Lista(prioridade,tituloDoc, valorLista, separador, charLista);
		return documento.adicionaElementos(lista);
	}

	public int criarTermo(String tituloDoc, String valorTermo, int prioridade, String separador, String ordem){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Elemento termo = new Termos(prioridade, valorTermo,separador,ordem);
		return documento.adicionaElementos(termo);
	}

	private Documento pegarDocumentoEspecifico(String titulo){
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

	public String pegaRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao).gerarRepresentacaoCompleta();
	}

	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.getElemento(elementoPosicao).gerarRepresentacaoResumida();
	}

	public boolean apagarElemento(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		return documento.removerElemento(elementoPosicao);
	}
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		documento.moverParaCima(elementoPosicao);
	}

	public void moverParaBaixo(String tituloDoc, int elementoPosicao){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		documento.moverParaBaixo(elementoPosicao);

	}
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if(verificaAtalhoExistente(tituloDoc) || verificaAtalhoExistente(tituloDocReferenciado)){
			throw new IllegalArgumentException("Documento ja possui um atalho");
		}
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		Documento documentoReferenciado = pegarDocumentoEspecifico(tituloDocReferenciado);
		Atalho atalho = new Atalho(documentoReferenciado.calculaMediaElementos(), tituloDocReferenciado, documentoReferenciado.getElementos());
		documentoReferenciado.adicionaElementos(atalho);
		documento.setTemAtalho(true);
		documentoReferenciado.setTemAtalho(true);

		return documentoReferenciado.getElementos().indexOf(atalho); // retornar o indexof
	}

	public int criarVisaoCompleta(String tituloDoc){
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoCompleta = visaoController.criarVisaoCompleta(documento);
		visaoController.adicionaVisao(visaoCompleta);
		return visaoController.getVisoes().indexOf(visaoCompleta);
	}
	private boolean verificaAtalhoExistente(String titulo){
		Documento documento = pegarDocumentoEspecifico(titulo);
		if (documento.isTemAtalho()){
			return true;
		}
		return false;
	}

	public int criarVisaoResumida(String tituloDoc) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoCompleta = visaoController.criarVisaoResumida(documento);
		visaoController.adicionaVisao(visaoCompleta);
		return visaoController.getVisoes().indexOf(visaoCompleta);
	}

	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoPrioritaria = visaoController.criarVisaoPrioritaria(documento, prioridade);
		visaoController.adicionaVisao(visaoPrioritaria);
		return visaoController.getVisoes().indexOf(visaoPrioritaria);
	}

	public int criarVisaoTitulo(String tituloDoc) {
		Documento documento = pegarDocumentoEspecifico(tituloDoc);
		String[] visaoTitulo = visaoController.criarVisaoTitulo(documento);
		visaoController.adicionaVisao(visaoTitulo);
		return visaoController.getVisoes().indexOf(visaoTitulo);
	}

	public String[] exibirVisao(int visaoId) {
		return visaoController.pegandoVisaoPeloId(visaoId);
	}


}