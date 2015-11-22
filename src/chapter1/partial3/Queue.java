package chapter1.partial3;

import libs.StdIn;
import libs.StdOut;

import java.util.Iterator;

/**
 * Queue. Implementation with linked list
 */
public class Queue<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) last = null;
        N--;

        return  item;
    }

    public int size()
    {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public Item next() {
            Item next = current.item;
            current = current.next;
            return next;
        }

        public boolean hasNext() {
            return current.next != null;
        }
    }

    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (item.equals("-")) {
                StdOut.print(q.dequeue() + " ");
            } else if (!StdIn.isEmpty()) {
                q.enqueue(item);
            }

            StdOut.println("Queue size - " + q.size());
        }
    }
}
