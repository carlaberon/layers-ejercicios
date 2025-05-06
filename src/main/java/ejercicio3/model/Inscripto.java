package ejercicio3.model;


public class Inscripto {

    private final String apellido;
    private final String nombre;
    private final int idConcurso;
    private final Telefono telefono;
    private final Email email;

    public Inscripto(String apellido, String nombre, String telefono, String email, int idConcurso) {
        if (apellido.isEmpty()) {
            throw new RuntimeException("el apellido ingresado es inválido");
        }
        if (nombre.isEmpty()) {
            throw new RuntimeException("el nombre ingresado es inválido");
        }

        this.apellido = apellido;
        this.nombre = nombre;
        this.idConcurso = idConcurso;
        this.telefono = new Telefono(telefono);
        this.email = new Email(email);
    }
}
