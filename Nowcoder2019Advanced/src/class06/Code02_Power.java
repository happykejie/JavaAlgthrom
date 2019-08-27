package class06;

public class Code02_Power {

	// 判断一个数是2的幂
	public static boolean is2Power(int n) {

		return (n & (n - 1)) == 0;
	}

	//判断一个数是4的幂
	public static boolean is4Power(int n) {
		/// 在 1，3，5，7 位才是1            //0x5555555   ....1010101
		return (n & (n - 1)) != 0 && (n & 0x55555555) != 0;
	}

}
