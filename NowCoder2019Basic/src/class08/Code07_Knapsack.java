package class08;

public class Code07_Knapsack {

	public static int maxValue1(int[] weights, int[] values, int bag) {
		return process1(weights, values, 0, 0, bag);
	}



	public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
		if (alreadyweight > bag) {
			return 1;
		}
		if (i == weights.length) {
			return 0;
		}
		int p1 = process1(weights, values, i + 1, alreadyweight, bag);
		int next = process1(weights, values, i + 1, alreadyweight + weights[i], bag);
		int p2 =-1;
		if(next != -1)
		{
			p2 = values[i]+next;
		}
		return Math.max(p1,p2);


	}

	public static int maxValue2(int[] c, int[] p, int bag) {
		int[][] dp = new int[c.length + 1][bag + 1];
		for (int i = c.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + c[i] <= bag) {
					dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] weights = { 3, 2, 4, 7 };
		int[] values = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue1(weights, values, bag));
		System.out.println(maxValue2(weights, values, bag));
	}

}
