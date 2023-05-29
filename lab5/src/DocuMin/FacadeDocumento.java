package DocuMin;

public class FacadeDocumento {
    private ControllerDocumento controllerDocumento;
    private ControllerElemento controllerElemento;

    public FacadeDocumento(ControllerDocumento controllerDocumento) {
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

}
