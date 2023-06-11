package entities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Pattern;

public class Termos extends Elemento{
	private String separador;
    private String ordem;

    public Termos(int prioridade, String valor, String separador, String ordem) {
        super(prioridade, valor);
        this.propriedades.put("separador", separador);
        this.separador = separador;
        this.propriedades.put("ordem", ordem);
        this.ordem = ordem.toUpperCase();
    }


    @Override
    public String gerarRepresentacaoCompleta() {
        String retorno = "";
        String[] conteudoDoElemento = super.valor.split(Pattern.quote(this.separador));
        retorno += "Total de termos: " + conteudoDoElemento.length + "\n";
        retorno += "- ";
        if(ordem.equals("ALFABÉTICA")){
            Arrays.sort(conteudoDoElemento, String.CASE_INSENSITIVE_ORDER);
        } else if (ordem.equals("TAMANHO")) {
            Arrays.sort(conteudoDoElemento, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        }

        for (int i = 0; i < conteudoDoElemento.length; i++){
            if (i == conteudoDoElemento.length -1){
                retorno += conteudoDoElemento[i];
            } else {
                retorno +=conteudoDoElemento[i] + ", ";
            }

        }
        return retorno;
    }

    @Override
    public String gerarRepresentacaoResumida() {
        String retorno = "";
        String[] conteudoDoElemento = super.valor.split(Pattern.quote(this.separador));

        if(this.ordem.equalsIgnoreCase("ALFABÉTICA") || this.ordem.equalsIgnoreCase("TAMANHO") ){
            Arrays.sort(conteudoDoElemento, String.CASE_INSENSITIVE_ORDER);
            for(int i = 0; i < conteudoDoElemento.length; i++){
                if (i == conteudoDoElemento.length-1){ // saber se é o ultimo elemento do array
                    retorno += conteudoDoElemento[i];
                } else {
                    retorno += conteudoDoElemento[i] + " / ";
                }
            }
        } else {
            for(int i = 0; i < conteudoDoElemento.length; i++){
                if (i == conteudoDoElemento.length - 1){ // saber se é o ultimo elemento do array
                    retorno += conteudoDoElemento[i];
                } else {
                    retorno += conteudoDoElemento[i] + "/";
                }

            }
        }

        return retorno;
    }
}

