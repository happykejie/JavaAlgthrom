package 算法面试通过40讲.数组和矩阵问题;

public class 转圈打印矩阵 {

    public  static  void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};



    }

    public  static  void spiralOrderPrint(int[][] matrix){
        int tr=0;
        int tc=0;
        int dr =matrix.length-1;
        int dc = matrix[0].length-1;

        while (tr<dr && tc<dc){ //一层一层打印，不停缩子矩阵
            printEdge(matrix,tr++, tc++, dr--,dc--);
        }
    }

    public  static  void printEdge(int[][] m,int tr,int tc,int dr,int dc){

        if(tr ==dr){ //只有一行的情况
            for(int i= tc; i<=dc;i++){
                System.out.println(m[tr][i] +" ");
            }
        }

        if(tc ==dc){ //只有一列的情况
            for(int i= tr; i<=tr;i++){
                System.out.println(m[i][tc] +" ");
            }
        }
        else { //一般情况
            int curc = tc;
            int curr = tr;

            while (curc != dc){
                System.out.println(m[tr][curc]+" ");
                curc++;
            }
            while (curr != dr){
                System.out.println(m[tr][curr]+" ");
                curr++;
            }


            while (curc != tc){
                System.out.println(m[tr][curc]+" ");
                curc--;
            }
            while (curr != tr){
                System.out.println(m[tr][curr]+" ");
                curr--;
            }
        }
    }
}
