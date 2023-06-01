package entities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Termos extends Elemento{
	private String separador;
    private String ordem;

    public Termos(int prioridade, String valor, String separador, String ordem) {
        super(prioridade, valor);
        this.propriedades.put("separador", separador);
        this.propriedades.put("ordem", ordem);
        this.ordem = ordem.toUpperCase();
    }


    @Override
    public String gerarRepresentacaoCompleta() {
        String retorno = "";
        String[] conteudoDoElemento = super.valor.split(separador);
        System.out.println("Total de termos: " + conteudoDoElemento.length);
        switch (ordem){
            case "ALFABÉTICO" -> Arrays.sort(conteudoDoElemento);
            case "TAMANHO" -> Arrays.sort(conteudoDoElemento, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        }

        for (int i = 0; i < conteudoDoElemento.length; i++){
            retorno += "- " + conteudoDoElemento[i] + " ";
        }
        return retorno;
    }

    @Override
    public String gerarRepresentacaoResumida() {
        String retorno = "";
        String[] conteudoDoElemento = super.valor.split(separador);

        if(this.ordem.equalsIgnoreCase("ALFABÉTICA") || this.ordem.equalsIgnoreCase("TAMANHO") ){
            Arrays.sort(conteudoDoElemento);
            for(int i = 0; i < conteudoDoElemento.length; i++){
                if (i == conteudoDoElemento.length - 1){ // saber se é o ultimo elemento do array
                    retorno += conteudoDoElemento[i];
                }
                retorno += conteudoDoElemento[i] + "/";
            }
        } else {
            for(int i = 0; i < conteudoDoElemento.length; i++){
                if (i == conteudoDoElemento.length - 1){ // saber se é o ultimo elemento do array
                    retorno += conteudoDoElemento[i];
                }
                retorno += conteudoDoElemento[i] + "/";
            }
        }

        return retorno;
    }
}

