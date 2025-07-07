/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea6;

import java.util.Random;
import java.util.Scanner;

public class TareaSemanaSeis {

    // Clase Nodo para la lista enlazada
    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Clase ListaEnlazada con métodos para agregar, buscar, eliminar y mostrar
    static class ListaEnlazada {
        Nodo cabeza;

        public void agregar(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }

        public int buscar(int valor) {
            int contador = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.dato == valor) {
                    contador++;
                }
                actual = actual.siguiente;
            }

            if (contador == 0) {
                System.out.println("El valor " + valor + " no fue encontrado en la lista.");
            } else {
                System.out.println("El valor " + valor + " fue encontrado " + contador + " veces.");
            }

            return contador;
        }

        public void eliminarFueraDeRango(int min, int max) {
            while (cabeza != null && (cabeza.dato < min || cabeza.dato > max)) {
                cabeza = cabeza.siguiente;
            }

            Nodo actual = cabeza;
            while (actual != null && actual.siguiente != null) {
                if (actual.siguiente.dato < min || actual.siguiente.dato > max) {
                    actual.siguiente = actual.siguiente.siguiente;
                } else {
                    actual = actual.siguiente;
                }
            }
        }

        public void mostrar() {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        Random random = new Random();

        // Generar 50 números aleatorios y agregarlos a la lista
        System.out.println("Generando lista con 50 números aleatorios:");
        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(999) + 1; // Números entre 1 y 999
            lista.agregar(num);
        }

        System.out.println("Lista original:");
        lista.mostrar();

        // Leer valores mínimo y máximo desde el teclado
        System.out.print("Ingrese el valor mínimo del rango: ");
        int min = scanner.nextInt();

        System.out.print("Ingrese el valor máximo del rango: ");
        int max = scanner.nextInt();

        // Eliminar nodos fuera del rango
        lista.eliminarFueraDeRango(min, max);

        System.out.println("Lista después de eliminar nodos fuera del rango [" + min + ", " + max + "]:");
        lista.mostrar();

        // Buscar un valor ingresado por el usuario
        System.out.print("Ingrese un valor a buscar en la lista: ");
        int valorBuscar = scanner.nextInt();
        lista.buscar(valorBuscar);

        scanner.close();
    }
}
