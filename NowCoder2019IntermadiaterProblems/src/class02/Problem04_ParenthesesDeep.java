package class02;

public class Problem04_ParenthesesDeep {

	public static boolean isValid(char[] str) {
		if (str == null || str.equals("")) {
			return false;
		}
		int status = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != ')' && str[i] != '(') {
				return false;
			}
			if (str[i] == ')' && --status < 0) {
				return false;
			}
			if (str[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}

	public static int deep(String s) {
		char[] str = s.toCharArray();
		if (!isValid(str)) {
			return 0;
		}
		int count = 0;
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				max = Math.max(max, ++count);
			} else {
				count--;
			}
		}
		return max;
	}

	///
	/**
	 * 求最长有序括号字符串子串——这类求子串，子树问题——都可以任何字符结尾的情况下，符合要求的答案一定在其中。
	 * （或者以每个字符开头计算的符合要求的答案）。
	 *
	 * 目的在于使用动态规划，d[i]位置可以通过d[i-1]或者d[i+1]的结果来推断。 或者往前2，3，。。往后2，3。。得到d[i]
	 * 。这就是动态规划的基本构思方式。
	 * */
	public static int maxLength(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chas[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		String test = "((()))";
		System.out.println(deep(test));

	}

}
