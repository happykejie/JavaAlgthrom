package BATAlgthromInterView.暴力递归;

public class 找零钱问题 {
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if(index == arr.length)
            res = aim == 0 ? 1 : 0;
        else {
            for(int i = 0; i * arr[index] <= aim; i++) {
                res += process1(arr, index + 1, aim - i * arr[index]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] arr = {1,2,5};
        System.out.println(process1(arr, 0, 20));
    }
}
