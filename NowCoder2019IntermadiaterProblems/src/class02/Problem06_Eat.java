package class02;

public class Problem06_Eat {


	//暴力统计方式
	public  static  String winner1(int n){
		// 0 1  2   3    4
		//后 先 后 先 先
		if(n<5)
		{
			return (n==0||n==2)?"后手":"先手";
		}
		int base =1;
		while (base <= n)
		{
			// 当前一共n份
			if(winner1(n-base).equals("后手"))
			{
				return "先手";
			}
			if(base>n/4) //防止base*n 之后超过n,也防止整数溢出
			{
				break;
			}
			base *= 4;
		}
		return "后手";
	}

	//运行样本，观察最暴力的实现方式有没有规律可循
	public  static  void main(String[] args)
	{
		for(int i=0; i<=50;i++){
			System.out.println(i+":"+winner1(i));
		}
	}

	// 通过以上发现以下规律， 直接得到结果。
	public static void printWinner(int n) {
		if (n % 5 == 0 || n % 5 == 2) {
			System.out.println("yang");
		} else {
			System.out.println("niu");
		}
	}

}
