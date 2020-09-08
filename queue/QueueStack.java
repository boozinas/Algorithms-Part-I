/* *****************************************************************************
 *  Name:              MARIA BELEN MEDINA JUAREZ
 *  Coursera User ID: m3o1525o3908c@mooc-cuaed.unam.mx
 *  Last modified:     Agosto 21, 2020
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;

public class QueueStack {
    Stack<String> pila_sacar;
    Stack<String> pila_meter;

    public QueueStack() {
        pila_sacar = new Stack<String>();
        pila_meter = new Stack<String>();
    }

    private void push(Stack<String> pila, String cadena) {
        pila.push(cadena);
    }

    private void pop(Stack<String> pila) {
        pila.pop();
    }

    public void queue(String cadena) {
        push(pila_meter, cadena);
    }

    public String dequeue() {
        if (pila_sacar.isEmpty()) {
            while (!pila_meter.isEmpty()) {
                push(pila_sacar, pila_meter.pop());
            }
            return pila_sacar.pop();
        }
        else {
            return pila_sacar.pop();
        }
    }

    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.queue("Hola");
        queue.queue("Como");
        queue.queue("estas");
        queue.queue("?");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.queue("estas");
        System.out.println(queue.dequeue());
    }
}
