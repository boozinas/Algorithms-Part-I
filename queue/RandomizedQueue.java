
/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private Node<Item> randomNode;   // random node
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return (size == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("input must be not null");
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        last.previous = null;
        if (isEmpty()) first = last;
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        size++;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item fuera = null;
        int random = (int) (Math.random() * (size)) + 1;
        if (random == 1) {
            fuera = first.item;
            size--;
            if (isEmpty()) {
                first = null;
                last = null;
            }
            else {
                first = first.next;
                first.previous = null;
            }
            return fuera;
        }
        else if (random == size) {
            fuera = last.item;
            size--;
            if (isEmpty()) {
                first = null;
                last = null;
            }
            else {
                last = last.previous;
                last.next = null;
            }
            return fuera;
        }
        randomNode = first;
        for (int i = 2; i <= random; i++) {
            randomNode = randomNode.next;
        }
        fuera = randomNode.item;
        randomNode.next.previous = randomNode.previous;
        randomNode.previous.next = randomNode.next;
        size--;
        return fuera;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item fuera = null;
        int random = (int) (Math.random() * (size));
        if (random == 1) {
            fuera = first.item;
            return fuera;
        }
        else if (random == size) {
            fuera = last.item;
            return fuera;
        }
        randomNode = first;
        for (int i = 2; i < random; i++) {
            randomNode = randomNode.next;
        }
        fuera = randomNode.item;
        return fuera;

    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = null;
            int random = (int) (Math.random() * (size)) + 1;
            if (random == 1) {
                item = first.item;
                size--;
                if (isEmpty()) {
                    first = null;
                    last = null;
                }
                else {
                    first = first.next;
                    first.previous = null;
                }
                return item;
            }
            else if (random == size) {
                item = last.item;
                size--;
                if (isEmpty()) {
                    first = null;
                    last = null;
                }
                else {
                    last = last.previous;
                    last.next = null;
                }
                return item;
            }
            randomNode = first;
            for (int i = 2; i <= random; i++) {
                randomNode = randomNode.next;
            }
            item = randomNode.item;
            randomNode.next.previous = randomNode.previous;
            randomNode.previous.next = randomNode.next;
            size--;
            return item;
        }
    }

    // return an independent iterator over items in random order
    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomQueue = new RandomizedQueue<Integer>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        randomQueue.enqueue(5);
        randomQueue.enqueue(6);
        System.out.println("El tamano inicial: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
        System.out.println(randomQueue.dequeue().toString());
        System.out.println("El tamano: " + randomQueue.size);
    }

}
