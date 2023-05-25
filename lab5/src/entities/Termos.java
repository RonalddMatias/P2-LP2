package entities;

import java.util.Arrays;
import java.util.Locale;

public class Termos extends Elemento{
	private String separador;
    private String ordem;
    private String[] conteudoDoElemento;

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
        String[] conteudoDoElemento = super.valor.split(separador);

    }

    @Override
    public String gerarRepresentacaoResumida() {
        return null;
    }
}

    private voif