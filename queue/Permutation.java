/* *****************************************************************************
 *  Name:              MARIA BELEN MEDINA JUAREZ
 *  Coursera User ID: m3o1525o3908c@mooc-cuaed.unam.mx
 *  Last modified:     Agosto 21, 2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(randomizedQueue.dequeue());
        }
    }
}
