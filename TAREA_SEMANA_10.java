/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_10;

import java.util.*;

public class TAREA_SEMANA_10 {
    public static void main(String[] args) {
        // Conjunto de todos los ciudadanos
        Set<String> ciudadanos = new HashSet<>();
        for (int i = 1; i <= 500; i++) {
            ciudadanos.add("Ciudadano " + i);
        }

        // Generar vacunados ficticios con Pfizer (75 aleatorios)
        Set<String> pfizer = new HashSet<>();
        List<String> listaCiudadanos = new ArrayList<>(ciudadanos);
        Collections.shuffle(listaCiudadanos); // Mezclar aleatoriamente
        for (int i = 0; i < 75; i++) {
            pfizer.add(listaCiudadanos.get(i));
        }

        // Generar vacunados ficticios con AstraZeneca (75 aleatorios)
        Set<String> astrazeneca = new HashSet<>();
        Collections.shuffle(listaCiudadanos);
        for (int i = 0; i < 75; i++) {
            astrazeneca.add(listaCiudadanos.get(i));
        }

        // Ciudadanos no vacunados = Todos - (Pfizer ∪ AstraZeneca)
        Set<String> vacunados = new HashSet<>(pfizer);
        vacunados.addAll(astrazeneca);
        Set<String> noVacunados = new HashSet<>(ciudadanos);
        noVacunados.removeAll(vacunados);

        // Ambas dosis = Intersección (Pfizer ∩ AstraZeneca)
        Set<String> ambasDosis = new HashSet<>(pfizer);
        ambasDosis.retainAll(astrazeneca);

        // Solo Pfizer = Pfizer - AstraZeneca
        Set<String> soloPfizer = new HashSet<>(pfizer);
        soloPfizer.removeAll(astrazeneca);

        // Solo AstraZeneca = AstraZeneca - Pfizer
        Set<String> soloAstrazeneca = new HashSet<>(astrazeneca);
        soloAstrazeneca.removeAll(pfizer);

        // Imprimir resultados
        System.out.println("---- Resultados ----");
        System.out.println("Total de ciudadanos: " + ciudadanos.size());
        System.out.println("Vacunados con Pfizer: " + pfizer.size());
        System.out.println("Vacunados con AstraZeneca: " + astrazeneca.size());
        System.out.println("No vacunados: " + noVacunados.size());
        System.out.println("Ambas dosis: " + ambasDosis.size());
        System.out.println("Solo Pfizer: " + soloPfizer.size());
        System.out.println("Solo AstraZeneca: " + soloAstrazeneca.size());
    }
}
