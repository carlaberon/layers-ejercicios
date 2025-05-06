package ejercicio2.model;

import java.time.MonthDay;

public class MensajeCumpleanios {

    private RegistroDeEmpleados registroDeEmpleados;
    private Notificacion email;

    public MensajeCumpleanios(RegistroDeEmpleados registroDeEmpleados, Notificacion notificacion) {
        this.registroDeEmpleados = registroDeEmpleados;
        this.email = notificacion;
    }

    public void enviarSaludos(MonthDay of) {
        var empleados = this.registroDeEmpleados.empleados();
        for (var empleado : empleados) {
            if (empleado.estuCumple(of)) {
                this.email.enviarEmail(empleado.email(), "Feliz cumpleaños!");
            }
        }
    }
}
