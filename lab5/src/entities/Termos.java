package entities;

import java.util.Arrays;
import java.util.Locale;

public class Termos extends Elemento{
	private String separador;
    private String ordem;

    public Termos(int prioridade, String valor, String separador, String ordem) {
        super(prioridade, valor);
        this.propriedades.put("separador", separador);
        this.propriedades.put("ordem", ordem);
        this.ordem = ordem.toUpperCase();

        switch (ordem){
            case "ALFABÉTICA" ->  Arrays.sort(valor.split(separador));
        }
    }


    @Override
    public String gerarRepresentacaoCompleta() {
        String retorno = "";
        String[] conteudoDoElemento = super.valor.split(separador);
        System.out.println("Total de termos: " + conteudoDoElemento.length);

        if (this.ordem.equalsIgnoreCase("ALFABÉTICA")) {
             Arrays.sort(conteudoDoElemento);
                for (int i = 0; i < conteudoDoElemento.length; i++){
                    retorno += "- " + conteudoDoElemento[i] + " ";
              }
        } else if (this.ordem.equalsIgnoreCase("TAMANHO")) {
            
        } else {
            Arrays.sort(conteudoDoElemento);
            for (int i = 0; i < conteudoDoElemento.length; i++){
                retorno += "- " + conteudoDoElemento[i] + " ";
            }
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