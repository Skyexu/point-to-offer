/**
 * @Author: Skye
 * @Date: 9:58 2018/6/2
 * @Description: 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 当有两个条件同时满足时，用递归逻辑比较清楚
 */
public class Question53 {
    public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null ) {
            return false;
        }
        int indexStr = 0;
        int indexPt = 0;
        return matchCore(str,pattern,indexStr,indexPt);

    }
    boolean matchCore(char[] str,char[] pattern,int indexStr,int indexPt){
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (indexStr==str.length && indexPt == pattern.length){
            return true;
        }
        //pattern先到尾，匹配失败
        if (indexPt == pattern.length && indexStr != str.length){
            return false;
        }

        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if ((indexPt+1) < pattern.length && pattern[indexPt+1] == '*' ){
            if (indexStr != str.length && (pattern[indexPt] == str[indexStr] || pattern[indexPt] == '.')){
                return matchCore(str,pattern,indexStr+1,indexPt) || matchCore(str,pattern,indexStr+1,indexPt+2)||matchCore(str,pattern,indexStr,indexPt+2);
            }else {
                return matchCore(str,pattern,indexStr,indexPt+2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (indexStr != str.length && (pattern[indexPt] == str[indexStr] || pattern[indexPt]=='.')){
            return matchCore(str,pattern,indexStr+1,indexPt+1);
        }
        return false;
    }

    public static void main(String[] args) {
        Question53 question53 = new Question53();
        //char[] str = new char[]{'a','a','a'};
        //char[] pattern = new char[]{'a','c','a'};
        char[] str = new char[0];
        char[] pattern = new char[]{'.'};
        System.out.println(question53.match(str,pattern));
    }
}
