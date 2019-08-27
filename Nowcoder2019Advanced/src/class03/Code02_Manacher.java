package class03;

public class Code02_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str); // 1221->#1#2#2#1#
		int[] pArr = new int[charArr.length];
		int C = -1; //中心
		int R = -1; // 回文右边界的再往右一个位置  最右的有效区是R-1 位置
		int max = Integer.MIN_VALUE; // 扩出来的最大值
		for (int i = 0; i != charArr.length; i++) { //每一个位置都求回文半径
			// i 至少得回文区域，给pArr[i]
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

			//每种情况都去扩
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break; // 情况2 和情况3 扩一次就会失败。
				}
			}
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
