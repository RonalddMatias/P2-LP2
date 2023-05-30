package DocuMin;

public class Facade {
    private ControllerDocumento controllerDocumento;
    private ControllerElemento controllerElemento;

    public Facade(ControllerDocumento controllerDocumento) {
        this.controllerDocumento = new ControllerDocumento();
        this.controllerElemento = new ControllerElemento();
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
        return 0;
    }
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        return 0;
    }

    public int criarTermo(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
        return 0;
    }

    public String PegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return null;
    }

    public String PegarRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return null;
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return true;
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao){

    }
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
    }



}
