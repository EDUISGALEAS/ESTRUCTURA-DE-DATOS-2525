/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_12;
import java.util.*;

public class PCE_SEMANA_12 {
    public static void main(String[] args) {
        Set<Deportista> deportistas = new HashSet<>();
        Map<String, List<Deportista>> disciplinas = new HashMap<>();

        // Agregar deportistas
        Deportista d1 = new Deportista("Juan Pérez", "Atletismo", 9.5, "Oro");
        Deportista d2 = new Deportista("María López", "Natación", 8.7, "Plata");
        Deportista d3 = new Deportista("Carlos Ruiz", "Atletismo", 9.2, "Bronce");

        deportistas.add(d1);
        deportistas.add(d2);
        deportistas.add(d3);

        // Organizar por disciplina
        for (Deportista d : deportistas) {
            disciplinas.computeIfAbsent(d.getDisciplina(), k -> new ArrayList<>()).add(d);
        }

        // Reportería
        System.out.println("===== Lista de Deportistas =====");
        for (Deportista d : deportistas) {
            System.out.println(d);
        }

        System.out.println("\n===== Reporte por disciplina =====");
        for (Map.Entry<String, List<Deportista>> entry : disciplinas.entrySet()) {
            System.out.println("Disciplina: " + entry.getKey());
            for (Deportista d : entry.getValue()) {
                System.out.println("   -> " + d.getNombre() + " (" + d.getPremio() + ")");
            }
        }
    }
}

class Deportista {
    private String nombre;
    private String disciplina;
    private double puntuacion;
    private String premio;

    public Deportista(String nombre, String disciplina, double puntuacion, String premio) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.puntuacion = puntuacion;
        this.premio = premio;
    }

    public String getNombre() { return nombre; }
    public String getDisciplina() { return disciplina; }
    public double getPuntuacion() { return puntuacion; }
    public String getPremio() { return premio; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Disciplina: " + disciplina +
               ", Puntuación: " + puntuacion + ", Premio: " + premio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, disciplina);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Deportista)) return false;
        Deportista d = (Deportista) obj;
        return nombre.equals(d.nombre) && disciplina.equals(d.disciplina);
    }
}



