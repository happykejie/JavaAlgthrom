package com.DJ;

import java.util.HashMap;
import java.util.Scanner;


public class DJ02 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            HashMap<String, String> map = new HashMap<>();
            String[] tests = new String[M];

            for (int i = 0; i < N; i++) {
                String s1 = sc.next();
                String s2 = sc.next();
                map.put(s1, s2);
            }
            for(int i = 0; i < M; i++) {
                String s1 = sc.next();
                tests[i] = s1;
            }
            for(String s : tests){
                String string = map.get(s);
                System.out.println(string);
            }
        }
    }


}
