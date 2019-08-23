package class08;

public class Code01_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

	public static void hanoi1(int n) {
		if (n > 0) {
			func1(n, "left", "right", "mid");
		}
	}

	// 1-N 圆盘目标是start -> end, other 是另外一个
	public static void func1(int N, String from, String to, String other) {
		if (N == 1) {
			System.out.println("move 1 from" + from + "to" + to);
		} else {
			func1(N - 1,from,other,to);
			System.out.println("Move"+N+"from"+from+"to"+to);
			func1(N - 1, other,to,from);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
