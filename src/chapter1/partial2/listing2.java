package chapter1.partial2;

import libs.StdOut;
import libs.StdRandom;

/**
 * FlipsMax
 * Example for static method with objects arguments and returns value
 */
public class listing2 {
    public static Counter max(Counter x, Counter y)
    {
        if (x.tally() > y.tally()) return x;
        else return y;
    }

    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("talls");

        for (int t = 0; t < T; t++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();

        if (heads.tally() == tails.tally())
            StdOut.println("draw");
        else StdOut.println(max(heads, tails) + " wins");
    }
}
