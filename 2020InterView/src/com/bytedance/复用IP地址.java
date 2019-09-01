package com.bytedance;




import java.util.ArrayList;
import java.util.List;

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class 复用IP地址 {

    public  static  List<String> res = new ArrayList<>();

    public static void main(String[] args) {

        /*String rss="25525511135";
        for (int i = 0; i <=rss.length() ; i++) {
            System.out.println(rss.substring(0,i));
        }*/
        System.out.println(RestoreIpAddresses("010010"));
    }



    public static List<String> RestoreIpAddresses(String s) {
        dfs(s, 0, 1, new ArrayList<String>());
        return res;
    }

    public static void dfs(String s, int start, int end,  List<String> r) {
        if (start < 0 || start > s.length() || end < 0 || end > s.length()+1 || r.size() > 4) {
            return;
        }
        if (r.size() == 4 && start == s.length()) {
            String rs = "";
            for (int i = 0; i < r.size(); i++) {
                if (i < r.size() - 1) {
                    rs += r.get(i) + ".";
                } else {
                    rs += r.get(i);
                }
            }
            res.add(rs);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int ends=end+i;
            if (start < 0 || start > s.length() || ends < 0 || ends > s.length()) {
                continue;
            }
            String juge = s.substring(start, ends);
            int jugeint = Integer.valueOf(juge);
            if(juge.charAt(0)=='0'&&juge.length()>1){
                continue;
            }
            if (jugeint <= 255) {
                r.add(juge);
                dfs(s, ends, ends + 1,  r);
                r.remove(r.size()-1);
            }
        }
    }



     class RestoreIpAddresses {
        public ArrayList<String> restoreIpAddresses(String s) {
            ArrayList<String> result = new ArrayList<>();
            if (s.length() > 12 || s.length() < 4) {
                return result;
            }
            int startPartNum = 1;//从第一段开始
            String tmpResultStr = "";//最开始，临时结果集字符串是空串
            //输入的字符串就是原始s
            getIpAddress(s, startPartNum, tmpResultStr, result);
            return result;
        }

        public void getIpAddress(String input, int partsNum, String tmpResultStr, ArrayList<String> resultList) {
            if (input.length() == 0) {
                return;
            }
            /**
             * 第一种判断，如果是最后一段了
             */
            if (partsNum == 4) {//如果此次递归是第四段，也就是最后一段了
                int number = Integer.parseInt(input);//将剩余的source字符串转换成整型，毕竟范围必须是0~255

                if (input.charAt(0) == '0') {//如果剩余这部分的开头是0,而且长度大于1，总体值也不是0，
                    // 意思就是这个输入不是只有一个字符'0'的字符串
                    if ((input.length() == 1 && number == 0) == false) {
                        // 因为长度是2或者3位的输入input字符串，如果开头是0，它是不能作为ip的一部分，所以return跳过这个可能的子集
                        return;
                    }
                }

                if (number <= 255) {
                    //达到了第四段，就必须考虑增加到结果子集了。将前三段的临时str加上这个input组成
                    tmpResultStr = tmpResultStr + input;
                    resultList.add(tmpResultStr);
                    return;
                }
            } else {
                /**
                 * 如果不是最后一段,那就是对1，2，3段的每种可能集都找到，因为每个段可能是1个字符，或者2个字符，或者3个字符
                 */
                //第一种可能，这个端是一个字符，临时结果集末尾增加头部，作为新子集，除了头部字符其他输入，作为新的输入继续递归
                if (input.length() >= 1) {
                    //临时结果集新增这个input输入的头部字符，比如最开始时候，可能第一部分就是一个字符
                    getIpAddress(input.substring(1), partsNum + 1,
                            tmpResultStr + input.substring(0, 1) + ".", resultList);
                }

                //第二种可能，这个端是2个字符，且首字符不是0开始
                if (input.length() >= 2 && input.charAt(0) != '0') {
                    getIpAddress(input.substring(2), partsNum + 1,
                            tmpResultStr + input.substring(0, 2) + ".", resultList);
                }

                //第三种可能，这个端是3个字符，且首字符不是0开始,并且值不大于255
                if (input.length() >= 3 && input.charAt(0) != '0') {
                    //截取这三个字符，计算他的整型值
                    int num = Integer.parseInt(input.substring(0, 3));
                    if (num <= 255) {
                        getIpAddress(input.substring(3), partsNum + 1,
                                tmpResultStr + input.substring(0, 3) + ".", resultList);
                    }

                }
            }
        }


        public  void main(String[] args) {
            String s = "25525511135";
            RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
            for (String a : restoreIpAddresses.restoreIpAddresses(s)) {
                System.out.println(a);
            }
        }
    }



}


