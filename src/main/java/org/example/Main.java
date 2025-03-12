package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestor gestor = new Gestor();

        while (true) {
            System.out.println("");
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1 CREAR CABINA");
            System.out.println("2 REGISTRAR LLAMADA");
            System.out.println("3 MOSTRAR DETALLES DE CABINA");
            System.out.println("4 HISTORIAL");
            System.out.println("5 REINICIAR");
            System.out.println("6 SALIR");
            System.out.print(" Elige--->: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 : {
                    System.out.print("\n INGRESE NOMBRE DE CABINA: ");
                    String nombre = scanner.nextLine();
                    gestor.agregarCabina(nombre);
                }
                case 2 : {
                    System.out.print("\n INGRESE NOMBRE DE CABINA: ");
                    String nombre = scanner.nextLine();
                    Cabina cabina = gestor.buscarCabina(nombre);
                    if (cabina != null) {
                        System.out.print("TIPO DE LLAMADA (LOCAL---LARGA----CELULAR): ");
                        String tipo = scanner.nextLine();
                        cabina.registrarLlamada(tipo);
                    } else {
                        System.out.println(" CABINA NO ENCONTRADA.");
                    }
                }
                case 3 : {
                    System.out.print("\n INGRESE NOMBRE DE CABINA: ");
                    String nombre = scanner.nextLine();
                    Cabina cabina = gestor.buscarCabina(nombre);
                    if (cabina != null) cabina.mostrarDetalles();
                    else System.out.println(" CABINA NO ENCONTRADA");
                }
                case 4 : gestor.mostrarConsolidado();
                case 5 : {
                    System.out.print("\nINGRESE NOMBRE DE CABINA PARA REINICIAR ");
                    String nombre = scanner.nextLine();
                    Cabina cabina = gestor.buscarCabina(nombre);
                    if (cabina != null) cabina.reiniciarCabina();
                    else System.out.println("CABINA NO ENCONTRADA");
                }
                case 6 : {
                    System.out.println(" SALIENDO...");
                    scanner.close();
                    return;
                }
                default : System.out.println(" NO VALIDO.");
            }
        }
    }
}