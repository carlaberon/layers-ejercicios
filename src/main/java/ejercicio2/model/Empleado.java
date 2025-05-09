package ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

import static java.time.MonthDay.from;

public class Empleado {

    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaDeNacimiento;

    public Empleado(String nombre, String apellido, String email, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public boolean estuCumple(MonthDay undiaMes) {

        return from(this.fechaDeNacimiento).equals(undiaMes);

    }

    public String email() {
        return email;
    }

    public LocalDate fechaNacimiento() {
        return this.fechaDeNacimiento;
    }

    public String nombre() {
        return this.nombre;
    }

    public String apellido() {
        return this.apellido;
    }
}
