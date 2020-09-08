/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;

    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("input must be not null");
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.previous = null;
        first.next = null;

        if (isEmpty()) {
            last = first;
        }
        else {
            first.next = oldFirst;
            oldFirst.previous = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("input must be not null");
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        last.previous = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item fuera = first.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.previous = null;
        } // to avoid loitering
        return fuera;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item fuera = last.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        } // to avoid loitering
        else {
            last = last.previous;
            last.next = null;
        }
        return fuera;
    }

    // return an iterator over items in order from front to back

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current = first;


        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> colados = new Deque<Integer>();
        System.out.println("Tamano: " + colados.size);
        colados.addLast(1);
        colados.addLast(2);
        colados.addLast(3);
        System.out.println("Tamano: " + colados.size);
        colados.addFirst(4);
        colados.addLast(5);
        colados.addFirst(6);
        System.out.println(colados.removeFirst());
        System.out.println("Tamano: " + colados.size);
        System.out.println(colados.removeLast());
        System.out.println(colados.removeFirst());
        System.out.println(colados.removeLast());
        System.out.println(colados.removeFirst());
        System.out.println("Tamano: " + colados.size);
        colados.addFirst(4);
        System.out.println(colados.removeFirst());
        System.out.println("Tamano: " + colados.size);
        System.out.println(colados.removeFirst());
        System.out.println("Tamano gg: " + colados.size);
        System.out.println(colados.removeLast());
        System.out.println("Tamano: " + colados.size);
    }

}

