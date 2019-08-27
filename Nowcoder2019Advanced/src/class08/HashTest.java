package class08;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class HashTest {

    //设计一个数据结构
    public  static  class  Node{
        public  int value;
        public  Node(int v){
            value = v;
        }
    }

    //重载比较器
    public  static  class Comp implements Comparator<Node> {
        @Override
        public  int compare(Node argo, Node arg1)
        {
            return  argo.value - arg1.value;
        }

    }


    public static void main(String[] args) {




        // 按照离散组织
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(6);
        set.remove(6);
        set.contains(5);

        HashMap<Integer,String> m = new HashMap<>();
        m.put(3,"我是3");
        m.put(3,"我还是3");
        m.remove(3);
        m.containsKey(3);

        //Java 里面的有序表， key 必须是可以比较的结构， 如果自定义数据结构，必须构建比较器，告诉有序表怎么比较
        TreeMap<Node,String> map1 = new TreeMap<>(new Comp());
        Node node1 = new Node(3);
        map1.put(node1,"我是node1");


        ///有序表——在java里面是红黑树实现。 （红黑树，AvL，SB树，调表——4中结构都可以实现有序表， O(logN), 性能指标没有优劣。）
        // 红黑树，AVL，SB树——都是利用平衡搜索树
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(4,"我是4");
        map.put(3,"我是3");
        map.put(7,"我是7");
        map.put(1,"我是1");
        map.put(9,"我是9");
        map.put(6,"我是6");

        map.remove(7);

        System.out.println(map.get(6));
        System.out.println(map.containsKey(6));
        System.out.println(map.firstKey()); //最小key
        System.out.println(map.lastKey()); //最大key
        System.out.println(map.floorKey(5)); //<=5
        System.out.println(map.ceilingKey(5)); //>=5
        System.out.println(map.floorKey(6)); // <=6  输出6 ，因为表里面有
        System.out.println(map.ceilingKey(6));// >=6  输出6 ，因为表里面

        //哈希表 所有的增删改查都是O(1)
        // 有序表 所有的增删改查都是O(logN)


        //遍历有序表
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key +","+value);
        }





    }
}