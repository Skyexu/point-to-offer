/**
 * @Author: Skye
 * @Date: 10:39 2018/5/29
 * @Description:  翻转单词顺序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Question45 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 1){
            return str;
        }
        char[] chars = str.toCharArray();
        // 先翻转整个句子再翻转单词
        reverse(chars,0,chars.length-1);
        int begin = 0;
        int end = 1;
        while (end < chars.length){
            if (chars[end] != ' '){
                end++;
            }else {
                reverse(chars,begin,--end);
                begin = end + 2;
                end = begin+1;
            }
        }
        reverse(chars,begin,--end);
        return String.valueOf(chars);
    }
    public void reverse(char[] str,int begin,int end){
        while (begin < end){
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        Question45 question45 = new Question45();
        String str = "student. a am I";
        System.out.println(question45.ReverseSentence(str));
    }
}
