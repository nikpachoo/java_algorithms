package chapter1;

import libs.StdRandom;

/**
 * exercise 3 from chapter 1 partial 1
 */
public class _p1e11 {
    private static String toFormat(String val)
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

    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        boolean[][] logicMatrix = new boolean[M][N];

        for(int i = 0; i < logicMatrix.length; i++)
        {
            for (int j = 0; j < logicMatrix[i].length; j++)
            {
                logicMatrix[i][j] = StdRandom.bernoulli();
            }
        }

        printMatrix(logicMatrix);
    }
}
