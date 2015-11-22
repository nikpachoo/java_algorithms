package chapter1.partial3;

import libs.StdIn;
import libs.StdOut;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack. Implementation with linked list
 */
public class LinkedListStack<Item>  implements Iterable<Item>
{
    private Node first;
    private int N;


    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(Item item)
    {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int size()
    {
        return N;
    }

    private class Node
    {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public boolean hasNext() {
            return current.next != null;
        }
    }

    public static void main (String[] args)
    {
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.println("Stack current size - " + s.size());
    }
}
