
public class Main {
    public static void main(String[] args) {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());

        System.out.println("----");

        RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        tempoLP2.adicionaTempoOnline(10);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        tempoLP2.adicionaTempoOnline(2);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        System.out.println(tempoLP2.toString());
        RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
        System.out.println(tempoP2.toString());

        System.out.println("----");

        Disciplina prog2 = new Disciplina("PROGRAMAÇÃO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());

        System.out.println("---");
        RegistroResumos meusResumo = new RegistroResumos(100);
        meusResumo.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumo.adiciona("Tipo", "Identifica a sem6antica (operações e significados) de um conjunto de dados.");

        String[] resumos = meusResumo.pegaResumo();

        for (int i = 0; i < meusResumo.conta(); i++) {
            System.out.println(resumos[i]);
        }

        System.out.println();
        System.out.println("Resumos: ");
        System.out.println(meusResumo.impremeResumos());
        System.out.println(meusResumo.temResumo("Classes"));
        System.out.println(meusResumo.temResumo("Objetos"));
    }
}
