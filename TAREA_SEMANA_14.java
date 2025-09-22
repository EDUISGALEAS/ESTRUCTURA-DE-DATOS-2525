/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_14;

import java.util.Scanner;

// Clase de Nodo
class Nodo {
    int dato;
    Nodo izquierda, derecha;

    public Nodo(int dato) {
        this.dato = dato;
        izquierda = derecha = null;
    }
}

// Clase de Árbol Binario
class ArbolBinario {
    Nodo raiz;

    // Insertar nodo
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }
        if (dato < raiz.dato) {
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        } else if (dato > raiz.dato) {
            raiz.derecha = insertarRec(raiz.derecha, dato);
        }
        return raiz;
    }

    // Recorridos
    public void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            inOrden(raiz.derecha);
        }
    }

    public void preOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            preOrden(raiz.izquierda);
            preOrden(raiz.derecha);
        }
    }

    public void postOrden(Nodo raiz) {
        if (raiz != null) {
            postOrden(raiz.izquierda);
            postOrden(raiz.derecha);
            System.out.print(raiz.dato + " ");
        }
    }

    // Buscar
    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null) return false;
        if (raiz.dato == dato) return true;
        return dato < raiz.dato ? buscarRec(raiz.izquierda, dato) : buscarRec(raiz.derecha, dato);
    }

    // Eliminar nodo
    public void eliminar(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo raiz, int dato) {
        if (raiz == null) return raiz;

        if (dato < raiz.dato) {
            raiz.izquierda = eliminarRec(raiz.izquierda, dato);
        } else if (dato > raiz.dato) {
            raiz.derecha = eliminarRec(raiz.derecha, dato);
        } else {
            // Caso 1: sin hijos
            if (raiz.izquierda == null && raiz.derecha == null) return null;

            // Caso 2: un hijo
            if (raiz.izquierda == null) return raiz.derecha;
            else if (raiz.derecha == null) return raiz.izquierda;

            // Caso 3: dos hijos
            raiz.dato = valorMinimo(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.dato);
        }
        return raiz;
    }

    private int valorMinimo(Nodo raiz) {
        int min = raiz.dato;
        while (raiz.izquierda != null) {
            min = raiz.izquierda.dato;
            raiz = raiz.izquierda;
        }
        return min;
    }
}

// Clase principal TAREA_SEMANA_14.java)
public class TAREA_SEMANA_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion, dato;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Recorrido inOrden");
            System.out.println("3. Recorrido preOrden");
            System.out.println("4. Recorrido postOrden");
            System.out.println("5. Buscar nodo");
            System.out.println("6. Eliminar nodo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el dato a insertar: ");
                    dato = sc.nextInt();
                    arbol.insertar(dato);
                    break;
                case 2:
                    System.out.print("Recorrido inOrden: ");
                    arbol.inOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Recorrido preOrden: ");
                    arbol.preOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Recorrido postOrden: ");
                    arbol.postOrden(arbol.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Dato a buscar: ");
                    dato = sc.nextInt();
                    System.out.println(arbol.buscar(dato) ? "Nodo encontrado" : "Nodo no encontrado");
                    break;
                case 6:
                    System.out.print("Dato a eliminar: ");
                    dato = sc.nextInt();
                    arbol.eliminar(dato);
                    System.out.println("Nodo eliminado si existía.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
