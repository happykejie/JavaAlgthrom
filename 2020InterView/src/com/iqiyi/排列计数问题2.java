import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 一个序列只有0，1组成， 序列长度为N，1-N构成排列Pi到Pn. 若果1<i=<N
 * 若 对应的 i=0; 则pi<pi+1; i=1;则pi>pi+1;, 如果生成的全排列满足这样的条件。即为符合要求的排列。
 * 求满足搜索的全排列
 *
 * */
public class 排列计数问题2 {

    public static int[] byteArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        byteArr = new int[k - 1];
        for(int i = 0 ; i < k - 1 ; i++){
            byteArr[i] = sc.nextInt();
        }
        int[] numArr = new int[k];
        for(int i = 0 ; i < k ; i++){
            numArr[i] = i + 1;
        }
        Arrays.sort(numArr);
        int n = factorrail(k);

        long count = 0L;
        if(match(byteArr, numArr)){
            count++;
        }
        for (int i = 2; i <= n; i++) {
            numArr = findNearestNum(numArr);
            if(match(byteArr, numArr)){
                count++;
            }
        }
        System.out.println(count % (10L * 10L * 10L * 10L * 10L * 10L  * 10L * 10L * 10L + 7L));
    }

    private static int factorrail(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorrail(n - 1);
        }
    }

    public static int[] findNearestNum(int[] nums) {

        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int index = findTransferPoint(numsCopy);
        if (index == 0) {
            return null;
        }
        exchange(numsCopy, index);
        reverse(numsCopy, index);
        return numsCopy;
    }

    private static int findTransferPoint(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }


    private static int[] exchange(int[] nums, int index) {
        int head = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > head) {
                nums[index - 1] = nums[i];
                nums[i] = head;
                break;
            }
        }

        return nums;
    }


    private static int[] reverse(int[] nums, int index) {
        for (int i = index, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static boolean match(int[] byteArr, int[] temp){
        boolean flag = true;
        for(int i = 0 ; i < byteArr.length ; i++){
            if(byteArr[i] == 0 && temp[i] >= temp[i + 1]){
                flag = false;
                break;
            }
            if(byteArr[i] == 1 && temp[i] <= temp[i + 1]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}