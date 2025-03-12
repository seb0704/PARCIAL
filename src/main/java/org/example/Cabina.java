package org.example;
import java.util.Random;

public class Cabina {
    private final String nombre;
    private int llamadasLocales, llamadasLarga, llamadasCelulares;
    private int minutosLocales, minutosLarga, minutosCelulares;
    private double costoTotal;

    private static final double LOCAL = 50;
    private static final double LARGA = 350;
    private static final double CELULAR = 150;
    private static final Random random = new Random(); // Generador de duración aleatoria

    public Cabina(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void registrarLlamada(String tipo) {
        int minutos = random.nextInt(10) + 1;
        double costo = 0;

        switch (tipo.toLowerCase()) {
            case "local" -> {
                llamadasLocales++;
                minutosLocales += minutos;
                costo = minutos * LOCAL;
            }
            case "larga" -> {
                llamadasLarga++;
                minutosLarga += minutos;
                costo = minutos * LARGA;
            }
            case "celular" -> {
                llamadasCelulares++;
                minutosCelulares += minutos;
                costo = minutos * CELULAR;
            }
            default -> {
                System.out.println("TIPO DE LLAMDA NO VALIDO.");
                return;
            }
        }

        costoTotal += costo;

        System.out.println("\nLLAMADA REGISTRADA:");
        System.out.println(" TIPO: " + tipo);
        System.out.println(" DURACIÓN: " + minutos + " MIN");
        System.out.println(" COSTO: $" + costo);
        System.out.println("VOLVIENDO AL MENÚ...\n");
    }

    public void mostrarDetalles() {
        System.out.println("\n CABINA: " + nombre);
        System.out.println("  - LLAMADAS LOCALES: " + llamadasLocales + " (" + minutosLocales + " MIN)");
        System.out.println("  - LLAMADA LARGA DISTANCIA: " + llamadasLarga + " (" + minutosLarga + " MIN)");
        System.out.println("  - LLAMDA DE CELULARES: " + llamadasCelulares + " (" + minutosCelulares + " MIN)");
        System.out.println("- TOTAL: $" + costoTotal);
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
        System.out.println("\nCABINA '" + nombre + "' REINICIANDO.");
    }
}