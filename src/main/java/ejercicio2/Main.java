package ejercicio2;

import ejercicio2.model.MensajeCumpleanios;
import ejercicio2.services.LectorCsvEmpleados;
import ejercicio2.services.ServiceMensaje;

import java.io.IOException;
import java.time.MonthDay;

public class Main {

    public static final String HOST = "sandbox.smtp.mailtrap.io";
    public static final String PORT = "2525";
    public static final String HABILITAR_AUTENTICACION = "true";
    public static final String USERNAME = "0396297949b4d1";
    public static final String PWD = "e4c28348b3d4dc";
    public static final String PATH = "src/main/resources/empleados.csv";

    public static void main(String[] args) throws IOException {

        LectorCsvEmpleados lectorDeEmpleados = new LectorCsvEmpleados(PATH);
        var listaDeEmpleados = lectorDeEmpleados.empleados();
        listaDeEmpleados.stream().forEach(Empleado -> System.out.println(Empleado.email()));
        var notificacion = new ServiceMensaje(PWD, USERNAME, HABILITAR_AUTENTICACION, "true", HOST, PORT);
        var mensajeCumpleanios = new MensajeCumpleanios(lectorDeEmpleados, notificacion);
        mensajeCumpleanios.enviarSaludos(MonthDay.of(10, 8));


    }
}
