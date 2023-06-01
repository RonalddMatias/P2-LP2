package DocuMin;

public class Facade {
    private ControllerDocumento controllerDocumento;

    public Facade(ControllerDocumento controllerDocumento) {
        this.controllerDocumento = new ControllerDocumento();
    }

    public boolean addDocumento(String Titulo){
        return controllerDocumento.criarDocumento(Titulo);
    }

    public boolean addDocumento(String titulo, int qtd){
        return controllerDocumento.criarDocumento(titulo, qtd);
    }

    public void removerElemento(String titulo){
        controllerDocumento.removerDocumento(titulo);
    }

    public int contarElementos(String titulo){
        return controllerDocumento.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo ){
        return controllerDocumento.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return controllerDocumento.criarTexto(tituloDoc,valor,prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        return controllerDocumento.criarTitulo(tituloDoc,valor,prioridade,nivel,linkavel);
    }
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        return controllerDocumento.criarLista(tituloDoc,valorLista,prioridade,separador,charLista);
    }

    public int criarTermo(String tituloDoc, String valorTermo, int prioridade, String separador, String ordem){
        return controllerDocumento.criarTermo(tituloDoc,valorTermo, prioridade,separador,ordem);
    }

    public String PegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return controllerDocumento.pegaRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String PegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return controllerDocumento.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return controllerDocumento.apagarElemento(tituloDoc, elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao){

    }
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado){
        return controllerDocumento.criarAtalho(tituloDoc, tituloDocReferenciado);
    }



}
