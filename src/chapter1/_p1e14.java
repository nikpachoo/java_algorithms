package chapter1;

import libs.StdRandom;

/**
 * exercise 14 from chapter 1 partial 1
 */
public class _p1e14 {
    private static double heron(int base)
    {
        int supposition = StdRandom.uniform(1, base / 2);
        return heron(base, supposition);
    }

    private static double heron(double base, double supp)
    {
        double res = 0.5 * (supp + base / supp);

        if (res != supp) return heron(base, res);
        else return res;
    }

    private static double sqrt(int base)
    {
        return heron(base);
    }

    private static int lg(int num)
    {
        double root = sqrt(num);
        return (int) root;
    }

    public static void main(String[] args)
    {
        int num = Integer.parseInt(args[0]);
        int res = lg(num);
        long testValue = Math.round(Math.sqrt(num));
        System.out.println("Result: " + res);
        System.out.println("Is equal " + testValue + ": " + (res == testValue));
    }
}
