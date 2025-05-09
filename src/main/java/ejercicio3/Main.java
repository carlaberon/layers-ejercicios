package ejercicio3;

import ejercicio3.database.DataBaseRegistroDeConcursos;
import ejercicio3.model.Inscripto;
import ejercicio3.model.Inscriptos;
import ejercicio3.model.RegistroInscriptos;
import ejercicio3.services.ArchivoDeInscriptos;

import javax.swing.*;

public class Main {
    public static final String PATH_CONCURSOS = "src/main/resources/concursos.txt";
    private static final String PATH_INSCRIPTOS = "src/main/resources/inscriptos.txt";

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
//        RegistroDeConcursos lectorTxtConcursos = new LectorTxtConcursos(PATH_CONCURSOS);
//
        DataBaseRegistroDeConcursos registroBD = new DataBaseRegistroDeConcursos();

        RegistroInscriptos inscriptos = new RegistroInscriptos() {
            @Override
            public void registrar(Inscripto inscripto) {
                //registrar -> falta implementacion
            }
        };
        ArchivoDeInscriptos archivoDeInscriptos = new ArchivoDeInscriptos(PATH_INSCRIPTOS);

//        Inscriptos inscriptos1 = new Inscriptos(inscriptos);
        Inscriptos inscriptos1 = new Inscriptos(archivoDeInscriptos);


//        new RadioCompetition(inscriptos1, lectorTxtConcursos);
        new RadioCompetition(inscriptos1, registroBD);
    }
}
