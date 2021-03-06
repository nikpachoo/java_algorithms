package chapter1.partial2;

import libs.StdOut;
import libs.StdRandom;

/**
 * Client for type Counter, that modeling T trows a dice
 */
public class listing3 {
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES + 1];

        for (int i = 1; i <= SIDES; i++)
            rolls[i] = new Counter("выпадений " + i);

        for (int t = 0; t < T; t++)
        {
            int result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();

            for (int i = 1; i <= SIDES; i++)
                StdOut.println(rolls[i]);
        }
    }
}
