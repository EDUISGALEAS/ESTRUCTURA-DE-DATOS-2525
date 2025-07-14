/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.tareasiete;

import java.util.Stack;
import java.util.Scanner;

public class TareaSemanaSiete {

    // ===================== EJERCICIO No1: PARÉNTESIS BALANCEADOS =====================

    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            switch (c) {
                case '(': case '[': case '{':
                    pila.push(c);
                    break;
                case ')':
                    if (pila.isEmpty() || pila.pop() != '(') return false;
                    break;
                case ']':
                    if (pila.isEmpty() || pila.pop() != '[') return false;
                    break;
                case '}':
                    if (pila.isEmpty() || pila.pop() != '{') return false;
                    break;
            }
        }

        return pila.isEmpty();
    }

    public static void ejecutarVerificacionParentesis() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión matemática:");
        String expresion = scanner.nextLine();

        if (estaBalanceada(expresion)) {
            System.out.println("Fórmula balanceada.");
        } else {
            System.out.println("Fórmula desbalanceada.");
        }
    }

    // ===================== EJERCICIO No2: TORRES DE HANOI =====================

    static class Torre {
        Stack<Integer> discos = new Stack<>();
        String nombre;

        Torre(String nombre) {
            this.nombre = nombre;
        }

        void moverCimaA(Torre destino) {
            int disco = discos.pop();
            destino.discos.push(disco);
            System.out.println("Mover disco " + disco + " de " + nombre + " a " + destino.nombre);
        }
    }

    public static void resolverHanoi(int n, Torre origen, Torre auxiliar, Torre destino) {
        if (n == 1) {
            origen.moverCimaA(destino);
        } else {
            resolverHanoi(n - 1, origen, destino, auxiliar);
            origen.moverCimaA(destino);
            resolverHanoi(n - 1, auxiliar, origen, destino);
        }
    }

    public static void ejecutarTorresDeHanoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scanner.nextInt();

        Torre torreA = new Torre("A");
        Torre torreB = new Torre("B");
        Torre torreC = new Torre("C");

        for (int i = numDiscos; i >= 1; i--) {
            torreA.discos.push(i);
        }

        System.out.println("Resolviendo Torres de Hanoi:");
        resolverHanoi(numDiscos, torreA, torreB, torreC);
    }

    // ===================== MÉTODO PRINCIPAL =====================

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE OPCIONES =====");
            System.out.println("1. Verificar paréntesis balanceados");
            System.out.println("2. Resolver Torres de Hanoi");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    ejecutarVerificacionParentesis();
                    break;
                case 2:
                    ejecutarTorresDeHanoi();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
