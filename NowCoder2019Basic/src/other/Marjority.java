package other;
//寻找多数元素算法练习
public class Marjority {

    public  static  void main(String[] args)
    {
        int a[] = {1, 2, 5, 5, 5, 5, 5, 1, 3};    //含有多数元素的数组
        int b[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};    //不含有多数元素的数组
        Marjority m1 = new Marjority(a.length, a);
        Marjority m2 = new Marjority(b.length, b);
        System.out.println(m1.Mar());
        System.out.println(m2.Mar());
    }

    private int a[] = new int[50];    //定义存放数据的数组
    public int length;        //定义数组长度
    public Marjority(int length,int a[])
    {
        for(int i=1;i<=length;i++)
            this.a[i] = a[i-1];    //转存数组
        /*需要注意的是，我们的算法中数组下标从1开始
         * 但java存储时的数组下标从0开始，所以转存时下标需-1*/
        this.length = length;
    }
    //寻找多数元素，若存在则输出，不存在返回-99999
    public int Mar()
    {
        int c = candidate(1);
        //进行多数元素查询
        int count = 0;
        for(int j=1;j<=length;j++)
            if(a[j] == c)
                count++;    //计算该元素在数组中出现的次数
        if(count > length/2)    //判断出现次数是否大于长度的一半
            return c;    //大于则有多数元素，返回其值
        else return -9999;    //不大于则没有多数元素，返回-9999
    }
    public int candidate(int n)
    {
        int j = n, c = a[n], count = 1;
        //声明数组索引，当前元素值，计数器
        while(j<length && count>0)
        {
            j++;    //指针向后移动一位
            if(a[j] == c)    //若下一位与当前元素相同，计数器增加
                count++;
            else count--;    //否则计数器减少
            /*这里不太好理解的是计数器的作用，
             * 实际上计数器是一个筛选作用，
             * 当当前元素重复出现的次数太少时，
             * 将这个元素剔除出候选*/
        }
        if(j == length)
            return c;    /*当指针指向最后一个元素时，
                           表示当前元素出现次数足够多，
                           返回其值*/
        else return candidate(j+1);    //否则继续向后遍历
    }
}


