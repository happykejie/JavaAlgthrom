package 算法面试通过40讲;

import  java.util.*;
public class 图的DFS和BFS {
}



 class Demo_01_DFS {
    //递归版DFS
    public static void DFSbyRecursion(int[][] graph){
        int length = graph.length;
        boolean[] visited = new boolean[length];
        //为了预防图不是连通图的情况，若图为连通图则直接调用DFS，不需要for循环
        for (int i = 0; i < length; i++) {
            if(!visited[i])
                DFS(graph,i,visited);
        }
    }

    public static void DFS(int[][] graph,int vertex,boolean[] visited){
        visited[vertex] = true;
        //遍历该点
        System.out.print(vertex + " ");
        int length = graph.length;
        for (int i = 0; i < length; i++) {
            //找出与vertex相邻的点，进行DFS。找到一个点就DFS,遍历到底了就进行回退（这里注意递归的过程，）
            if(!visited[i] && graph[vertex][i] == 1){
                DFS(graph,i,visited);
            }
        }
    }

    //用栈实现DFS
    public static void DFSbyStack(int[][] graph){
        Stack<Integer> stack = new Stack<>();
        int length = graph.length;
        //判断元素是否被遍历过
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if(!visited[i]){
                stack.push(i);
                visited[i] = true;
                boolean hasNext;
                //遍历第一个点
                System.out.print( i+ " ");
                while(!stack.empty()){
                    //取出栈顶元素
                    int temp = stack.peek();
                    //设置变量来判断是否有新点入栈，没有就弹出栈顶元素，有的话进行下一次循环。
                    hasNext = false;
                    for (int j = 0; j < length; j++) {
                        //找出一个与栈顶元素有连接且没有被遍历的点放入stack中，并遍历该点
                        if(!visited[j] && graph[temp][j] == 1){
                            stack.push(j);
                            visited[j] = true;
                            hasNext = true;
                            //遍历该点
                            System.out.print(j + " ");
                            break;
                        }
                    }
                    //如果没有下一个元素则回溯，删除栈顶元素
                    if (!hasNext){
                        stack.pop();
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0 }
        };
        DFSbyRecursion(graph);
        System.out.println();
        DFSbyStack(graph);
    }
}

