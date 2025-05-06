package ejercicio3;

import ejercicio3.model.Inscripto;
import ejercicio3.model.Inscriptos;
import ejercicio3.model.RegistroInscriptos;
import ejercicio3.services.LectorTxtConcursos;

public class Main {
    public static final String PATH = "src/main/resources/concursos.txt";

    public static void main(String[] args) {
        LectorTxtConcursos lectorTxtConcursos = new LectorTxtConcursos(PATH);
        var listaDeConcursos = lectorTxtConcursos.concursos();
        listaDeConcursos.stream().forEach(c -> System.out.println(c.nombre()));

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new Main().start();
//                } catch (Exception e) {
//// log exception...
//                    System.out.println(e);
//                }
//            }
//        });
    }

    private void start() {
        new RadioCompetition(new Inscriptos(new RegistroInscriptos() {
            @Override
            public void registrar(Inscripto inscripto) {

            }
        }));
    }
}
