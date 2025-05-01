package ejercicio1.model;

class Telefono {
    private String telefono;

    public Telefono(String telefono) {
        if (!validarTelefono(telefono)) {
            throw new RuntimeException("El teléfono ingresado no es válido");
        }
        this.telefono = telefono;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String string() {
        return this.telefono;
    }
}
