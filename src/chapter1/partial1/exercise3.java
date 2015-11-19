package chapter1.partial1;

import libs.In;
import libs.StdOut;

/**
 * exercise 3 from chapter 1 partial 1
 */
public class exercise3 {
    public static String compare(int[] arr)
    {
        int i = 0;
        boolean isEqual = true;

        while (isEqual && i < arr.length - 1)
        {
            isEqual = (arr[i] == arr[i + 1]);
            ++i;
        }

        return isEqual ? "equal" : "not equal";
    }

    public static void main(String[] args)
    {
        int[] comparableList = In.readInts(args[0]);
        String isEquals = compare(comparableList);
        StdOut.println(isEquals);
    }
}
