package chapter1.partial2;

import libs.StdOut;
import libs.StdRandom;

/**
 * Client for type Counter, emulating T flip a coin
 * Flips
 */
public class listing1
{
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        }

        StdOut.println(heads);
        StdOut.println(tails);

        int d = heads.tally() - tails.tally();
        StdOut.println("difference - " + Math.abs(d));
    }
}
