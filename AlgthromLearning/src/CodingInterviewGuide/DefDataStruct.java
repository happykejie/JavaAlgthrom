package CodingInterviewGuide;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 定义数据结构
public class DefDataStruct {

}

/**
 * 定义树结构
 * */
class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public  TreeNode(int data){
        this.val = data;
    }
}

/**
 * 定义链表结构
 * */
class LinkedNode{
    int val =0;
    LinkedNode next;

    public LinkedNode(int data){
        this.val = data;
    }
}


class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}

class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

