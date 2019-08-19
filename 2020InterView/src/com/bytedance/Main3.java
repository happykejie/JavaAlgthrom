package com.bytedance;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arrayOri = new int[a];
        int[] array = new int[2];
        for (int i = 0; i < a; i++) {
            int nextInt1 = in.nextInt();
            int nextInt2 = in.nextInt();
            arrayOri[i] = nextInt1 * 60 + nextInt2;
        }
        array[0] = in.nextInt();
        int nextInt1 = in.nextInt();
        int nextInt2 = in.nextInt();
        array[1] = nextInt1 * 60 + nextInt2;
        int key = array[1] - array[0];

        Arrays.sort(arrayOri);

        int res = fun(arrayOri, key);

        if (res != -1) {
            int temp = arrayOri[res];
            int t1 = temp / 60;
            int t2 = temp % 60;
            System.out.println(t1 + " " + t2);
        }

    }
    public static int fun(int[] arrayOri, int key) {
        int left = 0;
        int right = arrayOri.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arrayOri[mid] == key) {
                return mid;
            } else if (key < arrayOri[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

}