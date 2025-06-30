/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciosjava;

/**
 *
 * @author usuario
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Semana_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE EJERCICIOS ---");
            System.out.println("1. Mostrar lista de asignaturas");
            System.out.println("2. Mostrar 'Yo estudio <asignatura>'");
            System.out.println("3. Ingresar y mostrar notas por asignatura");
            System.out.println("4. Números ganadores de la lotería ordenados");
            System.out.println("5. Números del 1 al 10 en orden inverso");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarAsignaturas();
                    break;
                case 2:
                    estudiarAsignaturas();
                    break;
                case 3:
                    ingresarNotas(scanner);
                    break;
                case 4:
                    numerosLoteria(scanner);
                    break;
                case 5:
                    numerosInversos();
                    break;
                case 0:
                    System.out.println("¡Programa finalizado!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Ejercicio 1
    public static void mostrarAsignaturas() {
        ArrayList<String> asignaturas = getAsignaturas();
        System.out.println("\nAsignaturas del curso:");
        for (String asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }

    // Ejercicio 2
    public static void estudiarAsignaturas() {
        ArrayList<String> asignaturas = getAsignaturas();
        System.out.println();
        for (String asignatura : asignaturas) {
            System.out.println("Yo estudio " + asignatura);
        }
    }

    // Ejercicio 3
    public static void ingresarNotas(Scanner scanner) {
        ArrayList<String> asignaturas = getAsignaturas();
        ArrayList<Double> notas = new ArrayList<>();

        for (String asignatura : asignaturas) {
            System.out.print("¿Qué nota has sacado en " + asignatura + "? ");
            double nota = scanner.nextDouble();
            notas.add(nota);
        }

        System.out.println("\nResumen de notas:");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println("En " + asignaturas.get(i) + " has sacado " + notas.get(i));
        }
    }

    // Ejercicio 4
    public static void numerosLoteria(Scanner scanner) {
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Introduce los 6 números ganadores de la lotería:");
        for (int i = 1; i <= 6; i++) {
            System.out.print("Número " + i + ": ");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        Collections.sort(numeros);
        System.out.println("Números ordenados: " + numeros);
    }

    // Ejercicio 5
    public static void numerosInversos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        System.out.print("Números del 1 al 10 en orden inverso: ");
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(numeros.get(i));
            if (i > 0) System.out.print(", ");
        }
        System.out.println();
    }

    // Método reutilizable
    public static ArrayList<String> getAsignaturas() {
        ArrayList<String> asignaturas = new ArrayList<>();
        asignaturas.add("Matemáticas");
        asignaturas.add("Física");
        asignaturas.add("Química");
        asignaturas.add("Historia");
        asignaturas.add("Lengua");
        return asignaturas;
    }
}
