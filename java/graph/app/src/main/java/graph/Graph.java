package graph;

import java.util.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>> {
    public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
    private int numberOfVertices = 0;

    public Graph(int maxNumberOfVertices) {
        adjacencyLists = new HashMap<>(maxNumberOfVertices);
    }

    public Vertex<T> addVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        adjacencyLists.put(vertex, new LinkedList<>());
        numberOfVertices++;
        return vertex;
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination) {
        addEdge(start, destination, 0);
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination, int weight) {
        if (!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
            throw new IllegalArgumentException("both vertices must be in the inside graph");
        }

        Edge<T> edge = new Edge<>(destination, weight);
        adjacencyLists.get(start).add(edge);
    }

    public List<Vertex<T>> getVertices() {
        return new LinkedList<>(adjacencyLists.keySet());
    }

    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
        if (!adjacencyLists.containsKey(vertex)) {
            return new LinkedList<>();
        }

        return new LinkedList<>(adjacencyLists.get(vertex));
    }

    public int size() {
        return numberOfVertices;
    }

    @Override
    public int compareTo(Graph<T> o) {
        throw new UnsupportedOperationException("Graph does not implement compareTo()");
    }

    public List<Vertex<T>> breadthFirst(Vertex<T> start) {
        List<Vertex<T>> visitedNodes = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();

        if (start != null && adjacencyLists.containsKey(start)) {
            queue.add(start);
            visitedNodes.add(start);

            while (!queue.isEmpty()) {
                Vertex<T> currentVertex = queue.poll();
                List<Edge<T>> neighbors = getNeighbors(currentVertex);

                for (Edge<T> edge : neighbors) {
                    Vertex<T> neighborVertex = edge.destination;
                    if (!visitedNodes.contains(neighborVertex)) {
                        queue.add(neighborVertex);
                        visitedNodes.add(neighborVertex);
                    }
                }
            }
        }
//        System.out.println("Breadth-First Traversal: " + visitedNodes);
        return visitedNodes;
    }


    ///////trip


    public static Integer businessTrip(Graph<String> graph, String[] cityNames) {
        if (cityNames == null || cityNames.length < 2) {
            return null; // Invalid input
        }

        int cost = 0;

        for (int i = 0; i < cityNames.length - 1; i++) {
            String startCityName = cityNames[i];
            String destinationCityName = cityNames[i + 1];

            Vertex<String> startVertex = findVertexByName(graph, startCityName);
            Vertex<String> destinationVertex = findVertexByName(graph, destinationCityName);

            if (startVertex == null || destinationVertex == null) {
                return null;
            }

            Edge<String> edge = findEdge(graph, startVertex, destinationVertex);

            if (edge == null) {
                return null;
            }

            cost += edge.weight;
        }

        return cost;
    }

    private static Vertex<String> findVertexByName(Graph<String> graph, String cityName) {
        for (Vertex<String> vertex : graph.adjacencyLists.keySet()) {
            if (vertex.value.equals(cityName)) {
                return vertex;
            }
        }
        return null;
    }

    private static Edge<String> findEdge(Graph<String> graph, Vertex<String> start, Vertex<String> destination) {
        List<Edge<String>> edges = graph.adjacencyLists.get(start);

        for (Edge<String> edge : edges) {
            if (edge.destination.equals(destination)) {
                return edge;
            }
        }
        return null;
    }
    /////////////38

    public List<Vertex<T>> depthFirst(Vertex<T> start) {
        List<Vertex<T>> visited = new ArrayList<>();
        Set<Vertex<T>> toSet = new HashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();

        if (start != null && adjacencyLists.containsKey(start)) {
            stack.push(start);

            while (!stack.isEmpty()) {
                Vertex<T> currentVertex = stack.pop();

                if (!toSet.contains(currentVertex)) {
                    visited.add(currentVertex);
                    toSet.add(currentVertex);

                    List<Edge<T>> neighbors = getNeighbors(currentVertex);
                    for (Edge<T> edge : neighbors) {
                        Vertex<T> neighborVertex = edge.destination;
                        stack.push(neighborVertex);
                    }}}}
//        System.out.println("depth: " + visited);
        return visited;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyLists=" + adjacencyLists +
                ", numberOfVertices=" + numberOfVertices +
                '}';
    }
}
