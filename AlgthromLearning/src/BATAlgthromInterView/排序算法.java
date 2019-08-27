package BATAlgthromInterView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 排序算法 {

    public  static  void  main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一串需要排序的数字：");

        ArrayList<Integer> arrayList = new ArrayList<>();

        String intstr = sc.nextLine();

        String[] nums = intstr.split(" ");

        int[] arr = new int[nums.length];

        for(int i=0; i<nums.length;i++)
        {
            arr[i] = Integer.parseInt(nums[i]);
        }

        //系统内置排序
        //Arrays.sort(arr);
        //选择排序
        selectedsort(arr);

        for(int j=0;j<arr.length;j++) {
            System.out.print(" "+arr[j]);
        }



    }


    // 选择排序的实现
    public  static  void  selectedsort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                // 遍历查找剩余最小的值
                for (int j = i + 1; j < arr.length; j++) {
                    minIndex = arr[j] < arr[minIndex] ? j : minIndex;
                }
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
