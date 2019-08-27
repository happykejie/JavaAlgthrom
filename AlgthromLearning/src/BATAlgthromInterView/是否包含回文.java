package BATAlgthromInterView;

/**
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 *
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 *
 *
 * 分析： 比如str1="1234" 那么str1+str1 ="12341234" 一定包含它的所有回文
 * */
public class 是否包含回文 {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena !=lenb){
            return false;
        }
        String AA = A+A;
        if(AA.contains(B))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
