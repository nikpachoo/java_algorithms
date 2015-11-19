package chapter1.partial1;

import libs.StdIn;
import libs.StdOut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * exercise 21 from chapter 1 partial 1
 */
public class exercise21 {
    static final int tableColumnsLength = 4;
    static String[][] table = new String[0][tableColumnsLength];
    static int[] tableColumnSize = new int[tableColumnsLength];

    private static void parseRow(String row)
    {
        Pattern namePattern = Pattern.compile("(\\w+) (\\d+) (\\d+)");
        Matcher matcher = namePattern.matcher(row);

        if (matcher.find()) {
            String[][] extTable = new String[table.length + 1][tableColumnsLength];

            for (int i = 0; i < table.length; i++) {
                extTable[i] = table[i];
            }

            String diff = String.format("%.2f", (float) Integer.parseInt(matcher.group(2)) / Integer.parseInt(matcher.group(3)));
            String name = matcher.group(1);
            String firstCount = matcher.group(2);
            String secondCount = matcher.group(3);
            String[] lastItem = extTable[extTable.length - 1];

            lastItem[0] = name;
            lastItem[1] = firstCount;
            lastItem[2] = secondCount;
            lastItem[3] = diff;

            table = extTable;

            int[] currentColumnsSize = {name.length(), firstCount.length(), secondCount.length(), diff.length()};
            setColumnsSize(currentColumnsSize);
        }
    }

    private static void printTable()
    {
        String printedTable = "\n";

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < tableColumnsLength; j++) {
                printedTable += alignColumn(table[i][j], tableColumnSize[j]) + "|";
            }

            printedTable += "\n";
        }

        StdOut.print(printedTable);
    }

    private static String alignColumn (String text, int size) {
        while (text.length() < size) text+= " ";
        return " " + text + " ";
    }

    private static void setColumnsSize(int[] currentColumnsSize)
    {
        for (int i = 0; i < tableColumnSize.length; i++) {
            tableColumnSize[i] = tableColumnSize[i] > currentColumnsSize[i] ? tableColumnSize[i] : currentColumnsSize[i];
        }
    }

    public static void main (String[] args)
    {
        while (!StdIn.isEmpty()) {
            String row = StdIn.readLine();
            parseRow(row);
        }

        printTable();
    }
}
