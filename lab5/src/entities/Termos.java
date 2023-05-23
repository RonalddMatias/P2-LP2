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
            case "ALFABÉTICA" -> Arrays.sort(valor.split(propriedades.get("separador")), String.CASE_INSENSITIVE_ORDER);
        }
    }


    @Override
    public String gerarRepresentacaoCompleta() {
        return null;
    }

    @Override
    public String gerarRepresentacaoResumida() {
        return null;
    }
}
