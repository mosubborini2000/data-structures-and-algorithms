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

    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyLists=" + adjacencyLists +
                ", numberOfVertices=" + numberOfVertices +
                '}';
    }
}
