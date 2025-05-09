package ejercicio2.database;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistroDeEmpleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersistenciaRegistroDeEmpleados implements RegistroDeEmpleados {


    @Override
    public List<Empleado> empleados() {
        return List.of();
    }

    @Override
    public void registrar(Empleado empleado) {

        PreparedStatement statement;
        Connection conn;
        try {
            conn = ConnectionManager.getConnection();

            statement = conn
                    .prepareStatement("INSERT INTO empleados(fecha_nacimiento, nombre_empleado,apellido_empleado, email_empleado) VALUES(?, ?, ?, ?)");


            statement.setDate(1, java.sql.Date.valueOf(empleado.fechaNacimiento()));
            statement.setString(2, empleado.nombre());
            statement.setString(3, empleado.apellido());
            statement.setString(4, empleado.email());

            if (statement.executeUpdate() == 0) {
                throw new RuntimeException("No fue posible realizar la carga");
            }


        } catch (Exception e1) {
            //excepcion
            throw new RuntimeException("SQLException", e1);
        } finally {
            try {
                ConnectionManager.disconnect();
            } catch (SQLException e) {
                //excepcion
                throw new RuntimeException("SQLException", e);
            }
        }
    }
}
