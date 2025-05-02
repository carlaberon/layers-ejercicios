package ejercicio2.model;

import java.io.IOException;
import java.util.*;

public class Empleados {
    public static final String FECHA_DE_NACIMIENTO = "fecha de nacimiento";
    public static final int INDICE_FECHA_DE_NACIMIENTO = 2;
    private List<String[]> empleados;
    private Map<String, String> filtrosDeBusqueda;
    private Map<String, Integer> mapaNombreIndice;

    public Empleados(FuenteDeDatos lectorCSV) {
        this.empleados = lectorCSV.toList();
        this.mapaNombreIndice = Map.of("apellido", 0, "nombre", 1, FECHA_DE_NACIMIENTO, INDICE_FECHA_DE_NACIMIENTO);
        this.filtrosDeBusqueda = new HashMap<String, String>();
    }

    public List<String[]> listaDeEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    public Empleados filtrarPor(String columnaNombre, String valor) {
        this.filtrosDeBusqueda.put(columnaNombre, valor);
        return this;
    }

    public List<String[]> where()
            throws IOException {
        List<String[]> results = new ArrayList<>();
        for (String nombreColumna : this.filtrosDeBusqueda.keySet()) {
            for (String[] empleado : empleados) {
                if (empleado[this.mapaNombreIndice.get(nombreColumna)].equals(filtrosDeBusqueda.get(nombreColumna))) {

                    results.add(empleado);
                }
            }

        }
        return results;
    }


}
