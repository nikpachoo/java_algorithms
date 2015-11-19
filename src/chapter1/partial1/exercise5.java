package chapter1.partial1;

import libs.In;
import libs.StdOut;

/**
 * exercise 5 from chapter 1 partial 1
 */
public class exercise5 {
    public static void main(String[] args)
    {
        double[] arr = new In(args[0]).readAllDoubles();
        int i = 0;
        boolean isBelongsToInterval = true;

        while (i < arr.length)
        {
            if (!(0 < arr[i] && arr[i] < 1)) {
                isBelongsToInterval = false;
                break;
            }

            i++;
        }

        StdOut.println(isBelongsToInterval);
    }
}
