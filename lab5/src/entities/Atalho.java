package entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Atalho extends Elemento{

    private ArrayList<Elemento> elementos;

    public Atalho(int prioridade, String valor, ArrayList<Elemento> elementos) {
        super(prioridade, valor);
        this.elementos = elementos;
    }

    @Override
    public String gerarRepresentacaoCompleta() {
        String retorno = "";
        for (int i = 1; i < elementos.size(); i++){
            if (elementos.get(i).getPrioridade() == 4 || elementos.get(i).getPrioridade() == 5){
                retorno += elementos.get(i).gerarRepresentacaoCompleta() + "\n";
            }
        }
        return retorno;
    }

    @Override
    public String gerarRepresentacaoResumida() {
        String retorno = "";
        for (int i = 1; i < elementos.size(); i++){
            if (elementos.get(i).getPrioridade() == 4 || elementos.get(i).getPrioridade() == 5){
                retorno += elementos.get(i).gerarRepresentacaoResumida() + "\n";
            }
        }
        return retorno;
    }
}
