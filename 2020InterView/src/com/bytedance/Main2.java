package com.bytedance;

import  java.util.*;
public class Main2 {
    public  static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] intarr  = new int[N];
        for(int i=0; i<N;i++)
        {
            intarr[i]=sc.nextInt();
        }

        int min_index =0;
        int min_value =10000;
        int[] salary = new int[N];

        for(int i=0; i<intarr.length;i++)
        {
            int val = intarr[i];
            if(val<min_value)
            {
                min_index = i;
                min_value =val;
            }
        }

        List<Integer> min_indexsarr = new ArrayList<Integer>();

        for(int i=0; i<intarr.length;i++)
        {
            int j =0;
            int min_val = intarr[min_index];
            if(min_val == intarr[i])
            {
               min_indexsarr.add(i);
               j++;
            }
        }

        if(min_indexsarr.size()>1)
        {
            int first_min_index =min_indexsarr.get(0);
            int second_min_index = min_indexsarr.get(0);

            salary[first_min_index] =100;
            int left = first_min_index -1;
            int right = first_min_index +1;

            while (left >= 0) {
                if (intarr[left] < intarr[left + 1]) {
                    salary[left] = salary[left + 1] - 100;
                }
                if (intarr[left] == intarr[left + 1]) {
                    salary[left] = salary[left + 1];
                }
                if (intarr[left] > intarr[left + 1]) {
                    salary[left] = salary[left + 1] + 100;
                }
                left -= 1;
            }

            while (right < second_min_index) {
                if (intarr[right] < intarr[right - 1]) {
                    salary[right] -= 100;
                }
                if (intarr[right] == intarr[right - 1]) {
                    salary[right] = salary[right - 1];

                }
                if (intarr[right] > intarr[right - 1]) {
                    salary[right] = salary[right - 1] + 100;
                }
                right += 1;
            }

            int second_right =second_min_index+1;

            salary[second_min_index]=100;

            while (second_right<N)
            {
                if(intarr[second_right]==intarr[second_min_index])
                {
                    salary[second_right]=100;
                    second_right +=1;
                }
                if(intarr[second_right]<intarr[second_right+1])
                {
                    salary[second_right+1]+=100;
                    second_right +=1;
                }
            }

        }
        else {


//        最小奖励
            salary[min_index] = 100;

            int left = min_index - 1;
            int right = min_index + 1;

            while (left >= 0) {
                if (intarr[left] < intarr[left + 1]) {
                    salary[left] = salary[left + 1] - 100;
                }
                if (intarr[left] == intarr[left + 1]) {
                    salary[left] = salary[left + 1];
                }
                if (intarr[left] > intarr[left + 1]) {
                    salary[left] = salary[left + 1] + 100;
                }
                left -= 1;
            }

            while (right < N) {
                if (intarr[right] < intarr[right - 1]) {
                    salary[right] -= 100;
                }
                if (intarr[right] == intarr[right - 1]) {
                    salary[right] = salary[right - 1];

                }
                if (intarr[right] > intarr[right - 1]) {
                    salary[right] = salary[right - 1] + 100;
                }
                right += 1;
            }
        }


        int sum= 0;
        for(int i=0; i<salary.length;i++)
        {
            sum +=salary[i];
        }

        System.out.println(sum);


    }
}
