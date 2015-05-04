package chapter1;

import libs.StdIn;
import libs.StdOut;
import libs.Stopwatch;

/**
 * exercise 19 from chapter 1 partial 1
 */
public class _p1e19 {
    static long[] cache = new long[0];

    public static long slowF(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long F(int N)
    {
        if (cache.length < N + 1) {
            long[] extendCache = new long[N + 1];

            for (int i = 0; i < cache.length; i++) {
                extendCache[i] = cache[i];
            }

            cache = extendCache;
        }

        return recursiveF(N);
    }

    private static long recursiveF(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;

        if (cache[N] > 0) return cache[N];
        cache[N - 1] = F(N - 1);
        cache[N - 2] = F(N - 2);
        cache[N] = cache[N - 1] + cache[N - 2];
        return cache[N];
    }

    public static void main(String[] args)
    {
        int size = Integer.parseInt(args[0]);
        Stopwatch timer = new Stopwatch();
        double start = timer.elapsedTime();

        for (int N = 0; N < size; N++)
            StdOut.println(F(N));

        StdOut.println("duration: " + (timer.elapsedTime() - start));
    }
}
