package entities;

public class MinhaClasse  implements Comparable<MinhaClasse> {
    private String valor;

    public MinhaClasse(String valor) {
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    @Override
    public int compareTo(MinhaClasse outra){
        return Integer.compare(outra.valor.length(), this.valor.length());
    }
}
