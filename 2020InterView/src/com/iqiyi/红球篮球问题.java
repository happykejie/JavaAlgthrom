import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 红球N个，蓝球 M个， 三个 人A,b,c 以此取球，C取球只是参与，如果A,B 都没有获取红球，则 C获胜。 谁先取到红球，谁获取。 求A获胜的概率
 *
 * */

public class 红球篮球问题{

    public static void main(String[] args) {
        String inputStr = null;
        Scanner scanner = new Scanner(System.in);
        inputStr = scanner.nextLine();
        int[] inputInt = strToInt(inputStr);
        int red = inputInt[0];
        int blue = inputInt[1];
        double result = aGet(red, blue, 0, 1);
        DecimalFormat format = new DecimalFormat("0.00000");
        System.out.println(format.format(result));
    }

    private static double aGet(int n, int m, double result, double temp) {
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return temp;
        }
        //拿到红球的概率
        double get = ((double) n / (n + m)) * temp;
        return result + get + bGet(n, m - 1, result, temp - get);
    }

    private static double bGet(int n, int m, double result, double temp) {
        if (m == 0) {
            return 0;
        }
        //拿到红球的概率
        double get = ((double) n / (n + m)) * temp;
        return cGet(n, m - 1, result, temp - get);
    }

    private static double cGet(int n, int m, double result, double temp) {
        if (m == 0) {
            if (n == 1) {
                return 0;
            } else {
                return temp;
            }
        }
        //拿到红球的概率
        double get = ((double) n / (n + m)) * temp;
        return aGet(n, m - 1, result, temp - get) + aGet(n - 1, m, result, get);
    }

    private static int[] strToInt(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String[] strArray = str.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }
}