package ejercicio2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CumpleEmpleadosTest {

    @Test
    public void test01() {
        //setup

        var empleado1 = new Empleado("Carla", "Perez", "carlaPerez@gmail.com", LocalDate.of(2000, 11, 10));
        var empleado2 = new Empleado("Jose", "Hernandez", "joseH@gmail.com", LocalDate.of(2000, 3, 10));
        var registroDeEmpleados = new RegistroDeEmpleados() {
            @Override
            public List<Empleado> empleados() {
                return List.of(empleado1, empleado2);
            }
        };
        var notificacion = new FakeNotificacion();
        var mensaje = new MensajeCumpleanios(registroDeEmpleados, notificacion);
        //ejercitacion
        mensaje.enviarSaludos(MonthDay.of(11, 10));
        //verificacion
        assertEquals("carlaPerez@gmail.com", notificacion.data());
    }

    class FakeNotificacion implements Notificacion {
        private String data;

        @Override
        public void enviarEmail(String email, String cuerpoDelCorreo) {
            this.data = email;
        }

        public String data() {
            return this.data;
        }
    }
}
