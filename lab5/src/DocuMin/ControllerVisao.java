package DocuMin;

import entities.Elemento;
import entities.VisaoI;

import java.util.ArrayList;

public class ControllerVisao implements VisaoI {

    private ArrayList visoes;

    public ControllerVisao(ArrayList visoes) {
        this.visoes = new ArrayList<>();
    }
    public ArrayList getVisoes(){
        return (ArrayList) visoes.clone();
    }

    public String[] pegandoVisaoPeloId(int visaoId) {

        if(existePosicao(visaoId)){
            throw new IllegalArgumentException("Visao não existente.");
        }
        return (String[]) visoes.get(visaoId);
    }
    public void adicionaVisao(String[] visaoCompleta) {
        visoes.add(visaoCompleta);
    }


    @Override
    public String[] criarVisaoCompleta(Documento documento) {
        ArrayList<String> visaoCompleta =  new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            visaoCompleta.add(elemento.gerarRepresentacaoCompleta());
        }
        return (String[]) visaoCompleta.toArray();
    }

    @Override
    public String[] criarVisaoResumida(Documento documento) {
        ArrayList<String> visaoResumida = new ArrayList<>();
        for(Elemento elemento: documento.getElementos()){
            visaoResumida.add(elemento.gerarRepresentacaoCompleta());
        }
        return (String[])  visaoResumida.toArray();
    }

    @Override
    public String[] criarVisaoPrioritaria(Documento documento, int prioridade) {
        ArrayList<String> visaoPrioritaria = new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            if (elemento.getPrioridade() >= prioridade){
                visaoPrioritaria.add(elemento.gerarRepresentacaoCompleta());
            }
        }
        return (String[]) visaoPrioritaria.toArray();
    }

    public String[] criarVisaoTitulo(Documento documento) {
        ArrayList<String> visaoTitulo = new ArrayList<>();
        for (Elemento elemento : documento.getElementos()){
            visaoTitulo.add(elemento.gerarRepresentacaoResumida());
        }
        return (String[]) visaoTitulo.toArray();
    }
    private boolean existePosicao(int visaoId) {
        if (visoes.get(visaoId) == null){
            return true;
        }
        return false;
    }

    
}
