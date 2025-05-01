package ejercicio1;

import ejercicio1.database.JdbcRegistroDeParticipantes;
import ejercicio1.model.Participantes;
import ejercicio1.ui.AgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new Participantes(new JdbcRegistroDeParticipantes("jdbc:derby:memory:participantes;create=true",
                            "app",
                            "app")));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}