package class02;

import java.util.Arrays;

public class Code03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) { //O(N)
			heapInsert(arr, i); //O(logN)
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) { //O(N)
			heapify(arr, 0, size);//O(logN)
			swap(arr, 0, --size);//O(1)
		}
	}

//	某个数现在处在index位置，往上继续移动
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) /2);
			index = (index - 1)/2 ;
		}
	}

//	某个数在index位置，能否往下移动
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1; //左孩子的下标
		while (left < size) { //下方还有孩子的时候
			// 两个孩子中，谁的值大，把下标给largest
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//父和孩子之间，谁的值大，把下标给largest
			largest = arr[largest] > arr[index] ? largest : index;

			//最大节点就是父亲节点，不需要交互
			if (largest == index) {
				break;
			}
			// 最大孩子和父节点交互
			swap(arr, largest, index);
			//继续往下查看
			index = largest;
			left = index * 2 + 1;
		}
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

		int[] arr = {1,2,3,5,2,3};
		heapSort(arr);

//		int testTime = 500000;
//		int maxSize = 100;
//		int maxValue = 100;
//		boolean succeed = true;
//		for (int i = 0; i < testTime; i++) {
//			int[] arr1 = generateRandomArray(maxSize, maxValue);
//			int[] arr2 = copyArray(arr1);
//			heapSort(arr1);
//			comparator(arr2);
//			if (!isEqual(arr1, arr2)) {
//				succeed = false;
//				break;
//			}
//		}
//		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//		int[] arr = generateRandomArray(maxSize, maxValue);
//		printArray(arr);
//		heapSort(arr);
		printArray(arr);
	}

}
