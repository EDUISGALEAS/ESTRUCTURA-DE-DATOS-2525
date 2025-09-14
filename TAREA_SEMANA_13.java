/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_13;

import java.util.Scanner;

public class TAREA_SEMANA_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Catálogo de revistas en español
        String[] catalogo = {
            "Arte y Cultura",
            "Salud y Bienestar",
            "Historia Universal",
            "Viajes y Aventuras",
            "Tecnología Hoy",
            "Gastronomía Moderna",
            "Educación y Ciencia",
            "Moda Actual",
            "Fotografía Creativa",
            "Economía Global"
        };

        int opcion = 0;

        do {
            System.out.println("\n--- Catálogo de Revistas ---");
            System.out.println("1. Buscar un título");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la revista a buscar: ");
                    String titulo = sc.nextLine();
                    boolean encontrado = busquedaRecursiva(catalogo, titulo, 0);
                    System.out.println(encontrado ? "Resultado: Encontrado ✅" : "Resultado: No encontrado ❌");
                    break;

                case 2:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 2);

        sc.close();
    }

    // Búsqueda recursiva
    public static boolean busquedaRecursiva(String[] catalogo, String titulo, int indice) {
        if (indice >= catalogo.length) return false;
        if (catalogo[indice].equalsIgnoreCase(titulo)) return true;
        return busquedaRecursiva(catalogo, titulo, indice + 1);
    }
}
