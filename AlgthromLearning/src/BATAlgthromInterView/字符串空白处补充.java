package BATAlgthromInterView;

public class 字符串空白处补充 {

    public  static  void  main(String[] args){

        String testsrt ="Hello  World";
        String result = replaceSpace(testsrt,12);
        System.out.println(result);
    }


    public static String replaceSpace(String iniString, int length) {
        // write code here
        // write code here
        int num = 0;
        for(int i = 0;i<length;i++){
            //判断每一个字符
            if(iniString.charAt(i)==' '){
                num++;
            }
        }
        if(num==0)return iniString;
        int totalLen=length+2*num-1;
        char[] str = new char[totalLen+1];
        for(int i = length-1;i>=0;i--){
            if(iniString.charAt(i)==' '){
                str[totalLen--]='0';
                str[totalLen--]='2';
                str[totalLen--]='%';
            }else {
                str[totalLen--] = iniString.charAt(i);
            }
        }
        return String.valueOf(str);
    }
}
