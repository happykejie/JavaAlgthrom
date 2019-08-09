package base.grammar;
import  java.math.*;
import  java.lang.*;
public class JavaNumberandMath {

    public static void main(String args[]){
        Integer x = 5;
        x =  x + 10;
        System.out.println(x);
        // 返回 byte 原生数据类型
        System.out.println( x.byteValue() );

        // 返回 double 原生数据类型
        System.out.println(x.doubleValue());

        // 返回 long 原生数据类型
        System.out.println( x.longValue() );


        System.out.println(x.toString());
        System.out.println(Integer.toString(12));

        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);
    }


    public void test(){

        int x =Integer.parseInt("9");
        double c = Double.parseDouble("5");
        int b = Integer.parseInt("444",16);

        System.out.println(x);
        System.out.println(c);
        System.out.println(b);

        Integer a = -8;
        double d = -100;
        float f = -90;

        System.out.println(Math.abs(a));
        System.out.println(Math.abs(d));
        System.out.println(Math.abs(f));
    }

    /**
     * round() 方法返回一个最接近的 int、long 型值，四舍五入。
     *
     * round 表示"四舍五入"，算法为Math.floor(x+0.5) ，即将原来的数字加上 0.5 后再向下取整
     * 所以 Math.round(11.5) 的结果为 12，Math.round(-11.5) 的结果为 -11。
     * */

    public  void  test1()
    {
        System.out.println(Math.min(12.123, 12.456));

//        exp() 方法用于返回自然数底数e的参数次方。
        double x = 11.635;
        double y = 2.76;

        System.out.printf("e 的值为 %.4f%n", Math.E);
        System.out.printf("exp(%.3f) 为 %.3f%n", x, Math.exp(x));
//log() 方法用于返回参数的自然数底数的对数值。
        System.out.printf("log(%.3f) 为 %.3f%n", x, Math.log(x));
//pow() 方法用于返回第一个参数的第二个参数次方。
        System.out.printf("pow(%.3f, %.3f) 为 %.3f%n", x, y, Math.pow(x, y));
//        sqrt() 方法用于返回参数的算术平方根。
        System.out.printf("sqrt(%.3f) 为 %.3f%n", x, Math.sqrt(x));
    }

    public void test2()
    {
        double degrees = 45.0;
//        toDegrees() 方法用于将参数转化为角度。
        double radians = Math.toRadians(degrees);

        System.out.format("pi 的值为 %.4f%n", Math.PI);
        System.out.format("%.1f 度的正弦值为 %.4f%n", degrees, Math.sin(radians));

        System.out.format("%.1f 度的余弦值为 %.4f%n", degrees, Math.cos(radians));
        System.out.format("%.1f 度的正切值是 %.4f%n", degrees, Math.tan(radians));

        double x = 45.0;
        double y = 30.0;
        //toDegrees() 方法用于将参数转化为角度。
        System.out.println( Math.toDegrees(x) );
        System.out.println( Math.toDegrees(y) );

//        random() 方法用于返回一个随机数，随机数范围为 0.0 =< Math.random < 1.0。
        System.out.println( Math.random() );
    }

}
