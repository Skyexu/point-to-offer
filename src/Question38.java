/**
 * @Author: Skye
 * @Date: 10:31 2018/5/22
 * @Description: 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class Question38 {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length == 0){
            return 0;
        }
        int first = getFirstK(array,k,0,array.length-1);
        int last = getLastK(array,k,0,array.length-1);
        if (first > -1 && last > -1){
            return last - first +1;
        }
        return 0;
    }
    public int getFirstK(int[] arr,int k,int start,int end){
        if (start > end){
            return -1;
        }
        int middle = (end + start)/2;
        int middleData = arr[middle];
        if (middleData == k){
            if (middle >0 && arr[middle-1]!=k || middle == 0){
                return middle;
            }else {
                end = middle -1;
            }
        }else if (middleData > k){
            end = middle -1 ;
        }else {
            start = middle + 1;
        }
        return getFirstK(arr,k,start,end);
    }
    public int getLastK(int[] arr,int k,int start,int end){
        if (start > end){
            return -1;
        }
        int middle = (end + start)/2;
        int middleData = arr[middle];
        if (middleData == k){
            if (middle < end && arr[middle+1]!=k || middle == end){
                return middle;
            }else {
                start = middle + 1;
            }
        }else if (middleData < k){
            start = middle + 1 ;
        }else {
            end = middle - 1;
        }
        return getLastK(arr,k,start,end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        Question38 question38 = new Question38();
        System.out.println(question38.GetNumberOfK(arr,3));
    }
}
