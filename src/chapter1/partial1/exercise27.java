package chapter1.partial1;

import libs.StdOut;
import libs.Stopwatch;

import java.util.HashMap;

/**
 * exercise 27 from chapter 1 partial 1
 *
 * Пусть имеется 'n' независимых наблюдений
 * с вероятностью 'p' успеха в каждом.
 * Вычисляется вероятность B(m|n,p) того, что число успехов заключено
 * между 0 и 'm' (включительно), т.е. сумму биномиальных вероятностей от 0 до m
 */
public class exercise27 {
    public static HashMap<String, Double> cache = new HashMap<String, Double>();

    public static double binominal_slow (int N, int k, double p)
    {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binominal_slow(N - 1, k, p) + p * binominal_slow(N - 1, k - 1, p);
    }

    public static double binominal (int N, int k, double p)
    {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;

        String nameFirstExp = "f_" + (N - 1) + "" + k;
        String nameSecondExp =  "s_" + (N - 1) + "" + (k - 1);

        if(!cache.containsKey(nameFirstExp)) {
            cache.put(nameFirstExp, binominal(N - 1, k, p));
        }

        if(!cache.containsKey(nameSecondExp)) {
            cache.put(nameSecondExp, binominal(N - 1, k - 1, p));
        }

        return (1.0 - p) * cache.get(nameFirstExp) + p * cache.get(nameSecondExp);
    }

    public static void main (String[] args)
    {
        Stopwatch timer = new Stopwatch();
        double start = timer.elapsedTime();
        StdOut.println(binominal_slow(50, 10, 0.5));
        StdOut.println("duration: " + (timer.elapsedTime() - start));

        timer = new Stopwatch();
        start = timer.elapsedTime();
        StdOut.println(binominal(50, 10, 0.5));
        StdOut.println("duration: " + (timer.elapsedTime() - start));
    }
}
