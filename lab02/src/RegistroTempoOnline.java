public class RegistroTempoOnline {
    private String disciplina;
    private int metaHorasDaDisciplina;
    private int metaHorasOnline;

    public RegistroTempoOnline(String disciplina) {
        this.disciplina = disciplina;
        this.metaHorasDaDisciplina = 120;
    }

    public RegistroTempoOnline(String disciplina, int metaHorasDaDisciplina) {
        this.disciplina = disciplina;
        this.metaHorasDaDisciplina = metaHorasDaDisciplina;
    }

    public void adicionaTempoOnline(int tempo) {
        this.metaHorasOnline += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        boolean condicional = false;
        if (metaHorasOnline * 2 >= metaHorasDaDisciplina) {
            condicional = true;
        }
        return condicional;

    }

    public String toString() {
        return this.disciplina + " " + Integer.toString(metaHorasOnline) + "/"
                + Integer.toString(metaHorasDaDisciplina);
    }

}
