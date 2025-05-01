package ejercicio1.database;

import ejercicio1.model.Participante;
import ejercicio1.model.RegistroParticipantes;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroDeParticipantes implements RegistroParticipantes {
    private String url;
    private String user;
    private String password;

    public JdbcRegistroDeParticipantes(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public void registrar(Participante participante) {
        PreparedStatement st = null;
        try {
            var dbConn = DriverManager.getConnection(url, user, password);
            st = dbConn
                    .prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");

            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
