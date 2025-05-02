package ejercicio2;

import ejercicio2.model.Empleados;
import ejercicio2.services.LectorCVS;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var empleados = new Empleados(new LectorCVS("src/main/resources/empleados.csv"));

        empleados.listaDeEmpleados().stream()
                .forEach(empleado -> System.out.println(empleado[0] + empleado[1]));

        //FILTRAR POR FECHA NO FUNCIONA
//        var resultado = empleados.filtrarPor("fecha de nacimiento", "2025/05/02").where();
//
        //filtrar por apellido
        var resultado = empleados.filtrarPor("apellido", "Young").where();

        resultado.stream().forEach(Empleados -> System.out.println(Empleados[0] + Empleados[1]));


    }
}
