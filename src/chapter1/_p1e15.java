package chapter1;

import libs.In;
import libs.Out;
import libs.StdOut;

/**
 * exercise 15 from chapter 1 partial 1
 */
public class _p1e15 {
    private static int[] histogram(int[] a, int N)
    {
        int[] res = new int[N];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < N) res[a[i]] += 1;
        }

        return res;
    }

    public static void main(String[] args)
    {
        int[] histogramArr = new In(args[0]).readAllInts();
        int[] res = histogram(histogramArr, Integer.parseInt(args[1]));

        for (int i = 0; i < res.length; i++)
            StdOut.println(res[i] + " ");
    }
}
