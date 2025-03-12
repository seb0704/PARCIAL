package org.example;
import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private final List<Cabina> cabinas = new ArrayList<>();

    public void agregarCabina(String nombre) {
        cabinas.add(new Cabina(nombre));
        System.out.println("\nCABINA '" + nombre + "' /*/*/*/*/*CREADA EXITOSAMENTE.*/*/*/*/*/*");
    }

    public Cabina buscarCabina(String nombre) {
        for (Cabina cabina : cabinas) {
            if (cabina.getNombre().equalsIgnoreCase(nombre)) {
                return cabina;
            }
        }
        return null;
    }

    public void mostrarConsolidado() {
        if (cabinas.isEmpty()) {
            System.out.println("\n NO HAY CABINAS REGISTRADAS.");
            return;
        }

        double totalCosto = 0;
        int totalLlamadas = 0;
        int totalMinutos = 0;

        for (Cabina cabina : cabinas) {
            totalCosto += cabina.getCostoTotal();
            totalLlamadas += cabina.getTotalLlamadas();
            totalMinutos += cabina.getTotalMinutos();
        }

        System.out.println("\n HISTORIALl:");
        System.out.println(" TOTAL LLAMADAS: " + totalLlamadas);
        System.out.println(" TOTAL MINUTOS: " + totalMinutos);
        System.out.println(" TOTAL: $" + totalCosto);
    }
}