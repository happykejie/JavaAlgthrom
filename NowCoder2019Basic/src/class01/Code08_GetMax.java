package class01;

public class Code08_GetMax {

	public  static  void main(String[] args)
	{
		int[] arr = {3,5,2,7,5};
		int max = getMax(arr);
		System.out.println(arr[0]+" ,"+arr[1]+" ,"+arr[2]+" ,"+arr[3]+" ,"+arr[4]+"max:"+max);
	}

	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return arr[L];
		}
		int mid = L + ((R - L) >> 1);
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rightMax);
	}

}
