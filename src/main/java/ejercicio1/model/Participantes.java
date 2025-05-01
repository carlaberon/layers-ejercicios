package ejercicio1.model;

public class Participantes {
    private RegistroParticipantes registroDeParticipantes;

    public Participantes(RegistroParticipantes registroDeParticipantes) {
        this.registroDeParticipantes = registroDeParticipantes;
    }

    public void nuevoParticipante(String nombre, String telefono, String region) {
        var participante = new Participante(nombre, telefono, region);
        this.registroDeParticipantes.registrar(participante);
    }
}
