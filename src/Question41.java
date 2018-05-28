/**
 * @Author: Skye
 * @Date: 9:33 2018/5/25
 * @Description: 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Question41 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
            // 数组依次异或
            bitResult ^= array[i];
        }
        // 找到结果中第一个 1 出现的位置
        int index = findFirst1(bitResult);
        for (int i = 0; i < array.length; i++) {
            if (isBit1Group(index,array[i])){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
    public int findFirst1(int bitResult){
        int index = 0;
        while ((bitResult & 1) == 0 ){
            bitResult >>= 1;
            index ++;
        }
        return index;
    }
    public boolean isBit1Group(int index,int val){
        if ((1 << index & val) == 0){
            return true;
        }else {
            return false;
        }
    }
}
