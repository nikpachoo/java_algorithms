package chapter1.partial3;

import libs.StdOut;

import java.util.Arrays;

/**
 * check balance for parentheses
 */
public class exercise4 {
    public static boolean checkCorrectParentheses(String exp)
    {
        LinkedListStack<String> parenthesesStack = new LinkedListStack<>();

        String[] opened = {"{", "[", "("};
        String[] closed = {"}", "]", ")"};

        for (int i = 0; i < exp.length(); i++) {
            String parentheses = "" + exp.charAt(i);

            if (Arrays.asList(opened).contains(parentheses)) {
                parenthesesStack.push(parentheses);
            } else {
                int indexClosed = Arrays.asList(closed).indexOf(parentheses);

                if (indexClosed != -1 && parenthesesStack.size() == 0) return false;

                if (indexClosed != -1) {
                    String lastOpen = parenthesesStack.pop();
                    int indexOpen = Arrays.asList(opened).indexOf(lastOpen);

                    if (indexClosed != indexOpen) {
                        return false;
                    }
                }
            }
        }

        return parenthesesStack.size() == 0;
    }

    public static void main(String[] args)
    {
        String expression = args[0];

        boolean isCorrectExp = checkCorrectParentheses(expression);

        StdOut.println(isCorrectExp);
    }
}
