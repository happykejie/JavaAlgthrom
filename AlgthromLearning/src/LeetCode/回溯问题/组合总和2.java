package LeetCode.回溯问题;
import java.util.*;
public class 组合总和2 {

    public  static  void  main(String[] args){

        int[] candidates ={10,1,2,7,6,1,5};
        int target =8;
        List<List<Integer>> result = combinationSum2(candidates,target);
        System.out.println(result);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(lists,list,candidates,target,0);
        return lists;

    }

    public static void backtrack(List<List<Integer>> lists,List<Integer> path,int[] candidates,int target,int start){

        if (target == 0){
            lists.add(path);
        }

        for(int i =start;i<candidates.length; i++){
            if(i !=0 &&candidates[i-1] ==candidates[i]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            path.add(candidates[i]);

            backtrack(lists,path,candidates, target - candidates[i],i+1);
        }

    }
}
