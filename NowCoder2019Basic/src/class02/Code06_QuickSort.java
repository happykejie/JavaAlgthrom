package class02;

import java.util.Arrays;

public class Code06_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	// arr[1..r]排好序
	public static void quickSort(int[] arr, int L, int R) {
		int i,j,t,temp =0;
		if (L < R) {
			temp = arr[L]; // temp中存的就是基准数
			i=L;
			j=R;
			while (i!=j){
				//顺序很重要，要先从右边往左找
				while (arr[j]>temp && i < j)
				{
					j--;
				}
				//再从左边开始找
				while (arr[i]<=temp & i < j){
					i++;
				}

				//交换两个数在数组中的位置
				if(i < j) //当哨兵i和哨兵j 没有相遇时
				{
					t= arr[i];
					arr[i]= arr[j];
					arr[j]=t;
				}
			}

			//L和R 相遇，最终把基准数归为，划分左边小于都是小于等于基准数的，右边都是大于等于基准数的a
			arr[L] =arr[i];
			arr[i] =temp;

			quickSort(arr,L,i-1);
			quickSort(arr,i+1,R);

		}
	}
	 //这是一个处理arr[1..r]的函数
	//默认以arr[r] 做划分， arr[r]->p  <p  ==p >p
	//返回等于区域（左边界，右边界），所以返回一个长度为2的数组res，res[0] res[1]
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;// <区右边界
		int more = r; // >区左边界
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}
