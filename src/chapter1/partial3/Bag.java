package chapter1.partial3;

import libs.StdIn;
import libs.StdOut;

import java.util.Iterator;

/**
 * Bag. Implementation wiwh linked list
 */
public class Bag<Item> implements Iterable<Item>
{
    private int N;
    private Node first;
    private Node last;

    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;

        N++;
    }

    private boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        Node current = first;

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public boolean hasNext()
        {
            return current.next != null;
        }
    }

    public static void main(String[] args)
    {
        Bag <String>b = new Bag<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            b.add(item);

            StdOut.println("Bag size is -" + b.size());
        }

    }
}
