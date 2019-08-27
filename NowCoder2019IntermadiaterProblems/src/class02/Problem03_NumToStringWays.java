package class02;

public class Problem03_NumToStringWays {

	public static int convertWays(int num) {
		if (num < 1) {
			return 0;
		}
		return process(String.valueOf(num).toCharArray(), 0);
	}

	// 0...index-1 已经转化完毕，并且转换正确
	// str[index....] 能转化多少种有效的字符串表达
	public static int process(char[] str, int index) {
		if (index == str.length) {
			return 1;
		}
		//index 及其后续是还有数字字符的
		// 0...
		if (str[index] == '0') {
			return 0;
		}
		// index 及其后续是还有数字字符的，且不以0开头，以1~9开头
		int res = process(str, index + 1); // 做了一个决定，就让str[index]自己作为一个部分
		if (index == str.length - 1) {
			return res;
		}
		// index+1 依然没越界
		// index 和index+1 共同构成一个部分<27
		if (((str[index] - '0') * 10 + str[index + 1] - '0') < 27) {
			res += process(str, index + 2);
		}
		return res;
	}

	// 只有一个可变参数，可以用一个一维数组解决， 如果可变参数2个，就需要二维数组解决。 三个可变就需要三维数组。

	// 还能简化——动态规划
	public static int dpways(int num) {
		if (num < 1) {
			return 0;
		}
		char[] str = String.valueOf(num).toCharArray();
		int[] dp = new int[str.length + 1];
		dp[str.length] = 1; //根据递归过程的base case
		dp[str.length - 1] = str[str.length - 1] == '0' ? 0 : 1;
		// 递归函数怎么试，动态规划怎么填写。
		for (int i = str.length - 2; i >= 0; i--) {
			if (str[i] == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i + 1]
						+ (((str[i] - '0') * 10 + str[i + 1] - '0') < 27 ? dp[i + 2]
								: 0);
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		int test = 111143311;
		System.out.println(convertWays(test));
		System.out.println(dpways(test));
	}

}
