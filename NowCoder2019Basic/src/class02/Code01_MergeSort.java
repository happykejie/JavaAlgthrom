package class02;

import java.util.Arrays;

public class Code01_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}

	public static void process(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		process(arr, l, mid);
		process(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	public static void merge(int[] arr, int L, int m, int R) {
		//辅助数组外排序
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L; // 指向左侧部分最左边
		int p2 = m + 1; // 执行右侧部分最左边
		while (p1 <= m && p2 <= R) { // 左侧没有越界，右侧也没有越界， 合并时谁小拷贝谁，相等时默认拷贝左，为了稳定性
			// 谁考虑了谁往下走， 肯定有一个先越界，则跳出，执行下面判断
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// p1 越界—— p1,p2 越界只会发生一个
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		// p2 越界
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
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
		mergeSort(arr);

//		return;
//
//		int testTime = 500000;
//		int maxSize = 100;
//		int maxValue = 100;
//		boolean succeed = true;
//		for (int i = 0; i < testTime; i++) {
//			int[] arr1 = generateRandomArray(maxSize, maxValue);
//			int[] arr2 = copyArray(arr1);
//			mergeSort(arr1);
//			comparator(arr2);
//			if (!isEqual(arr1, arr2)) {
//				succeed = false;
//				printArray(arr1);
//				printArray(arr2);
//				break;
//			}
//		}
//		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//		int[] arr = generateRandomArray(maxSize, maxValue);
//		printArray(arr);
//		mergeSort(arr);
		printArray(arr);

	}

}
