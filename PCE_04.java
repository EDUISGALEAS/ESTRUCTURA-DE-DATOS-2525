/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.experimental_04;


import java.util.*;
import java.io.*;

/**
 * Programa: Encuentrar vuelos mas baratos utilizando (grafo dirigido ponderado)
 * Lenguaje: Java
 * Autor: (Estudiante) pracrico experimental 4
 * Nota: Base de datos simulada en memoria. Para leer desde archivo, extender el método loadSampleDataFromFile.
 */
public class PCE_04 {

    // Representa una arista en el grafo
    static class Edge {
        String dest;
        double price;
        Edge(String dest, double price) {
            this.dest = dest;
            this.price = price;
        }
        @Override
        public String toString() {
            return dest + " (" + price + ")";
        }
    }

    // Grafo: lista de adyacencia
    static class Graph {
        private Map<String, List<Edge>> adj = new HashMap<>();
        void addAirport(String code) { adj.putIfAbsent(code, new ArrayList<>()); }
        void addRoute(String from, String to, double price) {
            addAirport(from); addAirport(to);
            adj.get(from).add(new Edge(to, price));
        }
        Set<String> getAirports() { return adj.keySet(); }
        List<Edge> getEdges(String airport) { return adj.getOrDefault(airport, Collections.emptyList()); }
        void printAdjacency() {
            System.out.println("Lista de adyacencia (Aeropuerto -> [destino (precio)])");
            for (String airport : adj.keySet()) {
                System.out.print(airport + " -> "); List<Edge> edges = adj.get(airport);
                System.out.println(edges.isEmpty() ? "[]" : edges);
            }
        }
        void printRoutes() {
            System.out.println("Rutas (origen -> destino : precio)");
            for (String from : adj.keySet())
                for (Edge e : adj.get(from))
                    System.out.printf("%s -> %s : %.2f%n", from, e.dest, e.price);
        }
    }

    static class PathResult {
        Map<String, Double> dist; Map<String, String> prev;
        PathResult(Map<String, Double> dist, Map<String, String> prev) { this.dist = dist; this.prev = prev; }
    }

    static PathResult dijkstra(Graph g, String source) {
        Map<String, Double> dist = new HashMap<>(); Map<String, String> prev = new HashMap<>();
        PriorityQueue<Map.Entry<String, Double>> pq = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        for (String node : g.getAirports()) { dist.put(node, Double.POSITIVE_INFINITY); prev.put(node, null); }
        if (!dist.containsKey(source)) return new PathResult(dist, prev);
        dist.put(source, 0.0); pq.add(new AbstractMap.SimpleEntry<>(source, 0.0));
        while (!pq.isEmpty()) {
            Map.Entry<String, Double> entry = pq.poll(); String u = entry.getKey(); double d = entry.getValue();
            if (d > dist.get(u)) continue;
            for (Edge edge : g.getEdges(u)) {
                String v = edge.dest; double alt = dist.get(u) + edge.price;
                if (alt < dist.get(v)) { dist.put(v, alt); prev.put(v, u); pq.add(new AbstractMap.SimpleEntry<>(v, alt)); }
            }
        }
        return new PathResult(dist, prev);
    }

    static List<String> reconstructPath(Map<String, String> prev, String source, String target) {
        List<String> path = new ArrayList<>(); String at = target;
        while (at != null) { path.add(at); if (at.equals(source)) break; at = prev.get(at); }
        Collections.reverse(path); return (!path.isEmpty() && path.get(0).equals(source)) ? path : Collections.emptyList();
    }

    static void loadSampleData(Graph graph) {
        String[][] data = {
            {"UIO","GYE","45"},{"UIO","CUE","60"},{"GYE","CUE","40"},{"CUE","MDE","80"},
            {"GYE","MDE","120"},{"UIO","MDE","200"},{"MDE","UIO","190"},{"CUE","GYE","38"}
        };
        for (String[] row : data) graph.addRoute(row[0], row[1], Double.parseDouble(row[2]));
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(); loadSampleData(graph);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== BUSCADOR DE VUELOS BARATOS (Simulación) ===");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nOpciones:");
            System.out.println("1) Mostrar aeropuertos");
            System.out.println("2) Mostrar rutas");
            System.out.println("3) Mostrar lista de adyacencia");
            System.out.println("4) Buscar ruta más barata (Dijkstra)");
            System.out.println("5) Salir");
            System.out.print("Seleccione opción: ");
            String opt = br.readLine();
            switch (opt) {
                case "1":
                    System.out.println("Aeropuertos:");
                    for (String a : graph.getAirports()) System.out.println("- " + a);
                    break;
                case "2": graph.printRoutes(); break;
                case "3": graph.printAdjacency(); break;
                case "4":
                    System.out.print("Origen (ej: UIO): "); String origen = br.readLine().trim().toUpperCase();
                    System.out.print("Destino (ej: MDE): "); String destino = br.readLine().trim().toUpperCase();
                    long t0 = System.nanoTime(); PathResult res = dijkstra(graph, origen); long t1 = System.nanoTime();
                    double timeMs = (t1 - t0) / 1_000_000.0;
                    Double cost = res.dist.getOrDefault(destino, Double.POSITIVE_INFINITY);
                    if (cost == null || Double.isInfinite(cost)) System.out.println("No existe ruta de " + origen + " a " + destino + " o aeropuerto desconocido.");
                    else {
                        List<String> path = reconstructPath(res.prev, origen, destino);
                        if (path.isEmpty()) System.out.println("No existe ruta conectada entre ambos aeropuertos.");
                        else {
                            System.out.println("Ruta más barata encontrada:");
                            System.out.println(String.join(" -> ", path));
                            System.out.printf("Costo total: %.2f%n", cost);
                            System.out.printf("Tiempo ejecución (Dijkstra): %.4f ms%n", timeMs);
                        }
                    }
                    break;
                case "5": exit = true; System.out.println("Saliendo. ¡Éxitos en tu PCE!"); break;
                default: System.out.println("Opción no válida.");
            }
        }
    }
}
