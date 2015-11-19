package chapter1.partial1;

/**
 * exercise 13 from chapter 1 partial 1
 */
public class exercise13 extends exercise11 {
    private static void printMatrixTransposition(boolean[][] arr)
    {
        String numberColumns = toFormat(" ");
        String matrix = "";

        boolean progress = true;
        int index = 0;

        while (progress) {
            for (int i = 0; i < arr.length; i++)
            {
                if (i == 0) matrix += toFormat("" + (index + 1));
                if (index == 0) numberColumns += toFormat("" + (i + 1));

                matrix += toFormat(arr[i][index] ? "*" : " ");

                if (i == arr.length - 1) matrix += '\n';

                if (i == arr.length - 1  && index == arr[i].length - 1) progress = false;
            }

            ++index;
        }

        System.out.println(numberColumns);
        System.out.println(matrix);
    }

    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        boolean[][] boolMatrix = getRandomBooleanMatrix(M, N);
        printMatrixTransposition(boolMatrix);
    }
}
