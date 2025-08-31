/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TraductorBasico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> diccionario = new HashMap<>();

        // Diccionario base
        diccionario.put("time", "tiempo");
        diccionario.put("person", "persona");
        diccionario.put("year", "año");
        diccionario.put("way", "camino");
        diccionario.put("day", "día");
        diccionario.put("thing", "cosa");
        diccionario.put("man", "hombre");
        diccionario.put("world", "mundo");
        diccionario.put("life", "vida");
        diccionario.put("hand", "mano");
        diccionario.put("part", "parte");
        diccionario.put("child", "niño");
        diccionario.put("eye", "ojo");
        diccionario.put("woman", "mujer");
        diccionario.put("place", "lugar");
        diccionario.put("work", "trabajo");
        diccionario.put("week", "semana");
        diccionario.put("case", "caso");
        diccionario.put("point", "punto");
        diccionario.put("government", "gobierno");
        diccionario.put("company", "empresa");

        int opcion;

        do {
            System.out.println("\n==================== MENÚ ====================");
            System.out.println("1. Traducir una frase");
            System.out.println("2. Agregar palabras al diccionario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la frase: ");
                    String frase = sc.nextLine();
                    String traduccion = traducirFrase(frase, diccionario);
                    System.out.println("Traducción (parcial): " + traduccion);
                    break;

                case 2:
                    System.out.print("Ingrese la palabra en inglés: ");
                    String ingles = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese la palabra en español: ");
                    String espanol = sc.nextLine().toLowerCase();
                    diccionario.put(ingles, espanol);
                    System.out.println("Palabra agregada correctamente.");
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // Función para traducir frase
    public static String traducirFrase(String frase, Map<String, String> diccionario) {
        String[] palabras = frase.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            // Eliminar puntuación para buscar en diccionario
            String palabraLimpia = palabra.replaceAll("[.,!?]", "").toLowerCase();

            if (diccionario.containsKey(palabraLimpia)) {
                // Mantener mayúscula inicial si aplica
                if (Character.isUpperCase(palabra.charAt(0))) {
                    String traduccion = diccionario.get(palabraLimpia);
                    traduccion = traduccion.substring(0, 1).toUpperCase() + traduccion.substring(1);
                    resultado.append(traduccion);
                } else {
                    resultado.append(diccionario.get(palabraLimpia));
                }
            } else {
                resultado.append(palabra);
            }

            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}
