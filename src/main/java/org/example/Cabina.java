package org.example;
import java.util.Random;

public class Cabina {
    private final String nombre;
    private int llamadasLocales, llamadasLarga, llamadasCelulares;
    private int minutosLocales, minutosLarga, minutosCelulares;
    private double costoTotal;

    private static final double TARIFA_LOCAL = 50;
    private static final double TARIFA_LARGA = 350;
    private static final double TARIFA_CELULAR = 150;
    private static final Random random = new Random(); // Generador de duración aleatoria

    public Cabina(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void registrarLlamada(String tipo) {
        int minutos = random.nextInt(10) + 1; // Duración aleatoria entre 1 y 10 minutos
        double costo = 0; // Inicializamos costo

        switch (tipo.toLowerCase()) {
            case "local" -> {
                llamadasLocales++;
                minutosLocales += minutos;
                costo = minutos * TARIFA_LOCAL;
            }
            case "larga" -> {
                llamadasLarga++;
                minutosLarga += minutos;
                costo = minutos * TARIFA_LARGA;
            }
            case "celular" -> {
                llamadasCelulares++;
                minutosCelulares += minutos;
                costo = minutos * TARIFA_CELULAR;
            }
            default -> {
                System.out.println("Tipo de llamada no válido.");
                return;
            }
        }

        costoTotal += costo;

        System.out.println("\nLLAMADA REGISTRADA:");
        System.out.println(" TIPO: " + tipo);
        System.out.println(" DURACIÓN: " + minutos + " min");
        System.out.println(" COSTO: $" + costo);
        System.out.println("VOLVIENDO AL MENÚ...\n");
    }

    public void mostrarDetalles() {
        System.out.println("\n Cabina: " + nombre);
        System.out.println("  - Llamadas Locales: " + llamadasLocales + " (" + minutosLocales + " min)");
        System.out.println("  - Llamadas Larga Distancia: " + llamadasLarga + " (" + minutosLarga + " min)");
        System.out.println("  - Llamadas Celulares: " + llamadasCelulares + " (" + minutosCelulares + " min)");
        System.out.println("- Costo Total: $" + costoTotal);
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public int getTotalLlamadas() {
        return llamadasLocales + llamadasLarga + llamadasCelulares;
    }

    public int getTotalMinutos() {
        return minutosLocales + minutosLarga + minutosCelulares;
    }

    public void reiniciarCabina() {
        llamadasLocales = llamadasLarga = llamadasCelulares = 0;
        minutosLocales = minutosLarga = minutosCelulares = 0;
        costoTotal = 0;
        System.out.println("\nCabina '" + nombre + "' reiniciada con éxito.");
    }
}