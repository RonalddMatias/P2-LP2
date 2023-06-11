package entities;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Classe que representa um atalho para um conjunto de elementos.
 * Um atalho é um elemento que contém referências para outros elementos em um documento.
 *
 * @author Ronaldd Matias - 122110574
 */
public class Atalho extends Elemento{

    private ArrayList<Elemento> elementos;

    /**
     * Construtor da classe Atalho.
     * @param prioridade a prioridade do atalho
     * @param valor o valor do atalho
     * @param elementos os elementos referenciados pelo atalho
     */
    public Atalho(int prioridade, String valor, ArrayList<Elemento> elementos) {
        super(prioridade, valor);
        this.elementos = elementos;
    }
    /**
     * Gera a representação completa do atalho.
     * A representação completa inclui a representação completa dos elementos referenciados pelo atalho.
     * @return a representação completa do atalho
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        System.out.println("teste2");
        String retorno = "";
        for (int i = 1; i < elementos.size(); i++){
            if (elementos.get(i).getPrioridade() == 4 || elementos.get(i).getPrioridade() == 5){
                retorno += elementos.get(i).gerarRepresentacaoCompleta() + "\n";
            }
        }
        return retorno;
    }
    /**
     * Gera a representação resumida do atalho.
     * A representação resumida inclui a representação resumida dos elementos referenciados pelo atalho.
     * @return a representação resumida do atalho
     */
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
