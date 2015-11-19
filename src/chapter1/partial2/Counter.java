package chapter1.partial2;

/**
 * Counter
 */
public class Counter
{
    private int count;
    private String name;

    public Counter(String id)
    {
        name = id;
        count = 0;
    }

    public void increment()
    {
        ++count;
    }

    public int tally()
    {
        return count;
    }

    public String toString()
    {
        return count + " " + name;
    }
}
