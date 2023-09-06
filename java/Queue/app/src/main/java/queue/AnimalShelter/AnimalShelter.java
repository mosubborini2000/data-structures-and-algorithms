package queue.AnimalShelter;

import queue.Queue;

public class AnimalShelter {
    private Queue<Animal> catQueue;
    private Queue<Animal> dogQueue;

    public AnimalShelter() {
        catQueue = new Queue<>();
        dogQueue = new Queue<>();
    }

    public void enqueue(Animal animal) {
        if (animal.getSpecies().equalsIgnoreCase("cat")) {
            catQueue.enqueue(animal);
        } else if (animal.getSpecies().equalsIgnoreCase("dog")) {
            dogQueue.enqueue(animal);
        }
    }

    public Animal dequeue(String pref) throws Exception {
        if (pref.equalsIgnoreCase("cat") && !catQueue.isEmpty()) {
            return catQueue.dequeue();
        } else if (pref.equalsIgnoreCase("dog") && !dogQueue.isEmpty()) {
            return dogQueue.dequeue();
        }
        return null;
}}
