package chapter1.partial1;

import libs.StdRandom;

/**
 * exercise 11 from chapter 1 partial 1
 */
public class exercise11 {
    protected static String toFormat(String val)
    {
        return "| " + val + " ";
    }

    private static void printMatrix(boolean[][] arr)
    {
        String numberColumns = toFormat(" ");
        String matrix = "";

        for (int i = 0; i < arr.length; i++)
        {
            matrix += toFormat("" + (i + 1));

            for (int j = 0; j < arr[i].length; j++)
            {
                if (i == 0) numberColumns += toFormat("" + (j + 1));

                matrix += toFormat(arr[i][j] ? "*" : " ");
            }

            matrix += '\n';
        }

        System.out.println(numberColumns);
        System.out.println(matrix);
    }

    protected static boolean[][] getRandomBooleanMatrix(int M, int N)
    {
        boolean[][] boolMatrix = new boolean[M][N];

        for(int i = 0; i < boolMatrix.length; i++)
        {
            for (int j = 0; j < boolMatrix[i].length; j++)
            {
                boolMatrix[i][j] = StdRandom.bernoulli();
            }
        }

        return boolMatrix;
    }

    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        boolean[][] boolMatrix = getRandomBooleanMatrix(M, N);
        printMatrix(boolMatrix);
    }
}
