package class01;

public class Code05_BitMap {

    public static  void  main(String[] args)
    {
        int[] arr = new int[10];// 4byte*8bit*10->320bits
        //arr[0]  0-31

        int i = 178;//想取得178个bit的状态
        int numIndex = 178/32;
        int bitindex = 178%31;

        // 拿到 178 位的状态
        int s = ((arr[numIndex]>>bitindex)&1);
        //请把178位的状态改为1
        arr[numIndex] = arr[numIndex] | (1<< (bitindex));

        i =178;//请把178位的状态改为0
        arr[numIndex] = arr[numIndex] &(~(1<<bitindex));

    }
}
