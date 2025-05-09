package ejercicio2.services;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistroDeEmpleados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class LectorCsvEmpleados implements RegistroDeEmpleados {
    private String path;

    public LectorCsvEmpleados(String path) {
        this.path = path;
    }

    @Override
    public List<Empleado> empleados() {
        List<Empleado> empleados = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(",\\s*");
                if (partes.length != 4) continue;

                String apellido = partes[0];
                String nombre = partes[1];
                LocalDate fechaNacimiento = LocalDate.parse(partes[2], formatter);
                String email = partes[3];

                Empleado empleado = new Empleado(nombre, apellido, email, fechaNacimiento);
                empleados.add(empleado);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }

        return empleados;
    }

    @Override
    public void registrar(Empleado empleado) {

    }
}

