package chapter1.partial1;

import libs.StdDraw;
import libs.StdRandom;

/**
 * exercise 32 from chapter 1 partial 1
 */
public class exercise32 {
    private static int quantityEntrance(double[] arr, double l, double r)
    {
        int q = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] >= l && arr[i] <= r) q++;
        }

        return q;
    }

    public static void histogram(double[] numbers, int countIntervals, double intervalFrom, double intervalTo)
    {
        double step = (intervalTo - intervalFrom) / (double) countIntervals;

        double l = intervalFrom;
        double r = l + step;
        double rw = step / 2;
        int maxY = 0;
        double[][] rectangle = new double[countIntervals][3];

        for (int i = 0; i < countIntervals; i++) {
            double x = (double) i / (double) countIntervals;
            double y = 0.05;
            double q = quantityEntrance(numbers, l, r);
            double rh = q / 2;
            maxY = (int) q > maxY ? (int) q : maxY;
            l = r;
            r = l + step;

            rectangle[i][0] = x + rw;
            rectangle[i][1] = y + rh;
            rectangle[i][2] = rh;
        }

        int scaleY = Integer.toString(maxY).length();
        scaleY = Integer.parseInt("1" + String.format("%0" + scaleY + "d", 0));
        StdDraw.setYscale(0, scaleY);

        for (int i = 0; i < rectangle.length; i++) {
            StdDraw.filledRectangle(rectangle[i][0], rectangle[i][1], rw, rectangle[i][2]);
        }
    }

    public static void main(String[] args)
    {
        double[] arr = new double[Integer.parseInt(args[0])];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform();
        }

        int N = Integer.parseInt(args[1]);
        double intervalFrom = Double.parseDouble(args[2]);
        double intervalTo = Double.parseDouble(args[3]);

        histogram(arr, N, intervalFrom, intervalTo);
    }
}
