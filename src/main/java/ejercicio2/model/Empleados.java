package ejercicio2.model;


import java.time.LocalDate;

public class Empleados {
    private RegistroDeEmpleados registroDeParticipantes;

    public Empleados(RegistroDeEmpleados registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void nuevoEmpleado(String nombre, String apellido, String email, LocalDate fechaDeNacimiento) {
        var empleado = new Empleado(nombre, apellido, email, fechaDeNacimiento);
        this.registroDeParticipantes.registrar(empleado);
    }
}