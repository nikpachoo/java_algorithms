package chapter1.partial1;

/**
 * exercise 5 from chapter 1 partial 1
 */
public class exercise9 {
    private static String toBinaryString(int num)
    {
        String res = "";

        do {
            int remain = num % 2;
            res = remain + res;
            num = num / 2;
        } while (num > 0);

        return res;
    }
    public static void main(String[] args)
    {
        int num = Integer.parseInt(args[0]);
        String res = toBinaryString(num);
        String systemRes = Integer.toBinaryString(num);
        System.out.println(res);
        System.out.println(systemRes);
        System.out.println(res.equals(systemRes));
    }
}
